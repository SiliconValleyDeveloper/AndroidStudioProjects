package com.changedsac;


import com.changedsac.Common.Common;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Online_Playing extends AppCompatActivity implements View.OnClickListener {
    final static long INTERVAL = 20000;// 20 second
    final static long TIMEOUT = 120000;// 2 ,min
    int progressValue = 0;
    CountDownTimer mcountDown;


    RadioGroup radioGroup;
    //Firebase
    FirebaseDatabase database;
    DatabaseReference question;
    ProgressBar progressBar;
    ImageView question_image;
    RadioButton r1, r2, r3, r4;
    ProgressBar progress_ques;
    TextView txtScore, txtQuestionNum, question_text;
    int index = 0, score = 0, thisQuestion = 0, totalQuestion, correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online__playing);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        radioGroup = findViewById(R.id.radioGroup);
        //views
        question_image = (ImageView) findViewById(R.id.question_image);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(question_image);
        photoViewAttacher.update();


        question_text = (TextView) findViewById(R.id.question_text);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progress_ques = (ProgressBar) findViewById(R.id.progressbar);
        progress_ques.setMax(100);
        progress_ques.setVisibility(View.GONE);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtQuestionNum = (TextView) findViewById(R.id.txtTotalQuestion);
        question_text = (TextView) findViewById(R.id.question_text);


        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);


        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(Online_Playing.this, R.raw.button);
        mediaPlayer.start();
        int radioId = radioGroup.getCheckedRadioButtonId();

        mcountDown.cancel();
        if (index < totalQuestion) {
            RadioButton clickButton = (RadioButton) view;
            if (clickButton.getText().equals(Common.questionList.get(index).getCorrectAnswer())) {
                //choose Correct Answer
                score += 10;
                correctAnswer++;

                showQuestion(++index);
                //next question
                //radio button clear
                radiobutton();

            } else {


                AlertDialog.Builder alertdialog = new AlertDialog.Builder(Online_Playing.this);
                alertdialog.setTitle("Correct Answer");
                alertdialog.setIcon(R.drawable.hint);
                alertdialog.setMessage(String.valueOf("Correct Answer :-" + Common.questionList.get(index).getCorrectAnswer()) + "\n" + "Explanation :" + String.valueOf(Common.questionList.get(index).getCorrectDisplay()));
                alertdialog.setNegativeButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Online_Playing.this, Online_done.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("TOTAL", totalQuestion);
                        bundle.putInt("CORRECT", correctAnswer);
                        bundle.putInt("SCORE", score);


                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }
                });
                alertdialog.show();


            }

            txtScore.setText(String.format("%d", score));
        }
    }


    private void radiobutton() {
        radioGroup.clearCheck();

    }

    private void showQuestion(int i) {
        if (index < totalQuestion) {
            thisQuestion++;
            txtQuestionNum.setText(String.format("%d / %d ", thisQuestion, totalQuestion));
            progressBar.setProgress(0);
            progressValue = 0;


            if (Common.questionList.get(index).getIsImageQuestion().equals("true")) {
                //if is image
                Picasso.with(getBaseContext())
                        .load(Common.questionList.get(index).getQuestion())
                        .into(question_image);
                question_image.setVisibility(View.VISIBLE);
                question_text.setVisibility(View.INVISIBLE);
                progress_ques.setVisibility(View.GONE);


            } else {
                question_text.setText(Common.questionList.get(index).getQuestion());
                //if question is text
                question_image.setVisibility(View.INVISIBLE);
                question_text.setVisibility(View.VISIBLE);
            }

            r1.setText(Common.questionList.get(index).getAnswerA());
            r2.setText(Common.questionList.get(index).getAnswerB());
            r3.setText(Common.questionList.get(index).getAnswerC());
            r4.setText(Common.questionList.get(index).getAnswerD());
            mcountDown.start();
        } else {
            //if final question
            Intent intent = new Intent(this, Online_done.class);

            Bundle bundle = new Bundle();
            bundle.putInt("TOTAL", totalQuestion);
            bundle.putInt("CORRECT", correctAnswer);
            bundle.putInt("SCORE", score);


            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        totalQuestion = Common.questionList.size();
        mcountDown = new CountDownTimer(TIMEOUT, INTERVAL) {
            @Override
            public void onTick(long minisec) {
                progressBar.setProgress(progressValue);
                progressValue++;


            }

            @Override
            public void onFinish() {
                mcountDown.cancel();

                showQuestion(++index);

            }
        };
        showQuestion(index);//current index
    }
}
