package pl.ayumi.senokoo.commands.commands;

import com.mewna.catnip.Catnip;
import com.mewna.catnip.entity.builder.EmbedBuilder;
import com.mewna.catnip.entity.message.Embed;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.senokoo.Senokoo;
import pl.ayumi.senokoo.commands.CommandImpl;
import pl.ayumi.senokoo.commands.argument.Argument;

import java.util.List;

public class PingCommand extends CommandImpl {
    public PingCommand(String name, String description, String category) {
        super(name, description, category);
    }

    @Override
    public void onExecute(Message message, List<Argument> args) {
        long l = System.currentTimeMillis();
        EmbedBuilder e = new EmbedBuilder();
        e.author(message.author().username(), message.author().avatarUrl());
        e.field("Senokoo's Ping", "Calculating :stopwatch:", true);
        message.channel().sendMessage(e.build()).thenAccept( messagel -> {
            EmbedBuilder e2 = new EmbedBuilder();
            e2.author(message.author().username(), message.author().avatarUrl());
            e2.field("Senokoo's Ping", String.valueOf(System.currentTimeMillis() - l), true);
            messagel.edit(e2.build());
        });
    }
}
