package pl.ayumi.ashuza.commands.argument;

import com.mewna.catnip.entity.message.Message;

import java.util.*;

public class ArgumentParser {

    public static List<Argument> parse(Message message){
        final List<Argument> argsa = new ArrayList<>();
        final String[] args = message.content().split(" ");
        final List<String> arguments = new ArrayList<>(Arrays.asList(args));
        arguments.remove(0);
        arguments.forEach(arg -> {
            Argument argument = new ArgumentImpl(arg.getClass(), arg);
            argsa.add(argument);
        });
        return argsa;

       
    }
}
