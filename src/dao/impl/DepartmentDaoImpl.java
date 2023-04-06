package dao.impl;

import dao.DepartmentDao;
import database.Database;
import models.Department;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private Database database;

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId().equals(id)) {
                hospital.getDepartments().add(department);

            } else {
                return "Not add";
            }
        }
        return "Successfully added to hospital";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Department> departments = new ArrayList<>();
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId().equals(id)) {
                departments.addAll(hospital.getDepartments());
            } else {
                System.out.println("Not get");
            }
        }
        return departments;
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department departments = new Department();
        for (Hospital hospital : database.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    departments = department;
                } else {
                    System.out.println("Not founded");
                }
            }
        }
        return departments;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        for (Hospital hospital : database.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (id.equals(department.getId())) {
                    hospital.getDepartments().remove(department);
                    System.out.println("Successfully delete ");
                } else {
                    System.out.println("Not delete");
                }
            }
        }

    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        for (Hospital hospital : database.getHospitals()) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (id.equals(department.getId())) {
                    department.setDepartmentName(department.getDepartmentName());

                } else {
                    return "not update";
                }
            }
        }
        return "successfully update ";
    }
}
