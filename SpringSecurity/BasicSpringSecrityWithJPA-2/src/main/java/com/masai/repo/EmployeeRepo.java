package com.masai.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Optional<Employee> findByUserName(String username);
}
