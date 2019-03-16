package pl.ayumi.senokoo.commands.factory;

import pl.ayumi.senokoo.commands.Command;
import pl.ayumi.senokoo.commands.CommandImpl;

import java.util.List;

public interface CommandFactory {

    void handle();

    CommandImpl getCommand(final String name);

    void registerCommand(final CommandImpl command);

    void unRegisterCommand(final CommandImpl command);

    List<CommandImpl> getCommands();


}
