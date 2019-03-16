package pl.ayumi.ashuza;

import com.mewna.catnip.Catnip;
import pl.ayumi.ashuza.commands.commands.HelpCommand;
import pl.ayumi.ashuza.commands.factory.CommandFactory;
import pl.ayumi.ashuza.commands.factory.CommandFactoryImpl;

public class Ashuza {


        private static Catnip catnip = Catnip.catnip("NTQ2MzY1NTg1NzYwNzE0Nzc2.D2bgyw.7QkufKsi_dfClvGwlHxsfjv1vus") ;
        private static CommandFactory commandFactory = new CommandFactoryImpl(catnip, "!", null);

        private static CommandFactory test = new CommandFactoryImpl(catnip, "@", null);



    public static void main(String[] args){

        // tests


        test.registerCommand(new HelpCommand("test", "e", "abc"));
        catnip.connect();
        test.handle();
        commandFactory.handle();
    }
}
