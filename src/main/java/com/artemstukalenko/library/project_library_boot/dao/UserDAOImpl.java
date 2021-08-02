package com.artemstukalenko.library.project_library_boot.dao;

import com.artemstukalenko.library.project_library_boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query queryForGettingAllUsers = entityManager.createQuery("from User where username not in (from Authority where authority = 'ROLE_ADMIN')");

        return queryForGettingAllUsers.getResultList();
    }

    @Override
    public void blockUser(String username) {
        Query queryForBlockingUser = entityManager.createQuery("update User set enabled = 0 where username =: userUsername");

        queryForBlockingUser.setParameter("userUsername", username);
        queryForBlockingUser.executeUpdate();
    }

    public void unblockUser(String username) {
        Query queryForUnblockingUser = entityManager.createQuery("update User set enabled = 1 where username =: userUsername");

        queryForUnblockingUser.setParameter("userUsername", username);
        queryForUnblockingUser.executeUpdate();
    }

}
