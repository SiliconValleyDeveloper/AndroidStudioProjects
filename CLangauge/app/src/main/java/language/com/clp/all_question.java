package language.com.clp;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class all_question extends AppCompatActivity {


    private Boolean isrunning;


    ListView lstSearch;
    ArrayAdapter<String> adapter;

    String[] data = {
            "What is the use of printf() and scanf() functions?",
            "What is the difference between call by value and call by reference in C?",
            "What is recursion in C?",
            "What is pointer to pointer in C?",
            "What is the difference between malloc() and calloc()?",
            "What is union?",
            "What is auto keyword in C?",
            "What is the purpose of sprintf() function?",
            "Can we compile a program without main() function?",
            "What is token?",
            "What is the acronym for ANSI?",
            "What is the difference between getch() and getche()?",
            "What is the difference between near, far and huge pointers?",
            "What is typecasting?",
            "What are the functions to open and close file in C language?",
            "Can we access array using pointer in C language?",
            "What is infinite loop?",
            "Write a program to print \"hello world\" without using semicolon?"




    };
    String q24 ="The printf() function is used for output and scanf() function is used for input" ;
    String q25 = "We can pass value to function by one of the two ways: call by value or call by reference. In case of call by value, a copy of value is passed to the function, so original value is not modified. But in case of call by reference, an address of value of passed to the function, so original value is modified.";
    String q26 = "Calling the same function, inside function is known as recursion.";
    String q27 = "In case of pointer to pointer concept, one pointer refers to the address of another pointer";
    String q28 = "malloc(): The malloc() function allocates single block of requested memory. It has garbage value initially.\n" +
            "\n" +
            "calloc(): The calloc() function allocates multiple block of requested memory. It initially initializes all bytes to zero.";
    String q29 = "Like Structure, union is a user-defined data type that allows to store multiple types of data in a single unit. But it doesn't occupies the sum of memory of all members. It occupies the memory of largest member only.";
    String q30 = "In C, every local variable of a function is known as automatic (auto) variable. Let's explain with an example:\n" +
            "\n" +
            "void f()  \n" +
            "{  \n" +
            "int i ;  \n" +
            "auto int j;  \n" +
            "}  \n" +
            "Here, both 'i' and 'j' variables are automatic variables.\nNote: A global variable can't be an automatic variable.";
    String q31 = "It is used to print the formatted output into char array.";
    String q32 = "Yes, we can compile but it can't be executed.\n" +
            "\n" +
            "But, if we use #define, we can compile and run C program without using main() function. For example:\n" +
            "\n" +
            "#include<stdio.h>    \n" +
            "#define start main    \n" +
            "void start() {    \n" +
            "   printf(\"Hello\");    \n" +
            "}    ";
    String q33 = "Token is an identifier. It can be constant, keyword, string literal etc.";
    String q34 = "American National Standard Institute.";
    String q35 = "The getch() function reads a single character from keyboard. It doesn't uses any buffer, so entered data is not displayed on the output screen.\n" +
            "\n" +
            "The getche() function reads a single character from keyword but data is displayed on the output screen. Press Alt+f5 to see the entered character.";
    String q36 = "Near pointer is used to store 16 bit addresses means within current segment on a 16 bit machine. The limitation is that we can only access 64kb of data at a time. ... Like far pointer, huge pointer is also typically 32 bit and can access outside segment. In case of far pointers, a segment is fixed.";
    String q37 = "Converting one data type into another is known as typecasting. For example:\n" +
            "\n" +
            "float f=3.4;  \n" +
            "int a=(int)f;//typecasting ";
    String q38 = "The fopen() function is used to open file whereas fclose() is used to close file.\n" +
            "\n";
    String q39 = "Yes, by holding the base address of array into pointer, we can access the array using pointer.";
    String q40 = "A loop running continuously for indefinite number of times is called infinite loop.\n" +
            "\n" +
            "Infinite For Loop:\n" +
            "\n" +
            "for(;;){  \n" +
            "//code to be executed  \n" +
            "} ";

    String q41 = "There are various ways to do so. Let's see a program to print \"hello world\" using if.\n" +
            "\n" +
            "#include<stdio.h>    \n" +
            "void main(){    \n" +
            "   if(printf(\"hello world\")){}    \n" +
            "}    ";
    String [] answer = {q24,q25,q26,q27,q28,q29,q30,q31,q32
    ,q33,q34,q35,q36,q37,q38,q39,q40,q41};

    //ads
    private AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_question);





        MobileAds.initialize(this,"ca-app-pub-2783298230694780/9407287785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
      if(getSupportActionBar()!=null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }


        lstSearch = (ListView) findViewById(R.id.lstSearch);
        adapter = new ArrayAdapter<String>(this, R.layout.question_list_item, R.id.textview, data);
        //    final programs.CustomAdapter customAdapter = new programs.CustomAdapter();
        lstSearch.setAdapter(adapter);

        lstSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String top = answer[position];

                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(all_question.this);
                alertdialog.setTitle("Answer");
                alertdialog.setMessage(top);
                alertdialog.setIcon(R.drawable.inter);
                alertdialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                });
                alertdialog.show();
            }
        });

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
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(all_question.this);
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
    }

*/

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

