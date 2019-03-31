package pl.ayumi.senokoo.user.factory;

import com.arangodb.entity.BaseDocument;
import pl.ayumi.senokoo.Senokoo;
import pl.ayumi.senokoo.user.User;

import java.util.ArrayList;

public class UserFactoryImpl implements UserFactory {
    private ArrayList<User> users;

    public UserFactoryImpl() {
        users = new ArrayList<>();
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String id) {
        for (User u : users) {
            if (u.getID().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        if (!Senokoo.getMainDB().documentExist(Senokoo.dbname, Senokoo.collname, user.getID())) {
            BaseDocument doc = new BaseDocument();
            doc.setKey(user.getID());
            doc.addAttribute("Rank", user.getRank());
            doc.addAttribute("Money", user.getMoney());
            Senokoo.getMainDB().createDocument(Senokoo.dbname, Senokoo.collname, doc);

        }
        users.add(user);
        System.out.println("Successfully registered user with ID: " + user.getID());
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
        System.out.println("Successfully deleted user with ID: " + user.getID());
    }

    @Override
    public boolean userExist(String id) {
        for (User u : users) {
            if (u.getID().equals(id)) {
                if (!Senokoo.getMainDB().documentExist(Senokoo.dbname, Senokoo.collname, id)) {
                    BaseDocument doc = new BaseDocument();
                    doc.setKey(u.getID());
                    doc.addAttribute("Rank", u.getRank());
                    doc.addAttribute("Money", u.getMoney());
                    Senokoo.getMainDB().createDocument(Senokoo.dbname, Senokoo.collname, doc);
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}
