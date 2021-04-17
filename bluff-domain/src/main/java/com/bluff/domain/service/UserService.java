package com.bluff.domain.service;

import com.bluff.domain.dao.UserDao;
import com.bluff.domain.dto.user.User;
import com.bluff.domain.repository.UserRepositoryJpa;
import com.bluff.domain.repository.UserRepositoryMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserRepositoryJpa userDao) {

        this.userDao = userDao;
    }

    /**
     * 회원가입
     *
     * @param user
     * @return
     */
    public Long create(User user) {


        validateDuplicateUser(user);
        userDao.save(user);
        return user.getId();
    }

    /**
     * 중복확인
     *
     * @param user
     */
    private void validateDuplicateUser(User user) {
        userDao.findByName(user.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체 회원 조회
     *
     * @return
     */
    public List<User> findAll(){
        return userDao.findAll();
    }

    public Optional<User> findOne (Long userId){
        return userDao.findById(userId);
    }

}
