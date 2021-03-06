package org.basicdb;

import java.io.IOException;

/**
 * Interface for loading file as string from disk
 */
public interface DataReader {
    /**
     * Gets contents of file
     *
     * @return file contents as string
     */
    String readData() throws IOException;
}
