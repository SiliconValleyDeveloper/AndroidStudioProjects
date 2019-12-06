package language.com.clp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class offline_quiz extends AppCompatActivity {

    ImageView first_category,second_category,third_category,fourth_category,
    fiveth_category,sixth_category,seven_category,eight_category;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_quiz);

         MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        //FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));


        }

        first_category = (ImageView)findViewById(R.id.first_category);
        second_category = (ImageView)findViewById(R.id.second_category);
        third_category = (ImageView)findViewById(R.id.third_category);
        fourth_category= (ImageView)findViewById(R.id.fourth_category);
        fourth_category= (ImageView)findViewById(R.id.fourth_category);
        fiveth_category = (ImageView)findViewById(R.id.fiveth_category);
        sixth_category = (ImageView)findViewById(R.id.sixth_category);
        seven_category = (ImageView)findViewById(R.id.seven_category);
        eight_category = (ImageView)findViewById(R.id.eight_category);



        first_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_quiz.this,offline_start.class);
                startActivity(intent);
            }

        });


        second_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_quiz.this,Start_offline_two.class);
                startActivity(intent);

            }

        });
        third_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_quiz.this,Start_offline_four.class);
                startActivity(intent);
            }

        });
        fourth_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(offline_quiz.this,Start_offline_three.class);
                startActivity(intent);
            }

        });

        fiveth_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(offline_quiz.this,"Updated soon",Toast.LENGTH_SHORT).show();
            }
        });
        sixth_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(offline_quiz.this,"Updated soon",Toast.LENGTH_SHORT).show();
            }
        });
        seven_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(offline_quiz.this,"Updated soon",Toast.LENGTH_SHORT).show();
            }
        });
        eight_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(offline_quiz.this,"Updated soon",Toast.LENGTH_SHORT).show();
            }
        });

    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_rate:
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(offline_quiz.this);
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



                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }*/


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
