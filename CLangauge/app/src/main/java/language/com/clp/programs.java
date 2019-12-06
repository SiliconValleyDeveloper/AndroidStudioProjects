package language.com.clp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class programs extends AppCompatActivity {

    private Boolean isrunning;
    private AdView mAdView;
    ListView lstSearch;

   // MaterialEditText edtSearch;
    ArrayAdapter<String> adapter;
    String[] data = {
            "Hello World",
            "Print Integer",
            "Addition of two Number",
            "Area of triangle",
            "Odd or Even",
            "Add subtract multiply divide",
            "Add n numbers",
            "Add digits",
            "Greatest of 3 numbers",
            "Swapping two numbers",
            "Nested If Else",
            "Calculate percentage",
            "Calculate Gross salary",
            "Simple interest",
            "Area of Circle",
            "Area of Rectangle",
            "Area of Square",
            "Volume of Cube",
            "Volume of Cylinder",
            "Volume of Sphere",
            "Check vowel",
            "Leap year",
            "HCF and LCM",
            "nCr and nPr",
            "Reverse number",
            "Reverse number using array",
            "Palindrome number",
            "Prime numbers",
            "Perfect Number",
            "Find armstrong number",
            "Generate armstrong number",
            "Temperature conversion",
            "Factorial using function",
            "Fibonacci series using loop",
            "Fibonacci series using recursion",
            "Print Pattern",
            "Diamond pattern",
            "Maximum element in array",
            "Minimum element in array",
            "Insert element in array",
            "Merge arrays",
            "Add matrices",
            "Subtract matrices",
            "Transpose matrix",
            "Multiply two matrices",
            "Print string",
            "String length",
            "Compare strings",
            "Copy string",
            "Concatenate strings",
            "Reverse string",
            "Find palindrome",
            "Change case",
            "C substring",
            "Sort a string",
            "Remove space",
            "Addition using pointers",
            "Reverse array using Pointer",
            "Length of string using Pointer",
            "Structure",
            "Union",
            "Read file",
            "Copy files",
            "Call by Reference",
            "Call by Value",
            "Swap 2 no without 3rd variable"
    };







   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_rate:
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(programs.this);
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

                break;
            default:
                break;
        }

        return  true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);



           MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        lstSearch = (ListView) findViewById(R.id.lstSearch);

        adapter = new ArrayAdapter<String>(this, R.layout.programs_list_item, R.id.textview, data);
    //    final programs.CustomAdapter customAdapter = new programs.CustomAdapter();
        lstSearch.setAdapter(adapter);

        lstSearch.setTextFilterEnabled(true);

        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String top = data[position];


                Intent intent = new Intent(programs.this,open_tutorial.class);
                intent.putExtra("Topic", top);
                intent.putExtra("url", "file:///android_asset/programs/"+top+".html");
                startActivity(intent);

            }


        });

        }

    @Override
    public void onBackPressed() {
        finish();

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


