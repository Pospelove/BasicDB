package org.basicdb;

import java.io.Serializable;

public interface Serializer {
    String serialize(Serializable serializable);

    <T> T deserialize(Class<T> cl, String serializedObject) throws DeserializationFailure;
}
