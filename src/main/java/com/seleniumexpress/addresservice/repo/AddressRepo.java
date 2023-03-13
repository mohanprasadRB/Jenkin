package com.seleniumexpress.addresservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seleniumexpress.addresservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	
	@Query(nativeQuery = true, value = "select * from seleniumexpress.address ea join seleniumexpress.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	Address findAddessByEmployeeId(@Param("employeeId") int employeeId); 

}
