package dao.impl;

import dao.DepartmentDao;
import database.Database;
import models.Department;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private Database database;

    public DepartmentDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        try {
            for (Hospital hospital : database.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    hospital.getDepartments().add(department);
                    System.out.println(department.getDepartmentName());
                    return "Successfully added to hospital";
                } else {
                    return "Not add";
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Department> departments = new ArrayList<>();
        try {
            for (Hospital hospital : database.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    departments.addAll(hospital.getDepartments());
                } else {
                    System.out.println("Not get");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return departments;
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department departments = new Department();
        try {
            for (Hospital hospital : database.getHospitals()) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getDepartmentName().equals(name)) {
                        departments = department;
                    } else {
                        System.out.println("Not founded");
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return departments;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        try {
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
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        try {
            for (Hospital hospital : database.getHospitals()) {
                for (Department hospitalDepartment : hospital.getDepartments()) {
                    if (id.equals(hospitalDepartment.getId())) {
                        hospitalDepartment.setDepartmentName(department.getDepartmentName());
                    } else {
                        return "not update";
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "successfully update ";
    }
}
