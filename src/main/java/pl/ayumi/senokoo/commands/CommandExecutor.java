package pl.ayumi.senokoo.commands;

import com.mewna.catnip.entity.message.Embed;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.senokoo.commands.argument.Argument;
import pl.ayumi.senokoo.commands.factory.CommandFactory;

import java.util.List;

public interface CommandExecutor {

     CommandFactory getcommandFactory();
     Message getMessage();
     List<Argument> getArguments();
     Argument getArgument(int index);

     void reply(Message message, final Embed embed);
     void reply(Message message, final String msg);
     void reply(Message message, Message msg);



}
