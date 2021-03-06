package org.basicdb;

public interface Command {
    String execute();

    String getDescription();

    /**
     * org.basicdb.CommandFooBar => "foo_bar"
     */
    default String getName() {
        int idx = ("Command").length();
        String fullClassName = this.getClass().getName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);

        String commandNameCamelCase = className.substring(idx);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < commandNameCamelCase.length(); ++i) {
            String character = commandNameCamelCase.substring(i, i + 1);
            boolean isLowerCase = character.toLowerCase().equals(character);
            if (isLowerCase) {
                res.append(character);
            } else {
                if (i > 0) {
                    res.append("_");
                }
                res.append(character.toLowerCase());
            }
        }
        return res.toString();
    }
}
