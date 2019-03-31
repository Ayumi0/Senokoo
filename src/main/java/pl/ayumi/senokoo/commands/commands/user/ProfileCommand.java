package pl.ayumi.senokoo.commands.commands.user;

import com.mewna.catnip.entity.builder.EmbedBuilder;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.senokoo.Senokoo;
import pl.ayumi.senokoo.commands.CommandImpl;
import pl.ayumi.senokoo.commands.argument.Argument;
import pl.ayumi.senokoo.user.Rank;
import pl.ayumi.senokoo.user.User;
import pl.ayumi.senokoo.user.UserImpl;

import java.util.List;

public class ProfileCommand extends CommandImpl {

    public ProfileCommand(String name, String description, String category) {
        super(name, description, category);
    }

    @Override
    public void onExecute(Message message, List<Argument> args) {
        if (!Senokoo.userFactory.userExist(message.author().id())) {
            User u = new UserImpl(message.author().id(), Rank.NORMAL, 0);
            Senokoo.userFactory.addUser(u);
        }
        User u = Senokoo.userFactory.getUser(message.author().id());
        EmbedBuilder eb = new EmbedBuilder();
        eb.author(message.author().username(), message.author().avatarUrl());
        eb.field("Rank", u.getRank().equals(Rank.NORMAL) ? "Normal" : "Premium", true);
        eb.field("Money", u.getMoney().toString(), true);
        message.channel().sendMessage(eb.build());
    }
}
