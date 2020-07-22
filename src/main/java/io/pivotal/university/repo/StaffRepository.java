package io.pivotal.university.repo;

import io.pivotal.university.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff,Integer> {
}
