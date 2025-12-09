package com.tableinsql.demo.service;

import com.tableinsql.demo.model.Student;
import com.tableinsql.demo.respository.StudentRespository;   // note: respository (your package)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    private final StudentRespository repository;

    @Autowired
    public StudentsService(StudentRespository repository) {
        this.repository = repository;
    }

    // GET /students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET /students/{id}
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // POST /students
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    // PUT /students/{id}
    public Student updateStudentById(Long id, Student newData) {
        return repository.findById(id)
                .map(student -> {
                    // field names: firstname, lastname, age (so Lombok generated getFirstname, etc.)
                    student.setFirstname(newData.getFirstname());
                    student.setLastname(newData.getLastname());
                    student.setAge(newData.getAge());
                    return repository.save(student);
                })
                .orElse(null);
    }

    // DELETE /students/{id}
    public String deleteStudentById(Long id) {
        repository.deleteById(id);
        return "deleted";
    }
}
