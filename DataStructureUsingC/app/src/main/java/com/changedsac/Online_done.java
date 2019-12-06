package com.changedsac;


import com.changedsac.Common.Common;
import com.changedsac.Model.QuestionScore;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import dmax.dialog.SpotsDialog;

public class Online_done extends AppCompatActivity {

    Button btnTryAgain, share, logout;
    ProgressBar progressBar;
    TextView txtResultScore, getTxtResultQuestion;

    FirebaseDatabase database;
    DatabaseReference question_score;
    private AdView mAdView_one,mAdView_two;
    private InterstitialAd mInterstitialAd;
    Boolean isRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_done);



        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });



        mAdView_one = findViewById(R.id.adView_one);
        mAdView_two = findViewById(R.id.adView_two);

        //Banner
        AdRequest adRequest_one = new AdRequest.Builder().build();
        AdRequest adRequest_two= new AdRequest.Builder().build();
        mAdView_one.loadAd(adRequest_one);
        mAdView_two.loadAd(adRequest_two);

        //FullScreen

        //interstitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2783298230694780/3376231909");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        //another process
        share = (Button) findViewById(R.id.share);
        logout = (Button) findViewById(R.id.Logout);
        database = FirebaseDatabase.getInstance();
        question_score = database.getReference("Question_Score");
        txtResultScore = (TextView) findViewById(R.id.txtTotalScore);
        getTxtResultQuestion = (TextView) findViewById(R.id.txtTotalQuestion);
        progressBar = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SpotsDialog dialog = new SpotsDialog(Online_done.this,"Loading..");
                dialog.show();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (isRunning && mInterstitialAd.isLoaded()) {
                    dialog.dismiss();
                    mInterstitialAd.show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {
                    Intent intent = new Intent(Online_done.this, Home_Online.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    dialog.dismiss();
                    startActivity(intent);
                    finish();
                }

            }
        });

        Bundle extra = getIntent().getExtras();
        if (extra != null) {

            int score = extra.getInt("SCORE");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");
            getTxtResultQuestion.setText(String.format("Attempt Questions : %d / %d", correctAnswer, totalQuestion));
            txtResultScore.setText(String.format("Score :%d", score));
            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);
            //upload point of DB
            question_score.child(String.format("%s_%s", Common.currentUser.getUserName(),
                    Common.categoryId))
                    .setValue(new QuestionScore(String.format("%s_%s", Common.currentUser.getUserName(),
                            Common.categoryId), Common.currentUser.getUserName(), String.valueOf(score), Common.categoryId, Common.categoryName));
        }

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("Plain/Text");
                Bundle extra = getIntent().getExtras();
                int score = extra.getInt("SCORE");
                String body = "Hey,Try this App i will Score:" + String.valueOf(score) + " Marks in this App and you also try to Score higher .\n" + Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
                share.putExtra("android.intent.extra.TEXT", body);
                share.putExtra("android.intent.extra.SUBJECT", "C Programming");
                startActivity(Intent.createChooser(share, "Share Via"));


            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final SpotsDialog dialog = new SpotsDialog(Online_done.this, "Loading..");
                dialog.show();


                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (isRunning && mInterstitialAd.isLoaded()) {
                    dialog.dismiss();
                    mInterstitialAd.show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                } else {

                    Intent logout = new Intent(Online_done.this, Online_Login.class);
                    SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = loginData.edit();
                    editor.clear();
                    editor.commit();

                    Toast.makeText(Online_done.this, "Logout Successful", Toast.LENGTH_SHORT).show();

                    logout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(logout);
                    finish();

                    dialog.dismiss();


                }
            }

        });
    }



    //fullscreen ap

    @Override
    public void onBackPressed() {
        finish();
    }


    //fullscreen app
    private void ShowAds() {

        if (isRunning && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }


    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView_one!= null && mAdView_two!=null) {
            mAdView_one.pause();
            mAdView_two.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView_one != null && mAdView_two!=null) {

            mAdView_one.resume();
            mAdView_two.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView_one != null && mAdView_two!=null) {
            mAdView_one.destroy();
            mAdView_two.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isRunning=true;
    }

}

