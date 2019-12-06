package language.com.clp;

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
import language.com.clp.Common.Common;
import language.com.clp.Model.QuestionScore;

public class online_done extends AppCompatActivity {

    Button btnTryAgain, share, logout;
    ProgressBar progressBar;
    TextView txtResultScore, getTxtResultQuestion;

    FirebaseDatabase database;
    DatabaseReference question_score;

    Boolean isrunning;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_done);


        //banner
         MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2783298230694780/9407287785");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


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
            public void onClick(View view) {
                final SpotsDialog dialog = new SpotsDialog(online_done.this, "Loading..");
                dialog.show();

                Intent intent = new Intent(online_done.this, Home_online.class);


                dialog.dismiss();
                startActivity(intent);
                finish();

            }
        });


//get data from bundle and set of view


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


                final SpotsDialog dialog = new SpotsDialog(online_done.this, "Loading..");
                dialog.show();

                if (isrunning && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    dialog.dismiss();

                } else {

                    Intent intent = new Intent(online_done.this, online_login.class);

                    SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = loginData.edit();
                    editor.clear();

                    editor.commit();
                    Toast.makeText(online_done.this, "Logout Successful", Toast.LENGTH_SHORT).show();

                    //interstitial.show();
                    startActivity(intent);
                    finish();

                    dialog.dismiss();
                }
            }

        });

    }


    @Override
    public void onBackPressed() {
        finish();

    }

    //fullscreen app
    private void ShowAds() {

        if (isrunning && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }


    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        isrunning=false;
        super.onStop();
    }

    @Override
    protected void onStart() {
        isrunning=true;
        super.onStart();
    }
}

