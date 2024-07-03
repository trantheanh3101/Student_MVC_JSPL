package com.codegym.student.dto;

public class StudentDTO {
    private Long id;
    private String name;
    private String address;
    private Float point;
    private String nameClass;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String address, Float point, String nameClass) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.nameClass = nameClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
