package org.basicdb;

import java.io.IOException;
import java.io.OutputStream;

public class StringStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        char ch = (char) b;
        stringBuilder.append(ch);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    private final StringBuilder stringBuilder = new StringBuilder();
}
