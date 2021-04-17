package com.bluff.domain.dto.system;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@EnableJpaRepositories("com.bluff.domain.dto.system")
@SpringBootTest()
@Transactional
@Rollback(false)
public class StaffTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity() {
        Staff staff = new Staff();
        staff.setTel("01012341234");
        staff.setPassword("1234");
        staff.setNickName("tester");
        staff.setLastName("shin");
        staff.setFirstName("jy");
        staff.setEmail("shine@gmail.com");

        em.persist(staff);


    }
}