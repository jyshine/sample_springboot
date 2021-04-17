package com.bluff.domain.repository;

import com.bluff.domain.dto.user.User;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryMemoryTest {
    UserRepositoryMemory repository = new UserRepositoryMemory();

    @After
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        User user = new User();
        user.setName("spring");

        repository.save(user);

        User result = repository.findById(user.getId()).get();
        assertThat(user).isEqualTo(result);
    }

    @Test
    public void findByName(){
        User user1 = new User();
        user1.setName("spring1");
        repository.save(user1);

        User user2 = new User();
        user2.setName("spring2");
        repository.save(user2);

        User result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(user1);
    }

    @Test
    public void findAll() {
        User user1 = new User();
        user1.setName("tester");
        repository.save(user1);

        User user2 = new User();
        user2.setName("tester2");
        repository.save(user2);

        List<User> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
