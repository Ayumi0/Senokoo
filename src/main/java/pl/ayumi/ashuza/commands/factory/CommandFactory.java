package pl.ayumi.ashuza.commands.factory;

import pl.ayumi.ashuza.commands.Command;
import pl.ayumi.ashuza.commands.CommandImpl;

public interface CommandFactory {

    void handle();

    CommandImpl getCommand(final String name);

    void registerCommand(final CommandImpl command);

    void unRegisterCommand(final CommandImpl command);


}
