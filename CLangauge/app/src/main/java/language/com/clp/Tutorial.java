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

public class Tutorial extends AppCompatActivity {





    ListView lstSearch;

    ArrayAdapter<String> adapter;
    String[] data = {
            "Introduction",
            "Advantages of C",
            "Structure of program",
            "Variables",
            "Operators",
            "Formatted IO - printf & scanf",
            "Chracter IO - getchar & putchar",
            "Conditional branching - if",
            "Conditional selection - switch",
            "Loops - while & for",
            "Local Jumps goto",
            "Break and Continue",
            "Function Basics",
            "Defination & Declaration",
            "Standard Header Files",
            "Blocks and Scope",
            "Variable Storage Classes",
            "Definition & Declaration",
            "Initialisation of Variables",
            "Arrays",
            "Pointer",
            "String",
            "Structure",
            "Union",
            "File Operations and Functions",
            "C Preprocessor directives"

    };


   private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);




         MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);








        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        lstSearch = (ListView) findViewById(R.id.lstSearch);


        adapter = new ArrayAdapter<String>(this, R.layout.tutorial_list_item, R.id.textview, data);
        lstSearch.setAdapter(adapter);


        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String top = data[position];
                Intent intent = new Intent(Tutorial.this, open_tutorial.class);
                intent.putExtra("Topic", top);
                intent.putExtra("url", "file:///android_asset/tutorial/" + top + ".html");
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


