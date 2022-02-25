package pl.comarch.szkolenia.context.database;

import pl.comarch.szkolenia.context.model.User;

import java.util.Optional;

public interface UsersDBInterface {
    Optional<User> findUserByLogin(String login);
    void addUser(User user);
}
