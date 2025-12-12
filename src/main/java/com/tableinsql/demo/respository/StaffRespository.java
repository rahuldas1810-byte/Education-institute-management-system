package com.tableinsql.demo.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.tableinsql.demo.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRespository extends JpaRepository<Staff,Long> {


}
