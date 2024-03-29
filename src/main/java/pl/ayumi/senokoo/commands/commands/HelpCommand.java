package pl.ayumi.senokoo.commands.commands;

import com.mewna.catnip.entity.builder.EmbedBuilder;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.senokoo.Senokoo;
import pl.ayumi.senokoo.commands.CommandImpl;
import pl.ayumi.senokoo.commands.argument.Argument;

import java.util.List;

public class HelpCommand extends CommandImpl {
    public HelpCommand(String name, String description, String category) {
        super(name, description, category);
    }

    @Override
    public void onExecute(Message message, List<Argument> args) {

        EmbedBuilder e = new EmbedBuilder();
        Senokoo.getCommandFactory().getCommands().forEach(command -> {
            e.author(message.author().username(), message.author().avatarUrl());
            e.field(command.getName(), command.getDescription(), true);
        });
        message.channel().sendMessage(e.build());
    }


}
