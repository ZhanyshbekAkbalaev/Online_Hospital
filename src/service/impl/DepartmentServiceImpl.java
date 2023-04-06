package service.impl;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import models.Department;
import service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao dao;

    public DepartmentServiceImpl(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        return dao.addDepartmentToHospital(id,department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return dao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return dao.findDepartmentByName(name);
    }

    @Override
    public void deleteDepartmentById(Long id) {
       dao.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return dao.updateDepartmentById(id,department);
    }
}
