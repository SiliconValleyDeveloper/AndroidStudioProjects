package language.com.clp;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




import java.util.Random;

public class Start_offline_three extends AppCompatActivity {




    RadioButton rb1,rb2,rb3,rb4;
    RadioGroup rg;
    TextView txtscore,question,TotalQuestion;
    private int score = 0,questionno = 0;
    private offline_start_three mQuestion = new offline_start_three();
    private String mAnswer,CorrectDisplay;


    private  int mqestionlength = mQuestion.mQuestion.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_offline_three);









        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Offline Quiz");


        }


        r = new Random();


        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.r1);
        rb2 = (RadioButton) findViewById(R.id.r2);
        rb3 = (RadioButton) findViewById(R.id.r3);
        rb4 = (RadioButton) findViewById(R.id.r4);
        txtscore = (TextView) findViewById(R.id.txtScore);
        TotalQuestion = (TextView) findViewById(R.id.TotalQuestion);
        question = (TextView) findViewById(R.id.question_text);
        updateQuestion(questionno);
        txtscore.setText("Score -:" + score);


        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_three.this,R.raw.button);
                mediaPlayer.start();
                if (questionno < mqestionlength) {


                    if (rb1.getText() == mAnswer) {

                        score = score + 10;
                        txtscore.setText("Score:" + score);

                        updateQuestion(questionno);
                        radiobutton();
                    } else {

                        gameOver();
                    }
                } else {
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_three.this);
                    alertdialogbuilder.setTitle("Congratulations");
                    alertdialogbuilder.setIcon(R.drawable.winning);
                    alertdialogbuilder.setMessage("You've finished the quiz.Try the another SET.!" )
                            .setCancelable(false)
                            .setPositiveButton("Done"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(getApplicationContext(), offline_quiz.class));
                                        }
                                    })
                            .setNegativeButton("Try Online Quiz"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(Start_offline_three.this, online_login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                    AlertDialog alertDialog = alertdialogbuilder.create();
                    alertDialog.show();

                }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_three.this,R.raw.button);
                mediaPlayer.start();
                if (questionno < mqestionlength) {
                    if (rb2.getText() == mAnswer) {

                        score = score + 10;
                        txtscore.setText("Score:" + score);
                        updateQuestion(questionno);

                        radiobutton();

                    } else {

                        gameOver();
                    }
                } else {
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_three.this);
                    alertdialogbuilder.setTitle("Congratulations");
                    alertdialogbuilder.setIcon(R.drawable.winning);
                    alertdialogbuilder.setMessage("You've finished the quiz.Try the another SET.!" )
                            .setCancelable(false)
                            .setPositiveButton("Done"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(getApplicationContext(), offline_quiz.class));
                                        }
                                    })
                            .setNegativeButton("Try Online Quiz"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(Start_offline_three.this, online_login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                    AlertDialog alertDialog = alertdialogbuilder.create();
                    alertDialog.show();
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_three.this,R.raw.button);
                mediaPlayer.start();
                if (questionno < mqestionlength) {
                    if (rb3.getText() == mAnswer) {

                        score = score + 10;
                        txtscore.setText("Score:" + score);

                        updateQuestion(questionno);
                        radiobutton();
                    } else {
                        gameOver();
                    }
                } else {
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_three.this);
                    alertdialogbuilder.setTitle("Congratulations");
                    alertdialogbuilder.setIcon(R.drawable.winning);
                    alertdialogbuilder.setMessage("You've finished the quiz.Try the another SET.!" )
                            .setCancelable(false)
                            .setPositiveButton("Done"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(getApplicationContext(), offline_quiz.class));
                                        }
                                    })
                            .setNegativeButton("Try Online Quiz"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(Start_offline_three.this, online_login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                    AlertDialog alertDialog = alertdialogbuilder.create();
                    alertDialog.show();
                }
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_three.this,R.raw.button);
                mediaPlayer.start();
                if (questionno < mqestionlength) {
                    if (rb4.getText() == mAnswer) {

                        score = score + 10;
                        txtscore.setText("Score:" + score);

                        updateQuestion(questionno);
                        radiobutton();
                    } else {

                        gameOver();
                    }
                } else {
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_three.this);
                    alertdialogbuilder.setTitle("Congratulations");
                    alertdialogbuilder.setIcon(R.drawable.winning);
                    alertdialogbuilder.setMessage("You've finished the quiz.Try the another SET.!" )
                            .setCancelable(false)
                            .setPositiveButton("Done"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            startActivity(new Intent(getApplicationContext(), offline_quiz.class));
                                        }
                                    })
                            .setNegativeButton("Try Online Quiz"
                                    , new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(Start_offline_three.this, online_login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                    AlertDialog alertDialog = alertdialogbuilder.create();
                    alertDialog.show();
                }
            }

        });


    }

    private void updateQuestion(int num){
        question.setText(mQuestion.getQuestion(num));
        rb1.setText(mQuestion.getChoice(num));
        rb2.setText(mQuestion.getChoice1(num));
        rb3.setText(mQuestion.getChoice2(num));
        rb4.setText(mQuestion.getChoice3(num));
        mAnswer=mQuestion.getCorrectAnswer(num);
       // CorrectDisplay = mQuestion.getCorrectAnswerDisplay(num);
        questionno++;
        TotalQuestion.setText(String.valueOf(questionno)+"/"+String.valueOf(mqestionlength));


    }


    private void gameOver(){

        AlertDialog.Builder alertdialogbuilder= new AlertDialog.Builder(Start_offline_three.this);
        alertdialogbuilder.setMessage("Correct Answer: " +mAnswer+"\n"+String.valueOf("Score :"+score)+"\n"+"Attempt Question : "+String.valueOf(questionno+"/"+mqestionlength))
                .setCancelable(false)
                .setPositiveButton("New Game"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),offline_quiz.class));
                            }
                        })
                .setNegativeButton("Exit"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog=alertdialogbuilder.create();
        alertDialog.show();
    }


    private void radiobutton(){
        rg.clearCheck();
    }





}
