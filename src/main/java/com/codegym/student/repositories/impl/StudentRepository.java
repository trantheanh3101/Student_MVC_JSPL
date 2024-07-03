package com.codegym.student.repositories.impl;

import com.codegym.student.dto.StudentDTO;
import com.codegym.student.models.Student;
import com.codegym.student.repositories.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> students;
//    static {
//        students = new ArrayList<>();
//        students.add(new Student(1L,"haiTT", "QN", 10.0f));
//        students.add(new Student(2L,"Bảo Ngọc", "HN", 8.0f));
//        students.add(new Student(3L,"Bảo Kỳ", "DN", 6.0f));
//        students.add(new Student(5L,"Cook", "Bàn ăn", 2f));
//    }

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select id, students.name, address, point, c.name AS name_class from students join student.classroom c on c.id_class = students.id_class");
            ResultSet resultSet = preparedStatement.executeQuery();
            Long id;
            String name;
            String address;
            Float point;
            String namClass;
            while (resultSet.next()){
                id = resultSet.getLong("id");
                name = resultSet.getString("name");
                address = resultSet.getString("address");
                point = resultSet.getFloat("point");
                namClass = resultSet.getString("name_class");
                students.add(new StudentDTO(id,name,address,point,namClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("insert into students(name,address,point,id_class) value (?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setFloat(3, student.getPoint());
            preparedStatement.setLong(4,student.getIdClass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        boolean isDelete;
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("delete from students where id=?;");
            statement.setLong(1,id);
            isDelete = statement.executeUpdate() > 0; //Thực thi câu lệnh SQL. Phương thức này trả về số hàng bị ảnh hưởng bởi câu lệnh SQL.
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    @Override
    public List<StudentDTO> findByName(String name) {
        List<StudentDTO> result = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepository.getConnection().prepareStatement("select id, students.name, address, point, c.name AS name_class from students join student.classroom c on c.id_class = students.id_class WHERE students.name LIKE CONCAT('%',?,'%')");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nameS = resultSet.getString("name");
                String address = resultSet.getString("address");
                float point = resultSet.getFloat("point");
                String nameClass = resultSet.getString("name_class");
                result.add(new StudentDTO(id,nameS,address,point,nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public StudentDTO findById(long id) {
        StudentDTO student = null;
        try {
            PreparedStatement statement = BaseRepository.getConnection().
                    prepareStatement("select id, students.name, address, point, c.name AS name_class from students join student.classroom c on c.id_class = students.id_class WHERE id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Float point = resultSet.getFloat("point");
                String nameClass = resultSet.getString("name_class");
                student = new StudentDTO(id, name, address, point,nameClass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void update(long idEdit, StudentDTO studentEdit) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("UPDATE students SET name=?, address=?, point=?, id_class=? WHERE id=?");
            preparedStatement.setString(1,studentEdit.getName());
            preparedStatement.setString(2, studentEdit.getAddress());
            preparedStatement.setFloat(3,studentEdit.getPoint());
            preparedStatement.setLong(4,studentEdit.getIdClass());
            preparedStatement.setLong(5,idEdit);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
