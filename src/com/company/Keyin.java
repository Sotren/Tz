package com.company;


public class Keyin {
    //Method to display the user's prompt string
        public static void printPrompt(String prompt) {
            System.out.print(prompt + " ");
            System.out.flush();
        }
        //Method to make sure no data is available in the
        //input stream
        public static void inputFlush() {
            int dummy;
            int bAvail;

            try {
                while ((System.in.available()) != 0)
                    dummy = System.in.read();
            } catch (java.io.IOException e) {
                System.out.println("Неверный ввод.");
            }
        }
        public static String inString() {
            int aChar;
            String s = "";
            boolean finished = false;

            while (!finished) {
                try {
                    aChar = System.in.read();
                    if (aChar < 0 || (char) aChar == '\n')
                        finished = true;
                    else if ((char) aChar != '\r')
                        s = s + (char) aChar;
                }

                catch (java.io.IOException e) {
                    System.out.println("Неверный ввод.");
                    finished = true;
                }
            }
            return s;
        }
        public static int inInt(String prompt) {
            while (true) {
                    inputFlush();
                    printPrompt(prompt);
                    try {
                        return Integer.valueOf(inString().trim()).intValue();
                    }

                    catch (NumberFormatException e) {
                        System.out.println("Неверный ввод.Ввели не число");
                    }
            }
        }
}


