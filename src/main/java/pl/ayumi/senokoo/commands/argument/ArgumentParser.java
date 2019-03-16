package pl.ayumi.senokoo.commands.argument;

import com.mewna.catnip.entity.message.Message;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class ArgumentParser {

    public static List<Argument> parse(Message message){


        final List<Argument> argsa = new ArrayList<>();
        final String[] args = message.content().split(" ");
        final List<String> arguments = new ArrayList<>(Arrays.asList(args));
        arguments.remove(0);
        arguments.forEach(arg -> {
           if(NumberUtils.isCreatable(arg) && !arg.contains(".")){
                Argument argument = new ArgumentImpl(Integer.class, arg);
                argsa.add(argument);
                return;
            }
            if(NumberUtils.isCreatable(arg) && arg.contains(".")){
                Argument argument = new ArgumentImpl(Double.class, arg);
                argsa.add(argument);
                return;
            }
            Argument argument = new ArgumentImpl(String.class, arg);
            argsa.add(argument);

        });
        return argsa;
    }
}
