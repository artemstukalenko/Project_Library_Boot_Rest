package com.artemstukalenko.library.project_library_boot.service.implementators;

import com.artemstukalenko.library.project_library_boot.dao.UserDAO;
import com.artemstukalenko.library.project_library_boot.entity.User;
import com.artemstukalenko.library.project_library_boot.service.UserService;
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

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        userDAO.registerUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

    @Override
    @Transactional
    public void makeUserLibrarian(String username) {
        userDAO.makeUserLibrarian(username);
    }

    @Override
    @Transactional
    public void depriveLibrarianPrivileges(String username) {
        userDAO.depriveLibrarianPrivileges(username);
    }
}
