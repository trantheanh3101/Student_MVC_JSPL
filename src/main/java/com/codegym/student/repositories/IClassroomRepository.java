package com.codegym.student.repositories;

import com.codegym.student.models.Classroom;

import java.util.List;

public interface IClassroomRepository {
    List<Classroom> findAll();
}
