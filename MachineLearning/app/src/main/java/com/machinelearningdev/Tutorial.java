package com.machinelearningdev;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Tutorial extends AppCompatActivity {

    ListView listView;
    private AdView mAdView;

    ArrayAdapter<String> adapter;
    String[] data = {
            "Introduction, Regression Analysis and Gradient Descent",
            "Linear Algebra - review",
            "Linear Regression with Multiple Variables",
            "Octave[incomplete]",
            "Logistic Regression",
            "Regularization",
            "Neural Networks - Representation",
            "Neural Networks - Learning",
            "Advice for applying machine learning techniques",
            "Machine Learning System Design",
            "Support Vector Machines",
            "Support Vector Machines",
            "Clustering",
            "Dimensionality Reduction",
            "Anomaly Detection",
            "Recommender Systems",
            "Large Scale Machine Learning",
            "Application Example - Photo OCR",
            "Course Summary"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Machine Learning");
        }

        listView = (ListView)findViewById(R.id.lstView);
        adapter = new ArrayAdapter<String>(this,R.layout.tutorial_listview,R.id.textview,data);
        listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final String topic = data[position];
               Intent intent = new Intent(Tutorial.this,Open_tutorial.class);
               intent.putExtra("Topic", topic);
               intent.putExtra("url", "file:///android_asset/Machine_learning_complete/"+topic+".html");
               //   Toast.makeText(Algorithm.this,top,Toast.LENGTH_SHORT).show();
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


