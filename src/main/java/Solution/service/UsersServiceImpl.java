package Solution.service;

import Solution.dao.UsersDao;
import Solution.dao.UsersDaoImpl;
import Solution.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    @Transactional
    public List<User> index() {
        return usersDao.index();
    }

    @Override
    @Transactional
    public Object show(int id) {
        return usersDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        usersDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        usersDao.update(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usersDao.delete(id);
    }
}
