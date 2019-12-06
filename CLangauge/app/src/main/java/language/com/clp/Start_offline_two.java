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

public class Start_offline_two extends AppCompatActivity {

    RadioButton rb1, rb2, rb3, rb4;
    RadioGroup rg;
    TextView txtscore, question, TotalQuestion;
    private int score = 0, questionno = 0;
    private offline_start_two mQuestion = new offline_start_two();
    private String mAnswer, CorrectDisplay;


    private int mqestionlength = mQuestion.mQuestion.length;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_offline_two);




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
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_two.this,R.raw.button);
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
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_two.this);
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
                                            Intent intent = new Intent(Start_offline_two.this, online_login.class);
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
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_two.this,R.raw.button);
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
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_two.this);
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
                                            Intent intent = new Intent(Start_offline_two.this, online_login.class);
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
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_two.this,R.raw.button);
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
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_two.this);
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
                                            Intent intent = new Intent(Start_offline_two.this, online_login.class);
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
                final MediaPlayer mediaPlayer = MediaPlayer.create(Start_offline_two.this,R.raw.button);
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
                    AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_two.this);
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
                                            Intent intent = new Intent(Start_offline_two.this, online_login.class);
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


    private void updateQuestion(int num) {
        question.setText(mQuestion.getQuestion(num));
        rb1.setText(mQuestion.getChoice(num));
        rb2.setText(mQuestion.getChoice1(num));
        rb3.setText(mQuestion.getChoice2(num));
        rb4.setText(mQuestion.getChoice3(num));
        mAnswer = mQuestion.getCorrectAnswer(num);
        CorrectDisplay = mQuestion.getCorrectAnswerDisplay(num);
        questionno++;
        TotalQuestion.setText(String.valueOf(questionno) + "/" + String.valueOf(mqestionlength));


    }


    private void gameOver() {

        AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(Start_offline_two.this);
        alertdialogbuilder.setMessage("Correct Answer: " + mAnswer + "\n" + "Explanation : " + CorrectDisplay + "\n" +String.valueOf("Score : "+ score) + "\n" + String.valueOf("Attempt Question : "+questionno + "/" + mqestionlength))
                .setCancelable(false)
                .setPositiveButton("New Game"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), offline_quiz.class));
                            }
                        })
                .setNegativeButton("Exit"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertdialogbuilder.create();
        alertDialog.show();
    }


    private void radiobutton() {
        rg.clearCheck();
    }






/*
    @Override
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
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(Start_offline_two.this);
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
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id =" +getPackageName())));

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
    }

}
*/




}

