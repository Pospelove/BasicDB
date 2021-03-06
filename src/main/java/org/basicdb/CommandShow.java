package org.basicdb;

import java.util.ArrayList;
import java.util.List;

public class CommandShow implements Command {
    public <T extends IdHolder> CommandShow(Storage<T> storage, Serializer serializer) {
        pr = () -> {
            List<String> res = new ArrayList<>();
            storage.forEach(element -> {
                res.add(serializer.serialize(element));
            });
            return res;
        };
    }

    @Override
    public String execute() {
        StringBuilder res = new StringBuilder();
        pr.getSerializedStorageElements().forEach(str -> res.append(str).append("\n\n"));
        return res.toString();
    }

    @Override
    public String getDescription() {
        return "print all elements of the collection to stdout in string representation";
    }

    @FunctionalInterface
    private interface SerializedStorageElementsProvider {
        List<String> getSerializedStorageElements();
    }

    SerializedStorageElementsProvider pr;
}
