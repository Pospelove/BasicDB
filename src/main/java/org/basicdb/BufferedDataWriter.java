package org.basicdb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * An implementation of DataWriter that use BufferedWriter
 */
public class BufferedDataWriter implements DataWriter {
    public BufferedDataWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    @Override
    public void writeData(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        writer.write(data);
        writer.flush();
    }

    private final String outputFileName;

}
