package com.example.department.service;

import com.example.department.entity.MyDepartment;

import java.util.List;

public interface DepartmentService {

    MyDepartment saveDepartment(MyDepartment myDepartment);
    List<MyDepartment> fetchDepartmentList();
    MyDepartment updateDepartment(MyDepartment myDepartment, Long departmentId);
    void deleteDepartmentById(Long departmentId);
}
