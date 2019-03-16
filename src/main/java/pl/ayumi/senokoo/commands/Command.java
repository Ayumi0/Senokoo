package pl.ayumi.senokoo.commands;

import pl.ayumi.senokoo.commands.argument.Argument;

import java.util.List;

public interface Command {

    String getDescription();
    String getName();
    List<Argument> getArguments();
    String getCategory();

}
