package language.com.clp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class open_tutorial extends AppCompatActivity {

    WebView webview;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_tutorial);


           MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
          mAdView = findViewById(R.id.adView);
          AdRequest adRequest = new AdRequest.Builder().build();
          mAdView.loadAd(adRequest);




        webview = (WebView) findViewById(R.id.webview);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            String Topic = getIntent().getStringExtra("Topic");

            getSupportActionBar().setTitle(Topic);


            if (getIntent() != null) {
                String info = getIntent().getStringExtra("url");
                webview.loadUrl(info);
                webview.getSettings().setBuiltInZoomControls(true);
                webview.getSettings().setSupportZoom(true);
            }else {
                Toast.makeText(open_tutorial.this, "Error to load", Toast.LENGTH_SHORT).show();
                finish();
        }
        }


    }



    @Override
    public void onBackPressed() {
       finish();
        super.onBackPressed();
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





