package language.com.clp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import dmax.dialog.SpotsDialog;
import language.com.clp.Model.QuestionScore;
import language.com.clp.ViewHolder.ScoreDetailViewHolder;

public class ScoreDetails extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference question_score;
    RecyclerView scoreList ;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<QuestionScore,ScoreDetailViewHolder> adapter ;
    String viewUser = "";
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_details);



           MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
         //**********banner************


        database = FirebaseDatabase.getInstance();
        question_score = database.getReference("Question_Score");



        scoreList = (RecyclerView)findViewById(R.id.scorelist);
        scoreList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        scoreList.setLayoutManager(layoutManager);


        if(getIntent()!=null){
            viewUser = getIntent().getStringExtra("viewUser");
        }
        if(!viewUser.isEmpty()){
            loadScoreDetail(viewUser);
        }


    }



    private void loadScoreDetail(String viewUser) {
        final SpotsDialog dialog = new SpotsDialog(ScoreDetails.this,"Loading..");
        dialog.show();


        adapter = new FirebaseRecyclerAdapter<QuestionScore, ScoreDetailViewHolder>(
                QuestionScore.class,R.layout.score_detail_layout,ScoreDetailViewHolder.class
                ,question_score.orderByChild("user").equalTo(viewUser)) {
            @Override
            protected void populateViewHolder(ScoreDetailViewHolder viewHolder, QuestionScore model, int position) {
               dialog.dismiss();
                viewHolder.txt_name.setText(model.getCategoryName());
               viewHolder.txt_score.setText(model.getScore());

            }
        };
        adapter.notifyDataSetChanged();
        scoreList.setAdapter(adapter);


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
