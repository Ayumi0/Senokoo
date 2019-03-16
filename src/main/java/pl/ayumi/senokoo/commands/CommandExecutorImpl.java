package pl.ayumi.senokoo.commands;

import com.mewna.catnip.entity.message.Embed;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.senokoo.commands.argument.Argument;
import pl.ayumi.senokoo.commands.factory.CommandFactory;

import java.util.List;

public class CommandExecutorImpl implements CommandExecutor {
    private CommandFactory commandFactory;
    private Message message;
    private List<Argument> args;

    public CommandExecutorImpl(CommandFactory commandFactory, Message message, List<Argument> args) {
        this.commandFactory = commandFactory;
        this.message = message;
        this.args = args;
    }

    @Override
    public CommandFactory getcommandFactory() {
        return commandFactory;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public List<Argument> getArguments() {
        return args;
    }

    @Override
    public Argument getArgument(int index) {
        return args.get(index);
    }

    @Override
    public void reply(Message message, Embed embed) {
        message.channel().sendMessage(embed);
    }

    @Override
    public void reply(Message message, String msg) {
        message.channel().sendMessage(msg);

    }

    @Override
    public void reply(Message message, Message msg) {
        message.channel().sendMessage(msg);

    }
}
