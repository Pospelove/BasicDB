package org.basicdb;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ModelParser {
    public ModelParser(Scanner input, OutputStream output) {
        this.input = input;
        this.output = new PrintStream(output);

        this.fieldHandlers.add(this::handleStringField);
        this.fieldHandlers.add(this::handleFloatField);
        this.fieldHandlers.add(this::handleLongField);

        // Must be last
        this.fieldHandlers.add(this::handleObjectField);
    }

    public <T> T parse(Class<T> cl, long id) {
        try {
            T instance = cl.getConstructor(long.class).newInstance(id);

            handleFields(instance);

            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // TODO: Use checked instead?
            throw new RuntimeException(e);
        }
    }

    private void handleFields(Object instance) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        for (Field f : instance.getClass().getFields()) {
            for (FieldHandler handler : this.fieldHandlers) {
                boolean handled = handler.handle(f, instance);
                if (handled) {
                    break;
                }
            }
        }
    }

    private boolean handleStringField(Field f, Object instance) throws IllegalAccessException {
        if (f.getType().isAssignableFrom(String.class)) {
            printFieldTip(f);
            String line = input.nextLine();
            if (line.length() > 0) {
                f.set(instance, line);
            } else {
                f.set(instance, null);
            }
            return true;
        }
        return false;
    }

    private boolean handleFloatField(Field f, Object instance) throws IllegalAccessException {
        if (f.getType().isAssignableFrom(Float.class)) {
            printFieldTip(f);
            String line = input.nextLine();
            if (line.length() > 0) {
                f.set(instance, Float.parseFloat(line));
            } else {
                f.set(instance, null);
            }
            return true;
        }
        return false;
    }

    private boolean handleLongField(Field f, Object instance) throws IllegalAccessException {
        if (f.getType().isAssignableFrom(Long.class)) {
            printFieldTip(f);
            String line = input.nextLine();
            if (line.length() > 0) {
                f.set(instance, Long.parseLong(line));
            } else {
                f.set(instance, null);
            }
            return true;
        }
        return false;
    }

    private boolean handleObjectField(Field f, Object instance) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        if (!f.getType().isPrimitive()) {
            Object subInstance = f.getType().getConstructor().newInstance();
            currentPath.push(f.getName());
            handleFields(subInstance);
            currentPath.pop();
            f.set(instance, subInstance);
            return true;
        }
        return false;
    }

    private void printFieldTip(Field f) {
        currentPath.forEach(element -> output.print(element + "."));
        output.print(f.getName() + " (" + f.getType().getSimpleName() + "): ");
    }

    @FunctionalInterface
    private interface FieldHandler {
        boolean handle(Field f, Object instance) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
    }

    private final Scanner input;
    private final PrintStream output;
    private final ArrayList<FieldHandler> fieldHandlers = new ArrayList<>();
    private final Stack<String> currentPath = new Stack<>();
}
