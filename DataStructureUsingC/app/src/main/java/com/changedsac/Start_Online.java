package com.changedsac;


import com.changedsac.Common.Common;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.changedsac.Model.Question;

public class Start_Online extends AppCompatActivity {

    int i=1;
    Button btnPlay;
    //firebase
    FirebaseDatabase database;
    DatabaseReference Question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__online);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        database=FirebaseDatabase.getInstance();
        Question=database.getReference("Questions");
        loadQuestion(Common.categoryId);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       Intent intent=new Intent(Start_Online.this,Online_Playing.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }

    private void loadQuestion(String categoryId) {


        //if question are old its means they list are not clear
        if (Common.questionList.size() > 0)
            Common.questionList.clear();



        Question.orderByChild("CategoryId").equalTo(categoryId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            Question ques = postSnapshot.getValue(Question.class);
                            Common.questionList.add(ques);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });





    }
}
