package org.basicdb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * An implementation of DataReader that use BufferedReader
 */
public class BufferedDataReader implements DataReader {
    public BufferedDataReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    @Override
    public String readData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String line;
        StringBuilder res = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            res.append(line).append("\n");
        }
        return res.toString();
    }

    private final String inputFileName;
}
