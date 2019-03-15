package pl.ayumi.ashuza.commands;

import pl.ayumi.ashuza.commands.argument.Argument;

import java.util.List;

public abstract class CommandImpl implements Command{
    private String name, description, category;
    private List<Argument> arguments;

    public CommandImpl(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Argument> getArguments() {
        return arguments;
    }

    @Override
    public String getCategory() {
        return category;
    }


    public abstract void onExecute(List<Argument> args);
}
