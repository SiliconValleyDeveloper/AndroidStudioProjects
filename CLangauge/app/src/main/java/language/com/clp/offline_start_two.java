package language.com.clp;

public class offline_start_two {

        public String mQuestion[] = {

                "Choose the correct statement.?",

                "Which is true of conditional compilation ?",


                "C was primarily developed as a ",

                "C is a",
                "Even if a particular implementation doesn't limit the number of character in an identifier , it is advisable to be concise because ",
                "The minimum number of temporary variable needed to swap the contents of two variable is",
                 "The purpose of the following program fragment :\n" +
                         "       b = s + b ;\n" +
                         "       s = b - s ;\n" +
                         "       b = b - s ;\n" +
                         "where s,b are two integers is to ",

                "Let a,b be two non-negative integers .Which of the following calls , find the postive difference of a and b ?",
                "If integer need two bytes of storage , then maximum value of an unsigned integer is",
                 "If integer need two bytes if storage ,then maximum value of a signed integer is ",
                "printf(\"%d\" , printf(\"tim\"));",
                "If abc is the input, then the following program fragment :\n" +
                        "   char x,y,z;\n" +
                        "   printf(\"%d\",scanf(\"%c%c%c\",&x,&y,&z)); result in \n",

                "Consider the statments :\n" +
                        "     putchar(getchar());\n" +
                        "     putchar(getchar());\n" +
                        "     if a,b is the input ,the output will be ",
                "Let a,b be two positive integers . which of the following option correct relates / and % ?",
                " Literal means ?",

        };
        private String mchoice[][] = {
                {"Use of goto enchances the logical clarity of a code",
            "Use of goto make the debugging task easier",
            "Use goto when you want to jump out of a nested loop",
            "Never use goto"},

                {"It is taken care of by the compiler",
                        "It is setting the compiler option conditionally",
                        "It is compiling a program based on a condition",
                        "None of these"},

                {"systems programming language" ,
                        "general purpose language" ,
                        "data processing language" ,
                        "none of the above"},

                {"high level language",
                        "low level language",
                        "high level language with some low level features",
                        "low level language with some high level features"},

                {"chances of typographic error are more",
                        "it may be processed by assembler,loader,etc. which may have their own rule that may contradict the language rules",
                        "by being concise, one can be mnemonic",
                        "none of above"},
                {"1", "2", "3", "0"},

                {"transfer the content of s to b",
                        "transfer the context of b to s",
                        "exchange (swap) the content of s and b",
                        "negate the context of s and b"},

                {"find(a,b) + find (b,a)",
                        "find(a,find(a,b))",
                        "a + find(a,b)",
                        "b + find(a,b)"},

                {"2^16 - 1" ,
                        "2^15 - 1",
                        "2^16",
                        "2^16"},

                {"2^16 - 1",
                        "2^15 - 1",
                        "2^16",
                        "2^16"},
                {"result in a syntax error",
                        "output tim3",
                        "output garbage",
                        "print tim and terminates abruptly"},
                {"a syntax error",
                        "a fatal error",
                        "segmentation violation",
                        "printing of 3"},
                {"an error message",
                        "this can't be the input",
                        "ab",
                        "a b"},
                {"b = (a/b)*b + a%b",
                        "a = (a/b)*b + a%b",
                        "b = (a%b)*b + a/b",
                        "a = (a%b)*b + a/b"},
                {"a string",
                        "a string constant",
                        "a character",
                        "and alphabet"}





        };
        private String mCorrectAnswer[] = {
                "Use goto when you want to jump out of a nested loop",
                "It is compiling a program based on a condition",
                "systems programming language" ,
                "high level language with some low level features",
                "it may be processed by assembler,loader,etc. which may have their own rule that may contradict the language rules",
                "0",
                "exchange (swap) the content of s and b",
                "find(a,b) + find (b,a)",
                "2^16 - 1",
                "2^15 - 1",
                "output tim3",
                "printing of 3",
                "this can't be the input",
                "a = (a/b)*b + a%b",
                "a string constant"


        };
   private String mCorrectAnswerDisplay[]={
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "No Explanation",
           "Any Function(including main()),return a value to the calling environment,In the case of printf,it is the character it printed.so, the output will be tim3(since it printed the three character a,b,c)",
           "The scanf function return the number of successful matches ,i.e, 3 in this case ",
           "No Explanation",
           "No Explanation",
           "No Explanation"
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

    public String getCorrectAnswerDisplay(int a) {
        String display_answer=mCorrectAnswerDisplay[a];
        return display_answer;
    }
    }
