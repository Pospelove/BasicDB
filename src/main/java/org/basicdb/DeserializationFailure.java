package org.basicdb;

/**
 * An exception that would be thrown by Serializer on any deserialization failure
 */
public class DeserializationFailure extends Exception {
    public DeserializationFailure(String msg) {
        super(msg);
    }
}