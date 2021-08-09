package com.artemstukalenko.library.project_library_boot.dao.implementators;

import com.artemstukalenko.library.project_library_boot.dao.UserDAO;
import com.artemstukalenko.library.project_library_boot.entity.Authority;
import com.artemstukalenko.library.project_library_boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Transactional
    public void blockUser(String username) {
        Query queryForBlockingUser = entityManager.createQuery("update User set enabled = 0 where username =: userUsername");

        queryForBlockingUser.setParameter("userUsername", username);
        queryForBlockingUser.executeUpdate();
    }

    @Override
    @Transactional
    public void unblockUser(String username) {
        Query queryForUnblockingUser = entityManager.createQuery("update User set enabled = 1 where username =: userUsername");

        queryForUnblockingUser.setParameter("userUsername", username);
        queryForUnblockingUser.executeUpdate();
    }

    @Override
    @Transactional
    public String getUserRole(String username) {
        Query queryForGettingUserRole = entityManager.createQuery("select authority from Authority where username in " +
                "(select username from User where username =: usernameForSearch)");

        queryForGettingUserRole.setParameter("usernameForSearch", username);
        return (String) queryForGettingUserRole.getSingleResult();

    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        deleteAuthority(username);

        deleteUserDetails(username);

        deleteUserSubscriptions(username);

        Query queryForDeletingUser = entityManager.createQuery("delete from User where username =: username");
        queryForDeletingUser.setParameter("username", username);
        queryForDeletingUser.executeUpdate();
    }

    @Transactional
    protected void deleteAuthority(String username) {
        Query queryForDeletingAuthority = entityManager.createQuery("delete from Authority where username =: username");
        queryForDeletingAuthority.setParameter("username", username);
        queryForDeletingAuthority.executeUpdate();
    }

    @Transactional
    protected void deleteUserDetails(String username) {
        Query queryForDeletingUserDetails = entityManager.createQuery("delete from UserDetails where username =: username");
        queryForDeletingUserDetails.setParameter("username", username);
        queryForDeletingUserDetails.executeUpdate();
    }

    @Transactional
    protected void deleteUserSubscriptions(String username) {
        Query queryForUpdatingBookInfo = entityManager.createQuery("update Book set taken = false " +
                "where bookId in (select bookId from Subscription where username =: username)");
        queryForUpdatingBookInfo.setParameter("username", username);
        queryForUpdatingBookInfo.executeUpdate();

        Query queryForDeletingUserSubscriptions = entityManager.createQuery("delete from Subscription where username =: username");
        queryForDeletingUserSubscriptions.setParameter("username", username);
        queryForDeletingUserSubscriptions.executeUpdate();
    }

    @Override
    @Transactional
    public void makeUserLibrarian(String username) {
        Query queryForMakingUserLibrarian = entityManager.createQuery("update Authority set authority = 'ROLE_LIBRARIAN'" +
                "where username =: username");
        queryForMakingUserLibrarian.setParameter("username", username);
        queryForMakingUserLibrarian.executeUpdate();
    }

    @Override
    @Transactional
    public void depriveLibrarianPrivileges(String username) {
        Query queryForMakingUserLibrarian = entityManager.createQuery("update Authority set authority = 'ROLE_USER'" +
                "where username =: username");
        queryForMakingUserLibrarian.setParameter("username", username);
        queryForMakingUserLibrarian.executeUpdate();
    }

    @Override
    @Transactional
    public void updatePenaltyInfo(String username, int updateSum) {
        Query queryForUpdatingPenaltyInfo = entityManager.createQuery("update UserDetails " +
                "set userPenalty =: updateSum where username =: username");
        queryForUpdatingPenaltyInfo.setParameter("updateSum", updateSum);
        queryForUpdatingPenaltyInfo.setParameter("username", username);

        queryForUpdatingPenaltyInfo.executeUpdate();
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        Authority newUserAuthority = new Authority(user.getUsername(), "ROLE_USER");

        user.setPassword(getEncodedPassword(user.getPassword()));

        entityManager.persist(user);
        entityManager.persist(newUserAuthority);
    }

    private String getEncodedPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

        return "{bcrypt}" + encoder.encode(rawPassword);
    }
}
