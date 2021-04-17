package com.bluff.domain.service;

import com.bluff.domain.dto.user.User;
import com.bluff.domain.repository.UserRepositoryJpa;
import com.bluff.domain.repository.UserRepositoryMemory;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {

    UserService userService;
    UserRepositoryMemory userRepositoryMemory;
    UserRepositoryJpa userRepositoryJpa;

    @Before
    public void beforeEach(){
        userRepositoryMemory = new UserRepositoryMemory();
        userService = new UserService(userRepositoryJpa);
    }

    @After
    public void afterEach(){
        userRepositoryMemory.clearStore();
    }

    @Test
    public void 회원가입() {
        //given
        User user = new User();
        user.setName("블라프");

        //when
        Long saveId = userService.create(user);


        //then
        User findUser = userService.findOne(saveId).get();
        Assertions.assertThat(user.getName()).isEqualTo(findUser.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        User user = new User();
        user.setName("블라프");

        User user2 = new User();
        user2.setName("블라프");

        //when
        userService.create(user);


      try {
          userService.create(user2);
        } catch (IllegalStateException e) {
          System.out.println(e);
        }


    }


    @Test
    public void 전체회원조회() {

    }

    @Test
    public void 회원조회아이디() {

    }
}