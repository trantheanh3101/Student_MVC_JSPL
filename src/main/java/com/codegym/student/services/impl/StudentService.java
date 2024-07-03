package com.codegym.student.services.impl;

import com.codegym.student.dto.StudentDTO;
import com.codegym.student.models.Student;
import com.codegym.student.repositories.IStudentRepository;
import com.codegym.student.repositories.impl.StudentRepository;
import com.codegym.student.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {

    private static IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public StudentDTO findById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(long idEdit, StudentDTO studentEdit) {
        studentRepository.update(idEdit,studentEdit);
    }

}
