package Solution.dao;

import Solution.model.User;

import java.util.List;

public interface UsersDao {

    public List<User> index();

    public Object show(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(int id);
}
