package language.com.clp;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;


    CardView tutorial, questions, offline_quiz, online_quiz, programs, about_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

          tutorial = (CardView) findViewById(R.id.tutorial);
        questions = (CardView) findViewById(R.id.questions);
        offline_quiz = (CardView) findViewById(R.id.offline_quiz);
        online_quiz = (CardView) findViewById(R.id.online_quiz);
        programs = (CardView) findViewById(R.id.programs);
        about_c = (CardView) findViewById(R.id.about_c);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, Tutorial.class);

                startActivity(intent);

            }
        });

        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, all_question.class);

                startActivity(intent);
            }
        });

        offline_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, offline_quiz.class);

                startActivity(intent);

            }
        });

        online_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, online_login.class);

                startActivity(intent);

            }
        });

        programs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, programs.class);

                startActivity(intent);

            }
        });
        about_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.button);
                mediaPlayer.start();
                Intent intent = new Intent(MainActivity.this, About_C.class);

                startActivity(intent);

            }
        });

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

