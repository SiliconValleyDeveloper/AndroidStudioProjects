package language.com.clp;

public class offline_start_three {
        public String mQuestion[] ={

                "What will be the output of the following statements ?\n" +
                        "int x[4] = {1,2,3}; printf(\"%d %d %D\",x[3],x[2],x[1]);",
                "What will be the output of the following statement?\n" +
                        "printf( 3 + \"goodbye\");",
                "What will be the output of the following statements ?\n" +
                        "long int a = scanf(\"%ld%ld\",&a,&a); printf(\"%ld\",a);",
                "What will be the output of the following program ?\n" +
                        "#include<stdio.h>\n" +
                        "void main(){ \n"+
                        "int a = 2;\n" +
                        "switch(a)\n" +
                        "{ case 1: printf(\"goodbye\"); break;\n" +
                        "case 2:\n" +
                        "continue;\n" +
                        "case 3:printf(\"bye\");}}\n",
                "What will be the output of the following statements ?\n" +
                        "int i = 1,j; j=i--- -2; printf(\"%d\",j);",
                "What will be the output of following program ?\n" +
                        "#include<stdio.h>" +
                        "void main()\n" +
                        "{\n" +
                        "int x,y = 10;\n" +
                        "x = y * NULL;\n" +
                        "printf(\"%d\",x);\n" +
                        "}\n",
                "What will be the output of the following statements ?\n" +
                        "int a=5,b=6,c=9,d; d=(ac?1:2):(c>b?6:8)); printf(\"%d\",d);",
                "What will be the output of the following statements ?\n" +
                        "int i = 3;\n" +
                        "printf(\"%d%d\",i,i++);\n",
                "What will be the output of the following program ?\n" +
                        "#include\n" +
                        "void main()\n" +
                        "{\n" +
                        "int a = 36, b = 9;\n" +
                        "printf(\"%d\",a>>a/b-2);\n" +
                        "}\n",
                "int testarray[3][2][2] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};\n" +
                        "What value does testarray[2][1][0] in the sample code above contain?\n",
                " void main()\n" +
                        "{\n" +
                        "int a=10,b=20;\n" +
                        "char x=1,y=0;\n" +
                        "if(a,b,x,y)\n" +
                        "{\n" +
                        "printf(\"EXAM\");\n" +
                        "}\n" +
                        "}\n" +
                        "What is the output?",
                "What will be the value of `a` after the following code is executed\n" +
                        "#define square(x) x*x\n" +
                        "a = square(2+3)",
                " What will be output if you will compile and execute the following c code?\n" +
                        "void main(){\n" +
                        "if(printf(\"cquestionbank\"))\n" +
                        "printf(\"I know c\");\n" +
                        "else\n" +
                        "printf(\"I know c++\");\n" +
                        "}\n",
                "What will be output if you will compile and execute the following c code?\n" +
                        "#define call(x) #x\n" +
                        "void main(){\n" +
                        "printf(\"%s\",call(c/c++));\n" +
                        "}\n",
                "The Default Parameter Passing Mechanism is called as",
                "What will be the output of the following program?\n" +
                        "main()\n" +
                        "{\n" +
                        "int i = 5;\n" +
                        "printf(“%d”, i=++i==6);\n" +
                        "}",
                "What will be the output of following program?\n" +
                        "main()\n" +
                        "{\n" +
                        "int x=15;\n" +
                        "printf(“\\n%d%d%d”, x!=15, x=20, x<30);\n" +
                        "}",
                "How many times the following program would print (“abc”)?\n" +
                        "main()\n" +
                        "{\n" +
                        "printf(“\\nabc”);\n" +
                        "main();\n" +
                        "}",
                " What is the work of break keyword?",
                "Find the output of the following program.\n" +
                        "void main()\n" +
                        "{\n" +
                        "int a=10;\n" +
                        "if(!(!a)==!0)\n" +
                        "printf(“God”);\n" +
                        "else\n" +
                        "printf(“Good”);\n" +
                        "}",
                "Find the output of the following program.\n" +
                        "void main()\n" +
                        "{\n" +
                        "char a=65,b=97;\n" +
                        "if(‘a>‘b’)\n" +
                        "printf(“A”)\n" +
                        "printf(“B”)\n" +
                        "}",
                "void main()\n" +
                        "{\n" +
                        "do\n" +
                        "{"+
                        "if(0)\n" +
                        "main();\n" +
                        "printf(“Thaal”);\n" +
                        "}while(0);\n" +
                        "}",

                "What will be output if you will compile and execute the following c code?\n" +
                        "void main(){\n" +
                        "int i=0;\n" +
                        "if(i==0){\n" +
                        "i=((5,(i=3)),i=1);\n" +
                        "printf(\"%d\",i);\n" +
                        "}\n" +
                        "else\n" +
                        "printf(\"equal\");\n" +
                        "}\n",
                "The program fragment\n" +
                        "int a = 5 , b =2;\n" +
                        "printf(\"%d\",a+++++b);",
                "Consider the following declaration.\n" +
                        "int a, *b = &a , **c =&b;\n" +
                        "The following program fragment \n"

        };
        private String mchoice[][] = {


                {"03%D", "000", "032", "321"  },
                {"goodbye", "odbye", "bye", "dbye"},
                {"error", "garbage value","0","2"},
                {"error", "goodbye","bye","byegoodbye"},
                {"error", "2", "3","-3"},

                {"error", "0", "10", "garbage value"},
                {" 1", "2", "6", "Error"},
                {"34","43","44","33"},

                {"9","5","7","None of these"},
                {"11", "7","5","9"},
                {"XAM is printed", "exam is printed", "Compiler Error", "Nothing is printed"},
   //             {"The element will be set to 0.", "B. The compiler would report an error.","The program may crash if some important data gets overwritten.","The array size would appropriately grow."},
                {"25", "13", "11" ,"10"},
                {"I know c", "I know c++", "cquestionbankI know c", "cquestionbankI know c++", "Compiler error"},

                {"c++", "#c/c++", "c/c++" , "Compiler error"},

                {"Call by Value","Call by Reference","Call by Address","Call by Name"},
                {"0","1", "7" , "6"},
                {"0, 20, 1", "15, 20, 30" , "0, 0, 0","Error"},
                {"Infinite number of times", "32767 times", "65535 times","Till the stack does not overflow"},
                {"Halt execution of program",
                        "Restart execution of program ",
                        "Exit from loop or switch statement",
                        "None of the above"},
                {"Good", "God", "199200" , "We can’t predict", "Error"},
                {"AB", "A" , "B", "Error"},
                {"Thaal", "Infinite Loop", "Syntax error", "Nothing get printed"},

                {"5","3","1","equal"},
                {"prints 7", "prints 8", "prints 9", "none of the above"},
                {"does not change the value of a",
                        "assign address of c to a",
                        "assigns the value of b to a",
                        "assign 5 to a"}











        };
        private String mCorrectAnswer[]={
                "032",
                "dbye",
                "garbage value",
                "error",
                "3",
                "0",
                "Error",
                "43",
                "9",
                "11",
                "Nothing is printed",

             //   "The program may crash if some important data gets overwritten." ,

                "11",
                "cquestionbankI know c++",
                "Compiler error",
                "Call by Value",
                "1",
                "0, 20, 1",
                "Infinite number of times",
                "Exit from loop or switch statement",
                "Good",
                "AB",
                "Thaal",
                "1",
                "none of the above",
                "assign 5 to a"

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
