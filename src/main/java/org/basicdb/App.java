package org.basicdb;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        //PrintStream stream = new PrintStream("d");

        StringBuilder stringBuilder = new StringBuilder();

        /*OutputStream stream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.write(b);
            }
        };*/

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(stream);

        printStream.println("abcdef");
        printStream.println("!abcdef");
        printStream.println("1abcdef");

        //System.out.print(stream.toString());


        //System.out.println("Hello World!");


    }
}
