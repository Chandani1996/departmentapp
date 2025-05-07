package com.example.department.service;

import com.example.department.entity.Departments;
import com.example.department.model.DepartmentRequestBody;
import com.example.department.model.DepartmentResponseBody;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseBody saveDepartment(DepartmentRequestBody departmentRequest);

    List<Departments> fetchDepartmentList();

    Departments updateDepartment(Departments departments, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
