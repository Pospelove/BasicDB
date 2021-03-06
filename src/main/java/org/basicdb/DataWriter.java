package org.basicdb;

import java.io.IOException;

/**
 * Interface for writing string data to disk
 */
public interface DataWriter {
    /**
     * Writes a specified string to a file
     *
     * @param data string to write
     */
    void writeData(String data) throws IOException;
}
