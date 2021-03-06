package org.basicdb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandInfo implements Command {
    public <T extends IdHolder> CommandInfo(Storage<T> storage, Date storageInitializationDate) {
        this.storageInitializationDate = storageInitializationDate;
        this.storageSimpleName = storage.getClass().getSimpleName();
        numElementsAccess = () -> {
            List<T> list = new ArrayList<T>();
            storage.forEach(list::add);
            return list.size();
        };
    }


    @Override
    public String execute() {
        String res = "";
        res += "Storage type: " + storageSimpleName + "\n";
        res += "Initialization date: " + storageInitializationDate + "\n";
        res += "Elements count: " + numElementsAccess.getNumElements() + "\n";
        return res;
    }

    @Override
    public String getDescription() {
        return "print collection information to standard output";
    }

    private final Date storageInitializationDate;
    private final String storageSimpleName;

    @FunctionalInterface
    private interface NumElementsAccess {
        int getNumElements();
    }

    private final NumElementsAccess numElementsAccess;
}
