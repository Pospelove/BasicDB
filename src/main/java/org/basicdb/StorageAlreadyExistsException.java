package org.basicdb;

/**
 * An exception that would be thrown by Storage when we try to insert a value with non-unique ID
 */
public class StorageAlreadyExistsException extends Exception {
    public StorageAlreadyExistsException(IdHolder existingObject, IdHolder objectBeingAdded) {
        super("Object with id " + existingObject.id + " already exists in the storage");
        this.existingObject = existingObject;
        this.objectBeingAdded = objectBeingAdded;
    }

    public IdHolder getExistingObject() {
        return existingObject;
    }

    public IdHolder getObjectBeingAdded() {
        return objectBeingAdded;
    }

    private final IdHolder existingObject, objectBeingAdded;
}
