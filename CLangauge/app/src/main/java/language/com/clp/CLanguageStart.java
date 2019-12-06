package language.com.clp;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import dmax.dialog.SpotsDialog;

public class CLanguageStart extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clanguage_start);
        final SpotsDialog dialog = new SpotsDialog(CLanguageStart.this,"Loading..");
        dialog.show();



        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    finish();
                                   dialog.cancel();
                                    dialog.dismiss();

                                }
                            },
                2000L); //3000 L = 3 }


    }

}
