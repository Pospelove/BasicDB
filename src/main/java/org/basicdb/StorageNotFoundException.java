package org.basicdb;

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
