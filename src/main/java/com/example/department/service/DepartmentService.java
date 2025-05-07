package com.example.department.service;

import com.example.department.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department updateDepartment(Department department, Long departmentId);
    void deleteDepartmentById(Long departmentId);
}
