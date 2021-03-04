package org.basicdb;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.PriorityQueue;

public class PriorityQueueStorage<T extends IdHolder> implements Storage<T> {
    @Override
    public void forEach(StorageForEachCallback<T> callback) {
        data.forEach(callback::execute);
    }

    @Override
    public void insert(T value) throws StorageAlreadyExistsException {
        Optional<T> any = data.stream().filter(x -> x.id.equals(value.id)).findFirst();
        if (any.isPresent()) {
            throw new StorageAlreadyExistsException(any.get(), value);
        }
        data.add(value);
    }

    @Override
    public void update(T value) throws StorageNotFoundException {
        Optional<T> matchingValue = data.stream().filter(x -> x.id.equals(value.id)).findFirst();
        if (matchingValue.isPresent()) {
            for (Field field : matchingValue.get().getClass().getFields()) {
                try {
                    field.set(matchingValue.get(), field.get(value));
                } catch (IllegalAccessException e) {
                    // TODO: Use checked instead?
                    throw new RuntimeException(e);
                }
            }
        } else {
            throw new StorageNotFoundException(value.id);
        }
    }

    private final PriorityQueue<T> data = new PriorityQueue<T>();
}
