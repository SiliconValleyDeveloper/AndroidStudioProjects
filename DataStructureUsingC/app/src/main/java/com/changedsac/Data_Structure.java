package com.changedsac;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Data_Structure extends AppCompatActivity {


    private AdView mAdView;
    ListView lstSearch;
    ArrayAdapter<String> adapter;
    String[] data = {
            "Data Structure Overview",
            "Data Structure Basics",
            "Arrays",
            "Linked list",
            "Doubly linked list",
            "Circular linked list",
            "Stack",
            "Expression Parsing",
            "Queue",
            "Trees",
            "Tree Traversal",
            "Binary Search Tree",
            "AVL Tree",
            "Spanning Tree",
            "Graph Data Structure"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__structure);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Data Structure");


        }

        lstSearch = (ListView) findViewById(R.id.lstSearch);
        //edtSearch = (MaterialEditText) findViewById(R.id.search);


        adapter = new ArrayAdapter<String>(this, R.layout.datastructure_listview, R.id.textview, data);
        lstSearch.setAdapter(adapter);
        /*edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Tutorial.this.adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
*/
        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String top = data[position];
                    Intent intent = new Intent(Data_Structure.this, open_data_structure.class);
                    intent.putExtra("Topic", top);
                    intent.putExtra("url", "file:///android_asset/tutorial/" + top + ".html");
                    //Toast.makeText(Data_Structure.this, top, Toast.LENGTH_SHORT).show();
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
