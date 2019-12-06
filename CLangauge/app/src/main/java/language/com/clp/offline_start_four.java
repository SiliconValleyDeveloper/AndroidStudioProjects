package language.com.clp;

public class offline_start_four {



    public String mQuestion[] = {

            "Recursion is sometimes called",
            "Each C preprocessor directive begins with",
            " main() {\n" +
                    "long i = 30000;\n" +
                    "printf(“%d”, i); }\n" +
                    "the output is",
            "main() {\n" +
                    "printf(“%p\\n”, main());\n" +
                    "}",

            "The C language includes the header file standard input & output in",
            " The statement which is used to terminate the control from the loop is",
            "The machine registers are sometimes called",
            "Set of values of the same type, which have a single name followed by an index is\n" +
                    "called",
            "What is the output of the following program segment?\n" +
                    "main()\n" +
                    "{\n" +
                    "long i = 65536;\n" +
                    "printf(“%d\\n”, i);\n" +
                    "}",
            "What is the output of the following program segment?\n" +
                    "main()\n" +
                    "{\n" +
                    "int i = 1;\n" +
                    "do\n" +
                    "{ printf(“%d..”, i);\n" +
                    "} while(i--);\n" +
                    "}",
            "What is the output of the following program segment?\n" +
                    "main()\n" +
                    "{\n" +
                    "int i = ++2;\n" +
                    "printf(“%d\\n”, i);\n" +
                    "}",
            "‘C’ allows a three-way transfer of control with the help of",
            "Output of the program given below is\n" +
                    "int i;\n" +
                    "main()\n" +
                    "{\n" +
                    "printf(“%d”, i);\n" +
                    "}",
            " What will be the output of the following program?\n" +
                    "main()\n" +
                    "{\n" +
                    "char *p = “ayqm”;\n" +
                    "printf (“%c”, ++*(p++));}",
            "If y is of integer type then the expression \n" +
                    "     3 * ( y - 8 ) /9 and ( y - 8) / 9 * 3\n" +
                    " \n",

    };
    private String mchoice[][] = {
            {"Circular definition",
                    "Complex definition",
                    "Procedure",
                    "Union"},
            {"#", "include", "main()","{"},
            {"3000", "30000", "0", "-1"},
            {"Prints the address of main function", "Prints 0", "Is an error","Is an infinite loop"},

            {"stdlib.h library" , "stdio.h library","conio.h library","#include library"},
           {"break" , "continue" , "goto" , "exit"},
            {"local variables" , "global variables" , "accumulators" , "static variables"},
            {"function" , "structure" , "array" , "union"},
            {"0", "65536", "-1", "65"},
            {"0..1..", "1..0..", "0", "-1"},
            {"3", "2", "0" , "-1" },
            {"unary operator" , "relational operator", "ternary operator", "comparison operator"},
            {"1", "0", "-1", "Null"},
            {"b", "z", "q" , "n"},
            {"must yield the same value",
                    "must yield different diiferent value",
                    "may or may not yield the same value",
                    "none of the above"}






    };
    private String mCorrectAnswer[] = {
            "Circular definition",
            "#",
            "3000",
            "Prints the address of main function",
           "stdio.h library" ,
            "break",
            "local variables",
            "array",
            "0",
            "1..0..",
            "3",
            "ternary operator",
            "0",
            "b",
            "may or may not yield the same value"

    };


    public String getQuestion(int a) {
        String question = mQuestion[a];
        return question;
    }

    public String getChoice(int a) {
        String choice = mchoice[a][0];
        return choice;
    }

    public String getChoice1(int a) {
        String choice = mchoice[a][1];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mchoice[a][2];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mchoice[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswer[a];
        return answer;
    }


}
