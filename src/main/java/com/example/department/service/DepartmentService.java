package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.model.DepartmentRequestBody;
import com.example.department.model.DepartmentResponseBody;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseBody saveDepartment(DepartmentRequestBody departmentRequest);


    List<Department> fetchDepartmentList();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
