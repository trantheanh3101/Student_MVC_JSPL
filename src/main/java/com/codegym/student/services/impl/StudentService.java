package com.codegym.student.services.impl;

import com.codegym.student.models.Student;
import com.codegym.student.repositories.IStudentRepository;
import com.codegym.student.repositories.impl.StudentRepository;
import com.codegym.student.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {

    private static IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
