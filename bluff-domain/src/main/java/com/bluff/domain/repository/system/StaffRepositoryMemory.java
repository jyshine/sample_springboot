package com.bluff.domain.repository.system;

import com.bluff.domain.dao.system.StaffDao;
import com.bluff.domain.dto.system.Staff;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StaffRepositoryMemory implements StaffDao {
    private static Map<Long, Staff> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Staff save(Staff staff) {
        staff.setId(++sequence);
        store.put(staff.getId(),staff);
        return staff;
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Staff> findAll() {
        return new ArrayList<>(store.values());
    }
}
