package Solution.dao;

import Solution.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UsersDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User").list();
    }

    @Override
    public Object show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userChange = (User) show(id);
        userChange.setName(updateUser.getName());
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User userDelete = (User) show(id);
        session.delete(userDelete);
    }

}
