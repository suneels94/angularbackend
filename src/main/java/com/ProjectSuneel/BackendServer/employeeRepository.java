package com.ProjectSuneel.BackendServer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProjectSuneel.BackendServer.model.employee;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<employee, Long> {
}
