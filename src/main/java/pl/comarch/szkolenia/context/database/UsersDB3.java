package pl.comarch.szkolenia.context.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.context.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component("u3")
public class UsersDB3 implements UsersDBInterface {
    private List<User> users = new LinkedList<>();

    public UsersDB3() {
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
