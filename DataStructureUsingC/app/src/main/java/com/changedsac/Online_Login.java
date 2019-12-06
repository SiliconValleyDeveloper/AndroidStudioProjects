package com.changedsac;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;


import com.changedsac.BroadcastReceiver.AlarmReceiver;
import com.changedsac.Model.User;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.changedsac.Common.Common;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


import java.util.Calendar;

import dmax.dialog.SpotsDialog;

public class Online_Login extends AppCompatActivity {


    private AdView mAdView;

    MaterialEditText edtNewUser, edtNewPassword, edtNewEmail;        //sign up
    MaterialEditText edtUser, edtPassword;
    Button btnSignIn;
    Button btnSignUp;
    FirebaseDatabase database;
    DatabaseReference table_user;
    RelativeLayout coordinatorLayout;
    SharedPreferences.Editor editor ;
    ConnectionDetector cd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online__login);






        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        cd=new ConnectionDetector(this);
        registerAlarm();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Firebase
        database = FirebaseDatabase.getInstance();
        table_user = database.getReference("User");
        btnSignUp = (Button) findViewById(R.id.btn_sign_up);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);

        coordinatorLayout = (RelativeLayout) findViewById(R.id.coordinatorlayout);


        cd=new ConnectionDetector(this);


        if(cd.isConnected()) {
            getData();


            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    edtUser = (MaterialEditText) findViewById(R.id.edtUser);
                    edtPassword = (MaterialEditText) findViewById(R.id.edtPassword);


                    signIn(edtUser.getText().toString(),
                            edtPassword.getText().toString()
                    );


                }
            });
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    showSignUpDialog();
                }


            });
        }else {
            final Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, " Your Internet are not Working", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Please Check the Mobile data.!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
        }

    }



    private void registerAlarm() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,12);
        calendar.set(Calendar.MINUTE,60);
        calendar.set(Calendar.SECOND,0);
        Intent intent=new Intent(Online_Login.this,AlarmReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(Online_Login.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager am=(AlarmManager)this.getSystemService(this.ALARM_SERVICE);

        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent);

    }
    private void signIn(final String user, final String pwd) {


        final ProgressDialog progressDialog = new ProgressDialog(Online_Login.this);
        progressDialog.setMessage("Please wait..");

        progressDialog.show();


        table_user.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                progressDialog.dismiss();
                if (dataSnapshot.child(user).exists()) {
                    if (!user.isEmpty()) {
                        User login = dataSnapshot.child(user).getValue(User.class);
                        if (login.getPassword().equals(pwd)) {


                            SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                            editor = loginData.edit();
                            editor.putString("UserName", edtUser.getText().toString());
                            editor.putString("Password", edtPassword.getText().toString());
                            editor.apply();


                            Toast.makeText(Online_Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent homeactivity = new Intent(Online_Login.this, Home_Online.class);
                            Common.currentUser = login;
                            startActivity(homeactivity);
                            finish();
                        } else
                            Toast.makeText(Online_Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();


                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(Online_Login.this, "Please Enter the Username", Toast.LENGTH_SHORT).show();


                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(Online_Login.this, "User Does Not Exist ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showSignUpDialog() {

        AlertDialog.Builder alertdialog = new AlertDialog.Builder(Online_Login.this);
        alertdialog.setTitle("Sign Up");
        alertdialog.setMessage("Please Full Fill Information");

        LayoutInflater inflater = getLayoutInflater();
        final View sign_up_layout = inflater.inflate(R.layout.sign_btn, null);
        edtNewUser = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewUserName);
        edtNewPassword = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewPassword);
        edtNewEmail = (MaterialEditText) sign_up_layout.findViewById(R.id.edtNewEmail);


        alertdialog.setView(sign_up_layout);
        alertdialog.setIcon(R.drawable.ic_action_account);

        alertdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alertdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                final ProgressDialog progressDialog = new ProgressDialog(Online_Login.this);
                progressDialog.setMessage("Please wait..");
                progressDialog.show();


                final User user = new User(edtNewUser.getText().toString()
                        , edtNewPassword.getText().toString(), edtNewEmail.getText().toString());


                table_user.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        progressDialog.dismiss();
                        if (user.getUserName().isEmpty()) {

                            progressDialog.dismiss();
                            Toast.makeText(Online_Login.this, "Please Enter the user name.!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (user.getEmail().isEmpty()) {

                            Toast.makeText(Online_Login.this, "Please Enter the Email!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (user.getPassword().isEmpty()) {

                            Toast.makeText(Online_Login.this, "Please Enter the Password.!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        progressDialog.dismiss();
                        if (dataSnapshot.child(user.getUserName().toString()).exists())
                            Toast.makeText(Online_Login.this, "User Already Exist.!", Toast.LENGTH_SHORT).show();
                        else {
                            progressDialog.dismiss();
                            table_user.child(user.getUserName())
                                    .setValue(user);

                            Toast.makeText(Online_Login.this, "You have successfully registered!", Toast.LENGTH_SHORT).show();

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                dialogInterface.dismiss();
            }
        });
        alertdialog.show();
    }







    public void getData(){
        final SpotsDialog dialog = new SpotsDialog(Online_Login.this,"Loading..");
        dialog.show();
        table_user.addListenerForSingleValueEvent(new ValueEventListener() {

            SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            String user= loginData.getString("UserName", "");
            String pwd = loginData.getString("Password","");

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (dataSnapshot.child(user).exists()) {
                    if (!user.isEmpty()) {
                        User login = dataSnapshot.child(user).getValue(User.class);
                        if (login.getPassword().equals(pwd)) {

                            Intent homeactivity = new Intent(Online_Login.this, Home_Online.class);
                             Common.currentUser = login;
                            startActivity(homeactivity);
                            finish();
                            dialog.dismiss();
                        } else
                            Toast.makeText(Online_Login.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
                dialog.dismiss();
            }




            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //BANNER


    }

    @Override
    public void onBackPressed() {

        finish();
    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView!= null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


}
