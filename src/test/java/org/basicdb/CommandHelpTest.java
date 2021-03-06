package org.basicdb;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

class CommandFooBar implements Command {
    @Override
    public String execute() {
        return "";
    }

    @Override
    public String getDescription() {
        return "dummy command";
    }
}

public class CommandHelpTest {
    @Test
    public void ensureHelpCommandReturnsListOfAvailableCommand() {
        ArrayList<Command> list = new ArrayList<Command>(Collections.singletonList(new CommandFooBar()));
        CommandHelp cmd = new CommandHelp(list);
        String res = cmd.execute();

        String expected = "";
        expected += "help - display help for the available commands\n";
        expected += "foo_bar - dummy command\n";
        Assert.assertEquals(expected, res);
    }
}
