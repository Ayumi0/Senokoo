package pl.ayumi.senokoo;

import com.mewna.catnip.Catnip;
import pl.ayumi.senokoo.commands.commands.HelpCommand;
import pl.ayumi.senokoo.commands.commands.tests.TestCommand;
import pl.ayumi.senokoo.commands.factory.CommandFactory;
import pl.ayumi.senokoo.commands.factory.CommandFactoryImpl;

public class Senokoo {


        private static Catnip catnip = Catnip.catnip("NTU1MTM5Mjc0NjE0Mzc0NDEz.D26OPQ.Vu5AchO8tPHlkGsgiRdn9XgPjMM") ;
        private static CommandFactory commandFactory = new CommandFactoryImpl(catnip, "!");
        private static CommandFactory test = new CommandFactoryImpl(catnip, "@");



    public static void main(String[] args){

        // tests
        test.registerCommand(new TestCommand("test", "e", "abc"));
        //
        commandFactory.registerCommand(new HelpCommand("help", "Senokoo's help", "Information"));
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
