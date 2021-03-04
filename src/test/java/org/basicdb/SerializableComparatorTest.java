package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

public class SerializableComparatorTest {

    @Test
    public void ensureIdenticalObjectConsideredEqual() {
        SerializableComparator cmp = SerializableComparator.instance;

        Assert.assertEquals(0, cmp.compare(new Foo(), new Foo()));
        Assert.assertEquals(0, cmp.compare(new Foo("x"), new Foo("x")));
        Assert.assertEquals(0, cmp.compare(new Foo("x", 1L), new Foo("x", 1L)));
    }

    @Test
    public void ensureNonIdenticalObjectConsideredNonEqual() {
        SerializableComparator cmp = SerializableComparator.instance;

        Assert.assertNotEquals(0, cmp.compare(new Foo(), new Foo("x")));
        Assert.assertNotEquals(0, cmp.compare(new Foo("y"), new Foo("x")));
        Assert.assertNotEquals(0, cmp.compare(new Foo("y", 1L), new Foo("y", 2L)));
    }
}
