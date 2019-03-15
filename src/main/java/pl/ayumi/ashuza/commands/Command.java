package pl.ayumi.ashuza.commands;

import pl.ayumi.ashuza.commands.argument.Argument;

import java.util.List;

public interface Command {

    String getDescription();
    String getName();
    List<Argument> getArguments();
    String getCategory();

}
