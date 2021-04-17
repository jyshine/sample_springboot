package com.bluff.domain.service.system;

import com.bluff.domain.dao.system.StaffDao;
import com.bluff.domain.dto.system.Staff;
import com.bluff.domain.repository.system.StaffRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
public class StaffServiceTest {


    StaffService staffService;

    @Test
    public void create() {
    //    Staff staff = new Staff();
//        staff.setEmail("shin@gmail.com");
//        staff.setFirstName("jy");
//        staff.setLastName("shin");
//        staff.setNickName("will");
//        staff.setPassword("1234");
//        staff.setTel("01012341234");

      //  Long saveId = staffService.create(staff);


    }
}