package pl.ayumi.ashuza.commands;

import com.mewna.catnip.entity.message.Embed;
import com.mewna.catnip.entity.message.Message;
import pl.ayumi.ashuza.commands.argument.Argument;
import pl.ayumi.ashuza.commands.factory.CommandFactory;

import java.util.List;
import java.util.Optional;

public interface CommandExecutor {

     CommandFactory getcommandFactory();
     Message getMessage();
     List<Argument> getArguments();
     Argument getArgument(int index);

     void reply(Message message, final Embed embed);
     void reply(Message message, final String msg);
     void reply(Message message, Message msg);



}
