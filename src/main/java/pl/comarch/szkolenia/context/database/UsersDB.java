package pl.comarch.szkolenia.context.database;

import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.context.model.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class UsersDB implements UsersDBInterface {
    private List<User> users = new ArrayList<>();

    public UsersDB() {
        this.users.add(new User(1, "janusz", "janusz123"));
        this.users.add(new User(2, "karol", "karol987"));
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        for(User tempUser : this.users) {
            if(tempUser.getLogin().equals(login)) {
                return Optional.of(tempUser);
            }
        }
        return Optional.empty();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
