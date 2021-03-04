package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

public class JsonSerializerTest {

    @Test
    public void ensureJsonSerializerIsAbleToSerializeObject() {
        JsonSerializer serializer = new JsonSerializer();
        Assert.assertEquals("{\"a\":\"abcd\",\"b\":123}", serializer.serialize(new Foo("abcd", 123L)));
    }

    @Test
    public void ensureJsonSerializerIsAbleToDeserializeObject() throws DeserializationFailure {
        JsonSerializer serializer = new JsonSerializer();

        Foo expected = new Foo("abcd", 123L);
        Foo parsed = serializer.deserialize(Foo.class, "{\"a\":\"abcd\",\"b\":123}");

        Assert.assertEquals(0, SerializableComparator.instance.compare(expected, parsed));
    }

    @Test(expected = DeserializationFailure.class)
    public void ensureJsonSerializerFailsOnBadInput() throws DeserializationFailure {
        JsonSerializer serializer = new JsonSerializer();
        serializer.deserialize(Foo.class, "{\"a\":\"abcd\",\"b\":123");
    }
}
