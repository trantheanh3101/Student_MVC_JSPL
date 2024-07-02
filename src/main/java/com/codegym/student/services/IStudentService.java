package com.codegym.student.services;

import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<Student> findByName(String name);

    Student findById(long id);

    void update(long idEdit, Student studentEdit);
}
