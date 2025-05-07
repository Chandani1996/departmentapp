package com.example.department.repository;

import com.example.department.entity.MyDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<MyDepartment,Long> {

}
