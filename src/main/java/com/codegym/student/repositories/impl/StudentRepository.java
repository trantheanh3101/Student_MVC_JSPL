package com.codegym.student.repositories.impl;

import com.codegym.student.models.Student;
import com.codegym.student.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L,"haiTT", "QN", 10.0f));
        students.add(new Student(2L,"Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L,"Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L,"Cook", "Bàn ăn", 2f));
    }

    @Override
    public List<Student> findAll() {
//        List<Student> list = Collections.addAll(students);
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size()-1).getId() + 1);
        students.add(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return null;
    }
}
