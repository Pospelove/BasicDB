package org.basicdb;

/**
 * An exception that would be thrown by Storage when we try to update a non-existing value
 */
public class StorageNotFoundException extends Exception {
    public StorageNotFoundException(long id) {
        super("Object with id " + id + " doesn't exist in the storage");
        this.id = id;
    }

    public long getId() {
        return id;
    }

    private final long id;
}
