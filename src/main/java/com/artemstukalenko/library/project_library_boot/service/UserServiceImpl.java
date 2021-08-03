package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.dao.UserDAO;
import com.artemstukalenko.library.project_library_boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void blockUser(String username) {
        userDAO.blockUser(username);
    }

    @Override
    @Transactional
    public void unblockUser(String username) {
        userDAO.unblockUser(username);
    }

    @Override
    @Transactional
    public String getUserRole(String username) {
        return userDAO.getUserRole(username);
    }
}
