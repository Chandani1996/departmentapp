package com.example.department.service;

import com.example.department.entity.MyDepartment;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public MyDepartment saveDepartment(MyDepartment myDepartment) {
        return departmentRepository.save(myDepartment);
    }

    @Override
    public List<MyDepartment> fetchDepartmentList() {
        return (List<MyDepartment>)
                departmentRepository.findAll();
    }

    @Override
    public MyDepartment updateDepartment(MyDepartment myDepartment, Long departmentId) {

        MyDepartment depDB= departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(myDepartment.getDepartmentName())&& ! " ".equalsIgnoreCase(myDepartment.getDepartmentName())){
            depDB.setDepartmentName(myDepartment.getDepartmentName());
        }
        if(Objects.nonNull(myDepartment.getDepartmentAddress())&& ! " ".equalsIgnoreCase(myDepartment.getDepartmentAddress())){
            depDB.setDepartmentAddress(myDepartment.getDepartmentAddress());
        }
        if(Objects.nonNull(myDepartment.getDepartmentCodes())&& ! " ".equalsIgnoreCase(myDepartment.getDepartmentCodes())){
            depDB.setDepartmentCodes(myDepartment.getDepartmentCodes());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
