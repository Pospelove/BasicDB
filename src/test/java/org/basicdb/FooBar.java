package org.basicdb;

public class FooBar extends IdHolder implements Comparable<Bar> {
    public FooBar(long id) {
        super(id);
    }

    public static class Dummy {
        public String s;
    }

    public String str1;
    public String str2;
    public Dummy dummy1;
    public Float floatObject1;
    public Float floatObject2;

    @Override
    public int compareTo(Bar o) {
        return SerializableComparator.instance.compare(this, o);
    }
}
