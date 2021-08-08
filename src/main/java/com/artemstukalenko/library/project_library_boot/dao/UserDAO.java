package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.User;
import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void blockUser(String username);

    public void unblockUser(String username);

    public String getUserRole(String username);

    public void registerUser(User user);

    public User findUserByUsername(String username);

    public void updateUser(User user);

    public void deleteUser(String username);

    public void makeUserLibrarian(String username);

    public void depriveLibrarianPrivileges(String username);
}
