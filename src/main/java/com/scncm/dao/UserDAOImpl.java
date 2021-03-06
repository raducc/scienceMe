package com.scncm.dao;

import com.scncm.model.User;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

//    Logger logger = LoggerFactory.

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUser(Integer userId) {
        // todo load auxiliary data
        return (User) getCurrentSession().get(User.class, userId);
    }

    public User getUserByUsername(String username) {
        List<User> userList = new ArrayList<User>();
        Query query;
        try {
            query = getCurrentSession().createQuery("from com.scncm.model.User u where username = :username");
            query.setParameter("username", username);
            userList = query.list();
        } catch (QueryException e) {
            System.out.println(e.getMessage());
        }

        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    public User getUserByEmail(String email) {
        List<User> userList = new ArrayList<User>();
        Query query;
        try {
            query = getCurrentSession().createQuery("from com.scncm.model.User u where email = :email");
            query.setParameter("email", email);
            userList = query.list();
        } catch (QueryException e) {
            System.out.println(e.getMessage());
        }

        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    public User addUser(User user) {
        User savedUser = (User) getCurrentSession().save(user);
        getCurrentSession().getTransaction().commit();

        return savedUser;
    }

    public Boolean updateUser (User user) {
        try {
            getCurrentSession().update(user);
            getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteUser (User user) {
        try {
            getCurrentSession().delete(user);
            getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
