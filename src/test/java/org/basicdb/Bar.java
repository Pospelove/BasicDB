package org.basicdb;

public class Bar extends IdHolder implements Comparable<Bar> {
    public Bar(long id, String barName) {
        super(id);
        this.barName = barName;
    }

    public String barName;

    @Override
    public int compareTo(Bar o) {
        return barName.compareTo(o.barName);
    }
}
