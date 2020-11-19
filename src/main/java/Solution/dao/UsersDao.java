package Solution.dao;

import Solution.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDao {

    private List<User> usersList;
    private int count;

    {
        usersList = new ArrayList<>();
        usersList.add(new User(++count, "Tom"));
        usersList.add(new User(++count, "Jerry"));
        usersList.add(new User(++count, "Anna"));
        usersList.add(new User(++count, "Mary"));
        usersList.add(new User(++count, "Bob"));
    }

    public List<User> index() {
        return usersList;
    }

    public User show(int id) {
        User user1 = null;
        for (User user : usersList) {
            if (user.getId() == id)
                user1 = user;
        }
        return user1;
    }

    public void save(User user){
        user.setId(++count);
        usersList.add(user);
    }

    public void update(int id, User updateUser) {
        User userChange = show(id);
        userChange.setName(updateUser.getName());
    }

    public void delete(int id) {
        usersList.removeIf(p -> p.getId() == id);
    }
}
