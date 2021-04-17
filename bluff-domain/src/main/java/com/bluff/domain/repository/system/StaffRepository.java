package com.bluff.domain.repository.system;

import com.bluff.domain.dao.system.StaffDao;
import com.bluff.domain.dto.system.Staff;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Long>, StaffDao {

}
