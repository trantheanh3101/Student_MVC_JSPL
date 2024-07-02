package com.codegym.student.controllers;

import com.codegym.student.models.Student;
import com.codegym.student.services.IStudentService;
import com.codegym.student.services.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentControllers extends HttpServlet {

    private static IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/student/create.jsp").forward(req, resp);
            case "edit":
                long id = Long.parseLong(req.getParameter("id"));
                Student student = studentService.findById(id);
                req.setAttribute("student", student);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/student/edit.jsp");
                try {
                    dispatcher.forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            default:
                List<Student> students = studentService.findAll();
                req.setAttribute("students", students);  // Điều này cho phép trang JSP truy cập vào danh sách sinh viên này thông qua đối tượng request.
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp); //  chuyển hướng yêu cầu từ servlet đến trang JSP
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Float points = Float.parseFloat(req.getParameter("point"));
                Student student = new Student(name, address, points);
                studentService.save(student);
                resp.sendRedirect("/student");
                break;
            case "delete":
                Long id = Long.parseLong(req.getParameter("id"));
                Boolean isDelete = studentService.deleteById(id);
                if (isDelete) {
                    resp.sendRedirect("/student");
                } else {
                    req.setAttribute("message", "Xoa ko thanh cong");
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                }
                break;
            case "search":
                String search = req.getParameter("search");
                List<Student> studentSearch = studentService.findByName(search);
                req.setAttribute("students", studentSearch);
                req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
                break;
            case "edit":
                long idEdit = Long.parseLong(req.getParameter("id"));
                String nameEdit = req.getParameter("name");
                String addressEdit = req.getParameter("address");
                Float point = Float.parseFloat(req.getParameter("point"));
                Student studentEdit = studentService.findById(idEdit);
                if (studentEdit != null) {
                    studentEdit.setName(nameEdit);
                    studentEdit.setAddress(addressEdit);
                    studentEdit.setPoint(point);
                    studentService.update(idEdit, studentEdit);
                    req.setAttribute("student", studentEdit);
                    req.setAttribute("message", "Cập nhật thành công");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("student/edit.jsp");
                    try {
                        dispatcher.forward(req, resp);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    req.setAttribute("message", "Sinh viên không tồn tại");
                }
        }
    }
}
