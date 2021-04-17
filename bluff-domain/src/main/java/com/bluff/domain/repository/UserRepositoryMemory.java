package com.bluff.domain.repository;


import com.bluff.domain.dao.UserDao;
import com.bluff.domain.dto.user.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryMemory implements UserDao {
    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream().filter(user -> user.getName().equals(name)).findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
