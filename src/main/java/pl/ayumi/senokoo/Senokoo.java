package pl.ayumi.senokoo;

import com.mewna.catnip.Catnip;
import pl.ayumi.senokoo.commands.commands.HelpCommand;
import pl.ayumi.senokoo.commands.commands.PingCommand;
import pl.ayumi.senokoo.commands.commands.tests.TestCommand;
import pl.ayumi.senokoo.commands.factory.CommandFactory;
import pl.ayumi.senokoo.commands.factory.CommandFactoryImpl;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Senokoo {


        private static Catnip catnip = Catnip.catnip("NTU1MTM5Mjc0NjE0Mzc0NDEz.D26OPQ.Vu5AchO8tPHlkGsgiRdn9XgPjMM") ;
        private static CommandFactory commandFactory = new CommandFactoryImpl(catnip, "!");
        private static CommandFactory test = new CommandFactoryImpl(catnip, "@");
    public static Integer ia = 0;



    public static void main(String[] args){




        // tests
        test.registerCommand(new TestCommand("test", "e", "abc"));
        test.registerCommand(new PingCommand("ping", "Senokoo's Ping", "abc"));
        //
        commandFactory.registerCommand(new HelpCommand("help", "Senokoo's help", "Information"));
        commandFactory.registerCommand(new PingCommand("ping", "Senokoo's Ping", "abc"));
        catnip.connect();
        test.handle();
        commandFactory.handle();
    }
    public static CommandFactory getCommandFactory(){
        return commandFactory;
    }
    public static CommandFactory getTestFactory(){
        return test;
    }
}
