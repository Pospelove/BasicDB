package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CommandInfoTest {
    @Test
    public void ensureInfoCommandReturnsStorageInfo() throws StorageAlreadyExistsException {
        Storage<Bar> storage = new PriorityQueueStorage<Bar>();
        Date date = new Date();
        CommandInfo cmd = new CommandInfo(storage, date);

        String expected = "";
        expected += "Storage type: PriorityQueueStorage\n";
        expected += "Initialization date: " + date + "\n";
        expected += "Elements count: 0\n";
        Assert.assertEquals(expected, cmd.execute());

        storage.insert(new Bar(1, ""));

        expected = "";
        expected += "Storage type: PriorityQueueStorage\n";
        expected += "Initialization date: " + date + "\n";
        expected += "Elements count: 1\n";
        Assert.assertEquals(expected, cmd.execute());
    }
}
