package com.example.department.controller;

import com.example.department.entity.Departments;
import com.example.department.model.DepartmentRequestBody;
import com.example.department.model.DepartmentResponseBody;
import com.example.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    @PostMapping("/departments")
    public DepartmentResponseBody saveDepartments(@Validated @RequestBody DepartmentRequestBody departmentRequest){
        return  departmentService.saveDepartment(departmentRequest);
    }

    @GetMapping("/departments")
    public List<Departments> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Departments updateDepartment(@RequestBody Departments departments, @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(departments,departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
