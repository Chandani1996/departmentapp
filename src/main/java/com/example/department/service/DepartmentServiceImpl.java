package com.example.department.service;

import com.example.department.entity.Department;
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
        Department request = new Department();
        request.setDepartmentId(departmentRequest.getDepartmentId());
        request.setDepartmentCodes(departmentRequest.getDepartmentCodes());
        request.setDepartmentName(departmentRequest.getDepartmentName());
        request.setDepartmentAddress(departmentRequest.getDepartmentAddress());

        Department department = departmentRepository.save(request);

        DepartmentResponseBody respose = new DepartmentResponseBody();
        respose.setDepartmentId(department.getDepartmentId());
        respose.setDepartmentCodes(department.getDepartmentCodes());
        respose.setDepartmentName(department.getDepartmentName());
        respose.setDepartmentAddress(department.getDepartmentAddress());

        return  respose;
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>)
                departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {

        Department depDB= departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName())&& ! " ".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&& ! " ".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCodes())&& ! " ".equalsIgnoreCase(department.getDepartmentCodes())){
            depDB.setDepartmentCodes(department.getDepartmentCodes());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
