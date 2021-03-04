package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class PriorityQueueStorageTest {
    @Test
    public void ensureInsertThrowsOrNotDependingOnId() throws StorageAlreadyExistsException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();

        storage.insert(new Bar(1, "ba"));
        storage.insert(new Bar(2, "ba"));
        Bar existingBar3 = new Bar(3, "barr");
        storage.insert(existingBar3);

        String msg = "";
        Object existingObject = null, objectBeingAdded = null;
        Bar addingObject = new Bar(3, "bar");
        try {
            storage.insert(addingObject);
        } catch (StorageAlreadyExistsException e) {
            msg = e.getMessage();
            existingObject = e.getExistingObject();
            objectBeingAdded = e.getObjectBeingAdded();
        }

        Assert.assertEquals(existingObject, existingBar3);
        Assert.assertEquals(objectBeingAdded, addingObject);
        Assert.assertEquals("Object with id 3 already exists in the storage", msg);
    }

    @Test
    public void ensureUpdateThrowsOrNotDependingOnId() throws StorageAlreadyExistsException, StorageNotFoundException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();

        storage.insert(new Bar(1, "ba"));
        storage.update(new Bar(1, "ba"));
        storage.update(new Bar(1, "barr"));

        String msg = "";
        try {
            storage.update(new Bar(2, "bar"));
        } catch (StorageNotFoundException e) {
            msg = e.getMessage();
        }

        Assert.assertEquals("Object with id 2 doesn't exist in the storage", msg);
    }

    @Test
    public void ensureUpdateModifiesExistingObject() throws StorageNotFoundException, StorageAlreadyExistsException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();

        storage.insert(new Bar(1, "ba"));
        storage.update(new Bar(1, "eee"));

        AtomicReference<Bar> bar = new AtomicReference<Bar>(null);
        storage.forEach(bar::set);

        Assert.assertEquals("eee", bar.get().barName);
    }

    @Test
    public void ensureForEachIteratesOverElements() throws StorageAlreadyExistsException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();

        Bar[] expected = new Bar[]{new Bar(1, "ba"), new Bar(2, "ba")};

        storage.insert(expected[0]);
        storage.insert(expected[1]);

        ArrayList<Bar> list = new ArrayList<Bar>();
        storage.forEach(list::add);

        Assert.assertArrayEquals(list.toArray(), expected);
    }
}
