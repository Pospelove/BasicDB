package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BufferedDataReaderTest {
    @Test
    public void ensureBufferedDataReaderIsAbleToRead() throws IOException {
        BufferedDataReader reader = new BufferedDataReader("test_files/foo.txt");
        Assert.assertEquals("bar\n", reader.readData());
    }
}
