package pl.ayumi.ashuza.commands.commands;

import pl.ayumi.ashuza.commands.CommandImpl;
import pl.ayumi.ashuza.commands.argument.Argument;

import java.util.List;

public class TestCommand extends CommandImpl {
    public TestCommand(String name, String description, String category) {
        super(name, description, category);
    }

    @Override
    public void onExecute(List<Argument> args) {
        System.out.println("Executed");
        System.out.println(args.get(0).getValue() + " Type: " + args.get(0).getType());

    }
}
