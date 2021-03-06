package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.io.OutputStream;
import java.util.Scanner;

public class ModelParserTest {
    @Test
    public void ensureModelParserIsAbleToLoadBarFromScanner() {
        Scanner input = new Scanner("Hello\n");
        OutputStream output = new StringStream();

        Bar bar = new ModelParser(input, output).parse(Bar.class, 1);

        JsonSerializer serializer = new JsonSerializer();
        Assert.assertEquals(serializer.serialize(bar), serializer.serialize(new Bar(1, "Hello")));
        Assert.assertEquals(output.toString(), "barName (String): ");
    }

    @Test
    public void ensureModelParserIsAbleToLoadFooBarFromScanner() {
        Float expectedPi = 3.14f;

        Scanner input = new Scanner("Tele\n\nDddd\n3.14\n\n");
        OutputStream output = new StringStream();

        FooBar ticket = new ModelParser(input, output).parse(FooBar.class, 1);

        JsonSerializer serializer = new JsonSerializer();
        Assert.assertEquals("Tele", ticket.str1);
        Assert.assertNull(ticket.str2);
        Assert.assertEquals("Dddd", ticket.dummy1.s);
        Assert.assertEquals(expectedPi, ticket.floatObject1);
        Assert.assertNull(ticket.floatObject2);
        Assert.assertEquals(output.toString(), "str1 (String): str2 (String): dummy1.s (String): floatObject1 (Float): floatObject2 (Float): ");
    }
}
