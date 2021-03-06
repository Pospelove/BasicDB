package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

public class CommandShowTest {
    @Test
    public void ensureShowCommandReturnsSerializedStorageElements() throws StorageAlreadyExistsException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();
        CommandShow cmd = new CommandShow(storage, new JsonSerializer());

        storage.insert(new Bar(1, "aaa"));
        storage.insert(new Bar(2, "bbb"));

        String expected = "";
        expected += "{\"id\":1,\"barName\":\"aaa\"}\n";
        expected += "\n";
        expected += "{\"id\":2,\"barName\":\"bbb\"}\n";
        expected += "\n";
        Assert.assertEquals(expected, cmd.execute());
    }
}
