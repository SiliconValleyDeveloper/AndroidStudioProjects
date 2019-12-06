package com.changedsac;

import android.app.ProgressDialog;


import com.changedsac.Common.Common;
import com.changedsac.Interface.ItemClickListener;
import com.changedsac.Interface.RankingCallBack;
import com.changedsac.Model.QuestionScore;
import com.changedsac.Model.Ranking;
import com.changedsac.ViewHolder.RankingViewHolder;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class RankingFragment extends Fragment {

    RecyclerView rankinglist;
    LinearLayoutManager layoutManager;
    FirebaseRecyclerAdapter<Ranking, RankingViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference questionScore,rankingTbl;
    int sum=0;

    View myFragment;





    public static RankingFragment newInstance() {
        RankingFragment rankingFragment = new RankingFragment();
        return rankingFragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        database=FirebaseDatabase.getInstance();
        questionScore=database.getReference("Question_Score");
        rankingTbl=database.getReference("Ranking");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);


        rankinglist = (RecyclerView) myFragment.findViewById(R.id.rankinglist);
        layoutManager = new LinearLayoutManager(getActivity());
        rankinglist.setHasFixedSize(true);


        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        rankinglist.setLayoutManager(layoutManager);


        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading..");
        progressDialog.show();
      updateScore(Common.currentUser.getUserName(), new RankingCallBack<Ranking>() {

            @Override
            public void callBack(Ranking ranking) {
                rankingTbl.child(ranking.getUserName())
                        .setValue(ranking);
               // showRanking();
            }
        });

        adapter = new FirebaseRecyclerAdapter<Ranking, RankingViewHolder>(
                Ranking.class, R.layout.layout_ranking,
                RankingViewHolder.class,
                rankingTbl.orderByChild("score")
        ) {
            @Override
            protected void populateViewHolder(RankingViewHolder viewHolder, final Ranking model, int position) {
                progressDialog.dismiss();
                viewHolder.txt_name.setText(model.getUserName());
                viewHolder.txt_score.setText(String.valueOf(model.getScore()));
                //fixed to crash  when click to item
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {


                        Intent score_detail = new Intent(getActivity(),ScoreDetails.class);
                        score_detail.putExtra("viewUser",model.getUserName());
                        startActivity(score_detail);

                    }
                });
            }

        };

        adapter.notifyDataSetChanged();
        rankinglist.setAdapter(adapter);
        return myFragment;
    }




    private void showRanking() {
        rankingTbl.orderByChild("score")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot data : dataSnapshot.getChildren()){

                            Ranking local = data.getValue(Ranking.class);
                            Log.d("Debug",local.getUserName());


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




    }

    private void updateScore(final String userName,final RankingCallBack<Ranking> callBack
    ) {

        questionScore.orderByChild("user").equalTo(userName)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        for(DataSnapshot data:dataSnapshot.getChildren()){
                            QuestionScore ques = data.getValue(QuestionScore.class);
                            sum+=Integer.parseInt(ques.getScore());
                        }
                        //sum of all the integer
                        Ranking ranking = new Ranking(userName,sum);
                        callBack.callBack(ranking);


                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



    }


}
