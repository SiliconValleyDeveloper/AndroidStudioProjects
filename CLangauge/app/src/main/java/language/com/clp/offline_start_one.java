package language.com.clp;

public class offline_start_one {
    public String mQuestion[] ={

            "Who is father of C Language?",
            "C Language developed at _____?",
            "For 16-bit compiler allowable range for integer constants is ______ ?",
            "C programs are converted into machine language with the help of",
            "A C variable cannot start with",
            "Which of the following is allowed in a C Arithmetic instruction",
            "Which of the following shows the correct hierarchy of arithmetic operations in C",
            "What is an array?",
            "What is right way to Initialization array?",
            "An array elements are always stored in _________ memory locations.",
            "What is the right way to access value of structure variable book{ price, page }?",
            "perror( ) function used to ?",
            "Bitwise operators can operate upon?",
            " What is C Tokens?",
            "What is Keywords?",
            "What is constant?",

            "Literal means",
            "Recursion is sometimes called",
            "Choose the correct answer",
            "Output of the following program fragment is\n" +
                    "x = 5;\n" +
                    "y = x++;\n" +
                    "printf(“%d%d”, x, y);",
            "The value of an automatic variable that is declared but not initialised will be",
            "Consider the following program\n" +
                    "main ( )\n" +
                    "{ float a = 0.5, b = 0.7;\n" +
                    "if (b < 0.8)\n" +
                    "if (a < 0.5) printf (“ABCD”);\n" +
                    "else printf (“PQR”);\n" +
                    "else printf (“JKLF);\n" +
                    "}",
            "The following program fragment\n" +
                    "int *a;\n" +
                    "*a = 7;",
            "A pointer variable can be",
            "‘C’ is often called a",
            "The loop in which the statements within the loop are executed at least once is\n" +
                    "called"


    };
    private String mchoice[][] = {


            {"Bjarne Stroustrup" , "Dennis Ritchie","James A. Gosling","Dr. E.F. Codd"     },
            {"AT & T's Bell Laboratories of USA in 1972","AT & T's Bell Laboratories of USA in 1970","Sun Microsystems in 1973","Cambridge University in 1972"},
            {"-3.4e38 to 3.4e38", "-32767 to 32768", "-32768 to 32767" ,"-32668 to 32667"},
            {"An Editor", "A compiler", "An operating system", "None of the above"},
            {" An alphabet", "A number","A special symbol other than underscore","both (b) and (c)"},
            {"[ ]","{ }","( )","None of the above"},
            {"/ + *", " * - /", " + - /", "* / +"},
            {"An array is a collection of variables that are of the dissimilar data type.", "An array is a collection of variables that are of the same data type.", "An array is not a collection of variables that are of the same data type.","None of the above."},

            {"int num[6]={ 2, 4, 12, 5, 45, 5 };", "int n{} = { 2, 4, 12, 5, 45, 5 } ;" , "int n{6} = { 2, 4, 12 } ;", "int n(6) = { 2, 4, 12, 5, 45, 5 } ;"},
            {"Sequential" , "Random", "Sequential and Random", "None of the above"},
            {"printf(\"%d%d\", book.price, book.page);" , "printf(\"%d%d\", price.book, page.book);", "printf(\"%d%d\", price::book, page::book);", "printf(\"%d%d\", price->book, page->book);"},
            {"Work same as printf()", "prints the error message specified by the compiler", "prints the garbage value assigned by the compiler", "None of the above"},
            {"double and chars", "floats and doubles", "ints and floats","ints and chars"},
            {"The smallest individual units of c program", "The basic element recognized by the compiler", "The largest individual units of program", "A & B Both"},
            {"Keywords have some predefine meanings and these meanings can be changed." ,
                    "Keywords have some unknown meanings and these meanings cannot be changed." ,
                    "Keywords have some predefine meanings and these meanings cannot be changed." ,
                    "None of the above"},
            {"Constants have fixed values that do not change during the execution of a program",
                    "Constants have fixed values that change during the execution of a program",
                    "Constants have unknown values that may be change during the execution of a program",
                    "None of the above"},

            {"a string", "a string constant", "a character", "an alphabet"},
            {"Circular definition" , "Complex definition" , "Procedure" , "Union"},
            {"Casting refers to implicit type conversion" , "Coercion refers to implicit type conversion" , "Casting means coercion" , "Coercion refers to explicit type conversion"},

            {"5, 6", "5, 5", "6, 5", "6, 6"},
            {"0","-1", "unpredictable", "none of these"},
            {"ABCD", "PQR", "JKLF", "None of these"},

            {"assigns 7 to a", "results in compilation error", "assigns address of a as 7", "segmentation fault"},
            {"passed to a function as argument" , "changed within function" , "returned by a function" ,"assigned an integer value."},
            {"Object oriented language", "High level language", "Assembly language" ,"Machine level language"},
            {"do-while", "while", "for", "goto"}












    };
    private String mCorrectAnswer[]={
            "Dennis Ritchie",
            "AT & T's Bell Laboratories of USA in 1972",
            "-32768 to 32767",
            "A compiler",
            "both (b) and (c)",
            "( )",
            "* / +",
            "An array is a collection of variables that are of the same data type.",

            "int num[6]={ 2, 4, 12, 5, 45, 5 };",
            "Sequential",
            "printf(\"%d%d\", book.price, book.page);",

            "prints the error message specified by the compiler",

            "ints and chars",
            "A & B Both",
            "Keywords have some predefine meanings and these meanings cannot be changed.",
            "Constants have fixed values that do not change during the execution of a program",

            "a string constant",
            "Circular definition",
            "Coercion refers to implicit type conversion",
            "6, 5",
            "unpredictable",
            "PQR",
            "segmentation fault",
            "returned by a function" ,
            "High level language",
            "do-while"


    };
 /*   private String mCorrectAnswerDisplay[]={"Mercury","Venus","Earth","Mars","Jupiter"
            ,"Saturn","Uranus","Neptune","Pluto"

    };*/

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }
    public String getChoice(int a){
        String choice=mchoice[a][0];
        return choice;
    }
    public String getChoice1(int a){
        String choice=mchoice[a][1];
        return choice;
    }
    public String getChoice2(int a){
        String choice=mchoice[a][2];
        return choice;
    }
    public String getChoice3(int a){
        String choice=mchoice[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer=mCorrectAnswer[a];
        return answer;
    }

   /* public String getCorrectAnswerDisplay(int a) {
        String display_answer=mCorrectAnswerDisplay[a];
        return display_answer;
    }*/
}
