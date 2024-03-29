package pl.ayumi.senokoo;

import com.arangodb.ArangoDB;
import com.mewna.catnip.Catnip;
import pl.ayumi.senokoo.commands.commands.HelpCommand;
import pl.ayumi.senokoo.commands.commands.PingCommand;
import pl.ayumi.senokoo.commands.commands.user.ProfileCommand;
import pl.ayumi.senokoo.commands.factory.CommandFactory;
import pl.ayumi.senokoo.commands.factory.CommandFactoryImpl;
import pl.ayumi.senokoo.database.Database;
import pl.ayumi.senokoo.database.DatabaseImpl;
import pl.ayumi.senokoo.user.factory.UserFactory;
import pl.ayumi.senokoo.user.factory.UserFactoryImpl;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Senokoo {


    private static Catnip catnip = Catnip.catnip("NTU1MTM5Mjc0NjE0Mzc0NDEz.D26OPQ.Vu5AchO8tPHlkGsgiRdn9XgPjMM");
    private static CommandFactory commandFactory = new CommandFactoryImpl(catnip, "!");
    private static Database senokoo;

    public static UserFactory userFactory;
    public static String dbname = "senokoo";
    public static String collname = "users";

    public static void main(String[] args) {
        senokoo = new DatabaseImpl("127.0.0.1", 8529, "root", "ayumi");
        userFactory = new UserFactoryImpl();

        commandFactory.registerCommand(new ProfileCommand("profile", "User's Profile", "Information"));
        commandFactory.registerCommand(new HelpCommand("help", "Senokoo's help", "Information"));
        commandFactory.registerCommand(new PingCommand("ping", "Senokoo's Ping", "abc"));
        catnip.connect();
        commandFactory.handle();
        setupDatabase(dbname, collname);
    }

    public static CommandFactory getCommandFactory() {
        return commandFactory;
    }

    private static void setupDatabase(String dbname, String collname) {

        if (!senokoo.collectionExist(dbname, collname)) {
            senokoo.createCollection(dbname, collname);

        }
    }
    public static Database getMainDB(){
        return senokoo;
    }

}
