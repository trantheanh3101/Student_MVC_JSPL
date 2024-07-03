package com.codegym.student.repositories;

import com.codegym.student.dto.StudentDTO;
import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    List<StudentDTO> findByName(String name);

    StudentDTO findById(long id);

    void update(long idEdit, StudentDTO studentEdit);
}
