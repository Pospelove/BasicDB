package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BufferedDataWriterTest {
    @Test
    public void ensureBufferedDataWriterIsAbleToWrite() throws IOException {
        BufferedDataWriter writer = new BufferedDataWriter("test_files/tmp.txt");

        String str = "" + Math.random();
        writer.writeData(str);

        BufferedDataReader reader = new BufferedDataReader("test_files/tmp.txt");
        Assert.assertEquals(str + "\n", reader.readData());
    }
}
