package com.bluff.domain.dao.system;

import com.bluff.domain.dto.system.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffDao {

    Staff save(Staff staff);
    Optional<Staff> findById(Long id);
    List<Staff> findAll();

}
