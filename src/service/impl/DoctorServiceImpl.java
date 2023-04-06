package service.impl;

import dao.DoctorDao;
import models.Doctor;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private DoctorDao dao;

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        return dao.addDoctorToHospital(id, doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return dao.findDoctorById(id);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return dao.updateDoctor(id, doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        dao.deleteDoctorById(id);

    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return dao.assignDoctorToDepartment(departmentId, doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return dao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return dao.getAllDoctorsByDepartmentId(id);
    }
}
