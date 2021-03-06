package com.bluff.domain.repository;

import com.bluff.domain.dao.UserDao;
import com.bluff.domain.dto.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJpa implements UserDao {

    private final EntityManager em;

    public UserRepositoryJpa(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }
    public Optional<User> findByName(String name) {
        List<User> result = em.createQuery("select m from User m where m.name = :Abstract", User.class).setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
}
