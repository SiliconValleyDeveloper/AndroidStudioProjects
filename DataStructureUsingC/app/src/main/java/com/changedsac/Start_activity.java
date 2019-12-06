package com.changedsac;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class Start_activity extends AppCompatActivity {

    boolean isRunning;
    private InterstitialAd mInterstitialAd;

    CardView data_structure,algorithms,searching,sorting,Problem,
            programs,online_quiz,questions,Graph,Point_to_remember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);





        //interstitial
        mInterstitialAd = new InterstitialAd(Start_activity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2783298230694780/3376231909");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        data_structure = (CardView)findViewById(R.id.data_structure);
        algorithms = (CardView)findViewById(R.id.algorithms);
        searching = (CardView)findViewById(R.id.searching);
        sorting = (CardView)findViewById(R.id.sorting);
        programs = (CardView)findViewById(R.id.programs);
        online_quiz = (CardView)findViewById(R.id.online_quiz);
        questions = (CardView)findViewById(R.id.questions);
        Graph = (CardView)findViewById(R.id.Graph);
        Problem = (CardView)findViewById(R.id.about);

        Point_to_remember = (CardView)findViewById(R.id.Point_to_remember);



        data_structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this,Data_Structure.class);
                startActivity(intent);

            }
        });

        algorithms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this,Algorithm.class);
                startActivity(intent);
            }
        });

        searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this,Searching.class);
                startActivity(intent);
            }
        });
        sorting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this,Sorting.class);
                startActivity(intent);
            }
        });

        programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this,Programs.class);
                startActivity(intent);
            }
        });

        online_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent( Start_activity.this,Online_Login.class);
                startActivity(intent);
            }
        });

          questions.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                  mediaPlayer.start();
                  Intent intent = new Intent( Start_activity.this,Questions.class);
                  startActivity(intent);
              }
          });
        Graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent( Start_activity.this,gds.class);
                startActivity(intent);
            }
        });
        Point_to_remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(Start_activity.this, Point_to_remember.class);
                startActivity(intent);
            }
        });

        Problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_activity.this, R.raw.button);

                mediaPlayer.start();
                mediaPlayer.stop();


                if (isRunning && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }


                Toast.makeText(Start_activity.this,"Updated Soon..",Toast.LENGTH_SHORT).show();


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

}
