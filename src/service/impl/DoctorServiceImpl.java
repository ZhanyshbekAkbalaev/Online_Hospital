package service.impl;

import dao.DoctorDao;
import models.Doctor;

import java.util.List;

public class DoctorServiceImpl {
    private DoctorDao dao;
    String addDoctorToHospital(Long id, Doctor doctor){
        return dao.addDoctorToHospital(id, doctor);
    }

    Doctor findDoctorById(Long id){
        return dao.findDoctorById(id);
    }
    String updateDoctor(Long id, Doctor doctor){
        return dao.updateDoctor(id, doctor);
    }
    void deleteDoctorById(Long id){
        dao.deleteDoctorById(id);
    }
    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId){
        return dao.assignDoctorToDepartment(departmentId, doctorsId);
    }
    List<Doctor> getAllDoctorsByHospitalId(Long id){
        return dao.getAllDoctorsByHospitalId(id);
        }

    List<Doctor> getAllDoctorsByDepartmentId(Long id){
        return dao.getAllDoctorsByDepartmentId(id);
    }
}


