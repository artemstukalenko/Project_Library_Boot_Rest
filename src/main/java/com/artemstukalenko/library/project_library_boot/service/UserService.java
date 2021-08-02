package com.artemstukalenko.library.project_library_boot.service;

import com.artemstukalenko.library.project_library_boot.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void blockUser(String username);

    public void unblockUser(String username);

}
