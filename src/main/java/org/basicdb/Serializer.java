package org.basicdb;

import java.io.Serializable;

/**
 * Interface for object serialization into strings
 */
public interface Serializer {
    /**
     * Serialize object into a string
     *
     * @param serializable object to be serialized
     */
    String serialize(Serializable serializable);

    /**
     * Construct object from a previously deserialized string
     *
     * @param cl               class of the object being deserialized
     * @param serializedObject a string representation of the object returned by serialize method
     */
    <T> T deserialize(Class<T> cl, String serializedObject) throws DeserializationFailure;
}
