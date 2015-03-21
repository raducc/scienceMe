package com.scncm.service;

import com.scncm.dao.UserDAO;
import com.scncm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User getUser(String username) {
        return userDAO.getUser(username);
    }

}
