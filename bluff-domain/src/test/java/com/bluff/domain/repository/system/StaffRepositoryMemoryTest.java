package com.bluff.domain.repository.system;

import com.bluff.domain.dto.system.Staff;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StaffRepositoryMemoryTest {

    StaffRepositoryMemory repository = new StaffRepositoryMemory();

//    @Test
//    public void save() {
//        Staff staff = new Staff();
//        staff.setEmail("shin@gmail.com");
//        staff.setFirstName("jy");
//        staff.setLastName("shin");
//        staff.setNickName("will");
//        staff.setPassword("1234");
//        staff.setTel("01012341234");
//
//        repository.save(staff);
//
//
//    }
//
//    @Test
//    public void findById() {
//        Staff staff = new Staff();
//        staff.setEmail("shin@gmail.com");
//        staff.setFirstName("jy");
//        staff.setLastName("shin");
//        staff.setNickName("will");
//        staff.setPassword("1234");
//        staff.setTel("01012341234");
//
//        Staff saved = repository.save(staff);
//
//        Staff result = repository.findById(saved.getId()).get();
//        Assertions.assertThat(result.getNickName()).isEqualTo(saved.getNickName());
//    }
//
//    @Test
//    public void findAll() {
//    }
}