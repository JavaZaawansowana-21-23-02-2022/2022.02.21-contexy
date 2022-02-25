package pl.comarch.szkolenia.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.context.database.UsersDB;
import pl.comarch.szkolenia.context.database.UsersDB2;
import pl.comarch.szkolenia.context.database.UsersDBInterface;
import pl.comarch.szkolenia.context.model.User;

import java.util.Optional;

@Component
public class Authenticator {

    @Autowired
    @Qualifier("u2")
    UsersDBInterface usersDB;

    public boolean authenticate(String login, String pass) {
        Optional<User> userBox = this.usersDB.findUserByLogin(login);
        if(userBox.isPresent()) {
            User user = userBox.get();
            return user.getPass().equals(pass);
        }
        return false;
    }
}
