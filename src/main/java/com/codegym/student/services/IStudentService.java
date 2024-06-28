package com.codegym.student.services;

import com.codegym.student.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
