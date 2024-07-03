package com.codegym.student.services;

import com.codegym.student.models.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
}
