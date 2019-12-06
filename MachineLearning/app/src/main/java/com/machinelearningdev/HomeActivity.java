package com.machinelearningdev;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class HomeActivity extends AppCompatActivity {

    CardView tutorial,code,project,appendices,faq,about;
    Boolean isRunning;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       MobileAds.initialize(this, new OnInitializationCompleteListener() {
           @Override
           public void onInitializationComplete(InitializationStatus initializationStatus) {

           }
       });


        tutorial = (CardView)findViewById(R.id.tutorial);
        code = (CardView)findViewById(R.id.code);
        project = (CardView)findViewById(R.id.project);
        appendices = (CardView)findViewById(R.id.appendices);
        faq = (CardView)findViewById(R.id.faq);
        about = (CardView)findViewById(R.id.about);



        //interstitial
        mInterstitialAd = new InterstitialAd(HomeActivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2783298230694780/8224739067");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent open_tutorial = new Intent(HomeActivity.this,Tutorial.class);
                startActivity(open_tutorial);

            }
        });

        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent open_code= new Intent(HomeActivity.this,Code.class);
                startActivity(open_code);



            }
        });

        project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_project= new Intent(HomeActivity.this,Project.class);
                startActivity(open_project);


            }
        });
        appendices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_Appendices= new Intent(HomeActivity.this,Appendices.class);
                startActivity(open_Appendices);

            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Updated soon", Toast.LENGTH_SHORT).show();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
                Toast.makeText(HomeActivity.this, "Updated soon", Toast.LENGTH_SHORT).show();

            }
        });
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

    @Override
    protected void onResume() {
        isRunning=true;
        super.onResume();
    }
}
