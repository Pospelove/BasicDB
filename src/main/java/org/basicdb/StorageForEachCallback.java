package org.basicdb;

@FunctionalInterface
interface StorageForEachCallback<T> {
    void execute(T d);
}