package org.basicdb;

import org.models.Ticket;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Application entry point
 */
public class App {
    /**
     * Determines the file name that would be used for as database file name
     *
     * @return database file name
     */
    private static String getFileName() {
        String fileName = System.getenv("BASICDB_FILE_NAME");
        return fileName != null ? fileName : "db.json";
    }

    public static void main(String[] args) {
        ModelParser modelParser = new ModelParser(new Scanner(System.in), System.out);
        Ticket ticket = modelParser.parse(Ticket.class, 1);
        JsonSerializer serializer = new JsonSerializer();
        String str = serializer.serialize(ticket);
        System.out.println("You entered:");
        System.out.println(str);

        String fileName = getFileName();
        System.out.println("Using file " + fileName);

        PriorityQueue<Integer> q = new PriorityQueue<>();

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
