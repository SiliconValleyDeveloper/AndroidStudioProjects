package com.changedsac;


import com.changedsac.Model.QuestionScore;
import com.changedsac.ViewHolder.ScoreDetailViewHolder;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import dmax.dialog.SpotsDialog;

public class ScoreDetails extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference question_score;
    RecyclerView scoreList ;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<QuestionScore,ScoreDetailViewHolder> adapter ;
    String viewUser = "";
    TextView dp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


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
}
