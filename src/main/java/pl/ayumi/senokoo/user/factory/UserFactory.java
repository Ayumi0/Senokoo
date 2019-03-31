package pl.ayumi.senokoo.user.factory;


import pl.ayumi.senokoo.user.User;

import java.util.ArrayList;

public interface UserFactory {
    ArrayList<User> getUsers();

    User getUser(String id);

    void addUser(User user);

    void removeUser(User user);

    boolean userExist(String id);
}
