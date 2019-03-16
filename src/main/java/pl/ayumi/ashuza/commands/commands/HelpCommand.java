package pl.ayumi.ashuza.commands.commands;

import com.mewna.catnip.entity.message.Message;
import pl.ayumi.ashuza.commands.CommandImpl;
import pl.ayumi.ashuza.commands.argument.Argument;

import java.util.List;

public class HelpCommand extends CommandImpl {
    public HelpCommand(String name, String description, String category) {
        super(name, description, category);
    }

    @Override
    public void onExecute(Message message, List<Argument> args) {

        message.channel().sendMessage("test");
    }


}
