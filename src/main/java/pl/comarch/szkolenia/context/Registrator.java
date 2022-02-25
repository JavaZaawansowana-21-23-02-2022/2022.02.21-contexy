package pl.comarch.szkolenia.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.comarch.szkolenia.context.database.UsersDB;
import pl.comarch.szkolenia.context.database.UsersDB2;
import pl.comarch.szkolenia.context.database.UsersDBInterface;
import pl.comarch.szkolenia.context.model.User;

import java.util.Optional;

@Component
public class Registrator {

    @Autowired
    @Qualifier("u3")
    UsersDBInterface usersDB;

    public boolean register(String login, String pass) {
        Optional<User> userFromDb = usersDB.findUserByLogin(login);
        if(userFromDb.isPresent()) {
            return false;
        }

        User user = new User();
        user.setLogin(login);
        user.setPass(pass);
        usersDB.addUser(user);

        return true;
    }
}
