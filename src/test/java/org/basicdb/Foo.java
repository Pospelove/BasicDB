package org.basicdb;

import java.io.Serializable;

public class Foo implements Serializable {
    Foo() {
    }

    Foo(String a) {
        this.a = a;
    }

    Foo(String a, Long b) {
        this.a = a;
        this.b = b;
    }

    String a;
    Long b;
}