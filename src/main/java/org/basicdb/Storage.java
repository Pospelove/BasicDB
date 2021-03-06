package org.basicdb;

/**
 * An abstraction for CRUD operations with object that derive IdHolder
 *
 * @param <T> type of collection elements
 */
interface Storage<T extends IdHolder> {
    /**
     * Iterates over values that storage contain
     *
     * @param callback callback that would be invoked for all contained values
     */
    void forEach(StorageForEachCallback<T> callback);

    /**
     * Adds a new value to the storage
     *
     * @param value value to be added
     * @throws StorageAlreadyExistsException is thrown if value ID is already in use
     */
    void insert(T value) throws StorageAlreadyExistsException;

    /**
     * Updates existing value in the storage by copying every field.
     *
     * @param value value to be used to update an existing value
     * @throws StorageNotFoundException is thrown if no value found by a provided ID
     */
    void update(T value) throws StorageNotFoundException;
}
