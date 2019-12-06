package com.changedsac;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
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


public class Questions extends AppCompatActivity {
    private  AdView mAdView;

    ListView lstSearch;
    ArrayAdapter<String> adapter;

    String[] data = {
            "If you are using C language to implement the heterogeneous linked list, what pointer\n" +
                    "type will you use?",
            "Minimum number of queues needed to implement the priority queue?",
            "What is the data structures used to perform recursion?",
            "What are the notations used in Evaluation of Arithmetic Expressions using prefix and\n" +
                    "postfix forms?",
            "Convert the expression ((A + B) * C – (D – E) ^ (F + G)) to equivalent Prefix and\n" +
                    "Postfix notations.",
            "Sorting is not possible by using which of the following methods?\n" +
                    "(a) Insertion" + "(b) Selection" + "(c) Exchange" + "(d) Deletion",
            "In tree construction which is the suitable efficient data structure?\n" +
                    "(a) Array" + "(b) Linked list" + "(c) Stack" + "(d) Queue" + " (e) none",
            "What is the type of the algorithm used in solving the 8 Queens problem?",

            "In an AVL tree, at what condition the balancing is to be done?",
            "There are 8, 15, 13, 14 nodes were there in 4 different trees. Which of them could\n" +
                    "have formed a full binary tree?",
            "Of the following tree structure, which is, efficient considering space and\n" +
                    "time complexities?" +
                    "(a) Incomplete Binary Tree" + "(b) Complete Binary Tree" + "(c) Full Binary Tree",
            "What is a spanning Tree?",
            "Does the minimum spanning tree of a graph give the shortest distance between any 2\n" +
                    "specified nodes?",
            "Which is the simplest file structure?\n" +
                    "(a) Sequential" + "(b) Indexed" + "(c) Random",
            "Whether Linked List is linear or Non-linear data structure?",

            "What is LIFO?",
            "Which data structures are applied when dealing with a recursive function?",
            "What is the difference between a PUSH and a POP?",
            "What is Huffman’s algorithm?",
            "What is FIFO?"








    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final String q1 = "The heterogeneous linked list contains different data types in its nodes and we\n" +
                "need a link, pointer to connect them. It is not possible to use ordinary pointers for this. So\n" +
                "we go for void pointer. Void pointer is capable of storing pointer to any type as it is a\n" +
                "generic pointer type .";


        String q2 = "Two. One queue is used for actual storing of data and another for storing\n" +
                "priorities.";

        String q3 = "Stack. Because of its LIFO (Last In First Out) property it remembers its ‘caller’ so\n" +
                "knows whom to return when the function has to return. Recursion makes use of system\n" +
                "stack for storing the return addresses of the function calls.\nEvery recursive function has its equivalent iterative (non-recursive) function.\n" +
                "Even when such equivalent iterative procedures are written, explicit stack is to be used.";

        String q4 = "Polish and Reverse Polish notations.";

        String q5 = "Prefix Notation:\n" +
                "^ - * +ABC - DE + FG\n" +
                "Postfix Notation:\n" +
                "AB + C * DE - - FG + ^";

        String q6 = "(d) Deletion.\n" +
                "Using insertion we can perform insertion sort, using selection we can perform\n" +
                "selection sort, using exchange we can perform the bubble sort (and other similar sorting\n" +
                "methods). But no sorting method can be done just using deletion.";


        String q7 = "(b) Linked list";
        String q8 = "BackTracking";
        String q9 = "If the ‘pivotal value’ (or the ‘Height factor’) is greater than 1 or less than –1.";
        String q10 = "15.\n" +
                "In general:\n" +
                "There are 2 n -1 nodes in a full binary tree.\n" +
                "By the method of elimination:\n" +
                "Full binary trees contain odd number of nodes. So there cannot be full\n" +
                "binary trees with 8 or 14 nodes, so rejected. With 13 nodes you can form a complete\n" +
                "binary tree but not a full binary tree. So the correct answer is 15.\n" +
                "Note:\n" +
                "Full and Complete binary trees are different. All full binary trees are complete\n" +
                "binary trees but not vice versa.";
        String q11= "(b) Complete Binary Tree.\n" +
                "By the method of elimination:\n" +
                "Full binary tree loses its nature when operations of insertions and deletions\n" +
                "are done. For incomplete binary trees, extra storage is required and overhead of NULL\n" +
                "node checking takes place. So complete binary tree is the better one since the property of\n" +
                "complete binary tree is maintained even after operations like additions and deletions are\n" +
                "done on it.";
        String q12 = "A spanning tree is a tree associated with a network. All the nodes of the graph\n" +
                "appear on the tree once. A minimum spanning tree is a spanning tree organized so that\n" +
                "the total edge weight between nodes is minimized.";
        String q13= "No.\n" +
                "Minimal spanning tree assures that the total weight of the tree is kept at its\n" +
                "minimum. But it doesn’t mean that the distance between any two nodes involved in the\n" +
                "minimum-spanning tree is minimum.";
        String q14= "(a) Sequential";
        String q15= "According to Access strategies Linked list is a linear one.\n" +
                "According to Storage Linked List is a Non-linear one.";


        String q16 = "LIFO is a short form of Last In First Out. It refers how data is accessed, stored and retrieved. Using this scheme, data that was stored last should be the" +
                " one to be extracted first." +
                " This also means that in order to gain access to the first data, all the other data that was stored before this first data must first be retrieved and extracted.";
        String q17 = "Recursion, is a function that calls itself based on a terminating condition, makes use of the stack. Using LIFO, a call to a recursive function saves" +
                " the return address so that it knows how to return to the calling function after the call terminates.";


        String q18 = "Pushing and popping applies to the way data is stored and retrieved in a stack. A push denotes data being added to it, meaning data is being “pushed” into the stack. On the other hand, a pop denotes data retrieval," +
                " and in particular, refers to the topmost data being accessed.";


        String q19 = "Huffman’s algorithm is used for creating extended binary trees that have minimum weighted path lengths from the given weights. It makes use of a table that contains the frequency of occurrence for each data element.";


        String q20 = "FIFO stands for First-in, First-out, and is used to represent how data is accessed in a queue. Data has been inserted into the queue list the longest is the one that is removed first.";

        final String [] answer = {q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20};




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
            getSupportActionBar().setTitle("Interview Questions");

        }

        lstSearch = (ListView) findViewById(R.id.lstSearch);
        //edtSearch = (MaterialEditText) findViewById(R.id.search);


        adapter = new ArrayAdapter<String>(this, R.layout.question_listview, R.id.textview, data);
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
                final String top = answer[position];

                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(Questions.this);
                alertdialog.setTitle("Answer");
                alertdialog.setMessage(top);
                alertdialog.setIcon(R.drawable.inter);
                alertdialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                });
                alertdialog.show();
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
