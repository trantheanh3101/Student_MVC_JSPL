package com.codegym.student.services.impl;

import com.codegym.student.models.Classroom;
import com.codegym.student.repositories.IClassroomRepository;
import com.codegym.student.repositories.impl.ClassroomRepository;
import com.codegym.student.services.IClassroomService;

import java.util.List;

public class ClassroomService implements IClassroomService {
    private IClassroomRepository classroomRepository = new ClassroomRepository();

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
