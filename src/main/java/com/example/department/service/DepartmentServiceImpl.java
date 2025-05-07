package com.example.department.service;

import com.example.department.entity.Departments;
import com.example.department.model.DepartmentRequestBody;
import com.example.department.model.DepartmentResponseBody;
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
    public DepartmentResponseBody saveDepartment(DepartmentRequestBody departmentRequest) {
        Departments request = new Departments();
        request.setDepartmentId(departmentRequest.getDepartmentId());
        request.setDepartmentCodes(departmentRequest.getDepartmentCodes());
        request.setDepartmentName(departmentRequest.getDepartmentName());
        request.setDepartmentAddress(departmentRequest.getDepartmentAddress());

        Departments departments = departmentRepository.save(request);

        DepartmentResponseBody respose = new DepartmentResponseBody();
        respose.setDepartmentId(departments.getDepartmentId());
        respose.setDepartmentCodes(departments.getDepartmentCodes());
        respose.setDepartmentName(departments.getDepartmentName());
        respose.setDepartmentAddress(departments.getDepartmentAddress());

        return  respose;
    }

    @Override
    public List<Departments> fetchDepartmentList() {
        return (List<Departments>)
                departmentRepository.findAll();
    }

    @Override
    public Departments updateDepartment(Departments departments, Long departmentId) {

        Departments depDB= departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(departments.getDepartmentName())&& ! " ".equalsIgnoreCase(departments.getDepartmentName())){
            depDB.setDepartmentName(departments.getDepartmentName());
        }
        if(Objects.nonNull(departments.getDepartmentAddress())&& ! " ".equalsIgnoreCase(departments.getDepartmentAddress())){
            depDB.setDepartmentAddress(departments.getDepartmentAddress());
        }
        if(Objects.nonNull(departments.getDepartmentCodes())&& ! " ".equalsIgnoreCase(departments.getDepartmentCodes())){
            depDB.setDepartmentCodes(departments.getDepartmentCodes());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
