package com.bluff.domain.repository;

import com.bluff.domain.dao.UserDao;
import com.bluff.domain.dto.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserDao {


    Optional<User> findByName(String name);
}
