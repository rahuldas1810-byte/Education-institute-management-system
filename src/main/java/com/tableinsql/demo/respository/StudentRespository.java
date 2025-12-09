package com.tableinsql.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tableinsql.demo.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository  extends JpaRepository<Student,Long> {

}
