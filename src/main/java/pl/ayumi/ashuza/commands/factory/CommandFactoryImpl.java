package pl.ayumi.ashuza.commands.factory;

import com.mewna.catnip.Catnip;
import com.mewna.catnip.shard.DiscordEvent;
import pl.ayumi.ashuza.commands.CommandImpl;
import pl.ayumi.ashuza.commands.argument.ArgumentParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandFactoryImpl implements CommandFactory {
    private final Catnip catnip;
    private final String prefix;
    private final ArrayList<CommandImpl> commands;

    public CommandFactoryImpl(final Catnip catnip, final String prefix, final ArrayList<CommandImpl> commands) {
        this.catnip = catnip;
        this.prefix = prefix;
        this.commands = new ArrayList<>();
    }

    @Override
    public void handle() {
        catnip.on(DiscordEvent.MESSAGE_CREATE, message -> {
            if (!message.content().startsWith(prefix)) {
                return;
            }
            final String[] args = message.content().split(" ");
            if (args.length == 0) {
                return;
            }
            final String name = args[0].substring(prefix.length());
            final Optional<CommandImpl> command = Optional.of(this.getCommand(name));
            final CommandImpl cmd = command.get();

            final List<String> arguments = new ArrayList<>(Arrays.asList(args));
            arguments.remove(0);
            cmd.onExecute(ArgumentParser.parse(message));



        });
    }

    @Override
    public CommandImpl getCommand(final String name) {
        for (CommandImpl command : commands) {
            if (command.getName().equals(name)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public void registerCommand(CommandImpl command) {
        if (commands.contains(command)) {
            return;
        }
        commands.add(command);
    }

    @Override
    public void unRegisterCommand(CommandImpl command) {
        if (commands.contains(command)) {
            return;
        }
        commands.remove(command);
    }
}
