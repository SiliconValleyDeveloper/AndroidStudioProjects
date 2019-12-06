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


public class Programs extends AppCompatActivity {

    ListView lstSearch;
    private AdView mAdView;
    ArrayAdapter<String> adapter;
    Boolean isrunning;
    String[] data = {
            "Simple Linked List",
            "Singly Circular Linked List",
            "Doubly Linked List",
            "Doubly Circular Linked List",
            "Stack using Array",
            "Stack using Linked List",
            "String is Palindrome or not using Stack",
            "Infix to Postfix",
            "Evaluate value of a Postfix Expression",
            "Queue using Array",
            "Queue using Linked List",
            "Queue using Stacks",
            "Expression parsing using stack",
            "Circular Queue",
            "Dequeue",
            "Tower of Hanoi",
            "Linear Search",
            "Binary Search Tree",
            "Binary Search using Recursion on Unsorted Array",
            "Binary Search on Sorted Array",
            "Recursion to Search an Element in UnsortedArray",
            "Fibonacci series using recursion",
            "Interpolation Search",
            "Hash Table",
            "Depth First Traversal",
            "Breadth First Traversal",
            "Bubble Sort",
            "Sort the N Names in an Alphabetical Order",
            "Selection Sort Recursively",
            "Merge Sort using Recursion",
            "Quick Sort using Recursion",
            "Insertion Sort",
            "Shell Sort without using Recursion",
            "Quick Sort without using Recursion",
            "Combo Sort",
            "Odd Even Sort"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
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
            getSupportActionBar().setTitle("Programs");


        }

        lstSearch = (ListView) findViewById(R.id.lstSearch);
        //edtSearch = (MaterialEditText) findViewById(R.id.search);


        adapter = new ArrayAdapter<String>(this, R.layout.programs_listview, R.id.textview, data);
        lstSearch.setAdapter(adapter);

        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String top = data[position];
                Intent intent = new Intent(Programs.this,open_program.class);
                intent.putExtra("Value",1);
                intent.putExtra("Topic", top);
                intent.putExtra("url", "file:///android_asset/Programs/"+top+".html");
           //     Toast.makeText(Programs.this,top,Toast.LENGTH_SHORT).show();

                startActivity(intent);


            }
        });

    }


    //Intersitial


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
