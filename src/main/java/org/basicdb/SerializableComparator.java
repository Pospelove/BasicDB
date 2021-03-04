package org.basicdb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class SerializableComparator implements Comparator<Serializable> {
    public static final SerializableComparator instance = new SerializableComparator();

    private SerializableComparator() {
    }

    @Override
    public int compare(Serializable o1, Serializable o2) {
        try {
            return Arrays.compare(toByteArray(o1), toByteArray(o2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] toByteArray(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
        objStream.writeObject(serializable);
        objStream.close();

        return byteStream.toByteArray();
    }
}
