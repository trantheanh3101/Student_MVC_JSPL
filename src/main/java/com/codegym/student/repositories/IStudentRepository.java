package com.codegym.student.repositories;

import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<Student> findByName(String name);
}
