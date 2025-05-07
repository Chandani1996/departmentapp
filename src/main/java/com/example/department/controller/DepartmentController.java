package com.example.department.controller;

import com.example.department.entity.MyDepartment;
import com.example.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    @PostMapping("/departments")
    public MyDepartment saveDepartment(@Validated @RequestBody MyDepartment myDepartment){
        return  departmentService.saveDepartment(myDepartment);
    }

    @GetMapping("/departments")
    public List<MyDepartment> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public MyDepartment updateDepartment(@RequestBody MyDepartment myDepartment,@PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(myDepartment,departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}
