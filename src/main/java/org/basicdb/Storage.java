package org.basicdb;

interface Storage<T extends IdHolder> {
    void forEach(StorageForEachCallback<T> callback);

    void insert(T value) throws StorageAlreadyExistsException;

    void update(T value) throws StorageNotFoundException;
}
