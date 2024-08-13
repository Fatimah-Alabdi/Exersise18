package com.example.exersise18.Repository;

import com.example.exersise18.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT u from User u where u.Email=?1")
    User searchByemeil(String email);

    List<User> findUserByRole(String role);
    @Query("SELECT u from User u where u.age>=?1")
    List<User> searchUserByAgeOrAbove(int age);


}
