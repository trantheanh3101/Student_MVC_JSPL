package com.codegym.student.services;

import com.codegym.student.dto.StudentDTO;
import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<StudentDTO> findByName(String name);

    StudentDTO findById(long id);

    void update(long idEdit, StudentDTO studentEdit);
}
