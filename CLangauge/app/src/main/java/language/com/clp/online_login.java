package language.com.clp;


import android.app.AlarmManager;
import android.app.PendingIntent;

import android.app.ProgressDialog;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.*;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


import java.util.Calendar;

import dmax.dialog.SpotsDialog;
import language.com.clp.BroadcastReceiver.AlarmReceiver;
import language.com.clp.Common.Common;
import language.com.clp.Model.User;

public class online_login extends AppCompatActivity {



    MaterialEditText edtNewUser, edtNewPassword, edtNewEmail;        //sign up
    MaterialEditText edtUser, edtPassword;
    Button btnSignIn;
    Button btnSignUp;
    FirebaseDatabase database;
    DatabaseReference table_user;
    RelativeLayout coordinatorLayout;
    SharedPreferences.Editor editor ;
    ConnectionDetector cd;
    private AdView mAdView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_login);




           MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//BANNER


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
      calendar.set(Calendar.HOUR_OF_DAY,10);
      calendar.set(Calendar.MINUTE,30);
      calendar.set(Calendar.SECOND,0);
      Intent intent=new Intent(online_login.this,AlarmReceiver.class);
      PendingIntent pendingIntent=PendingIntent.getBroadcast(online_login.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

      AlarmManager am=(AlarmManager)this.getSystemService(this.ALARM_SERVICE);

      am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
      AlarmManager.INTERVAL_DAY,pendingIntent);

      }
    private void signIn(final String user, final String pwd) {


        final ProgressDialog progressDialog = new ProgressDialog(online_login.this);
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


                            Toast.makeText(online_login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent homeactivity = new Intent(online_login.this, Home_online.class);
                             Common.currentUser = login;
                            startActivity(homeactivity);
                            finish();
                        } else
                            Toast.makeText(online_login.this, "Wrong Password", Toast.LENGTH_SHORT).show();


                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(online_login.this, "Please Enter the Username", Toast.LENGTH_SHORT).show();


                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(online_login.this, "User Does Not Exist ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void showSignUpDialog() {

        AlertDialog.Builder alertdialog = new AlertDialog.Builder(online_login.this);
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


                final ProgressDialog progressDialog = new ProgressDialog(online_login.this);
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
                            Toast.makeText(online_login.this, "Please Enter the user name.!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (user.getEmail().isEmpty()) {

                            Toast.makeText(online_login.this, "Please Enter the Email!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (user.getPassword().isEmpty()) {

                            Toast.makeText(online_login.this, "Please Enter the Password.!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        progressDialog.dismiss();
                            if (dataSnapshot.child(user.getUserName().toString()).exists())
                                Toast.makeText(online_login.this, "User Already Exist.!", Toast.LENGTH_SHORT).show();
                            else {
                                progressDialog.dismiss();
                                table_user.child(user.getUserName())
                                        .setValue(user);

                                Toast.makeText(online_login.this, "You have successfully registered!", Toast.LENGTH_SHORT).show();

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
        final SpotsDialog dialog = new SpotsDialog(online_login.this,"Loading..");
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

                            Intent homeactivity = new Intent(online_login.this, Home_online.class);
                            Common.currentUser = login;
                            startActivity(homeactivity);
                            finish();
                            dialog.dismiss();
                        } else
                            Toast.makeText(online_login.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            dialog.dismiss();
            }




            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }




    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_rate:
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(online_login.this);
                alertdialog.setTitle("Rate this app");
                alertdialog.setMessage("");
                alertdialog.setIcon(R.drawable.ic_action_star);
                alertdialog.setNegativeButton("Remind Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertdialog.setPositiveButton("Rate Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                        }catch (ActivityNotFoundException activity){
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id =" +getPackageName())));

                        }
                    }
                });
                alertdialog.show();
                break;
            // action with ID action_settings was selected
            case R.id.action_share:
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("Plain/Text");


                Bundle extra = getIntent().getExtras();



                String body= "";

                share.putExtra(Intent.EXTRA_SUBJECT,body);
                share.setData(Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()));
                startActivity(Intent.createChooser(share,"Share Via"));



                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }*/

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

