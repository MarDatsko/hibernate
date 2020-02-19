package com.homework.library.repos;

import com.homework.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "" )
    User findByUserName (String userName);
}
