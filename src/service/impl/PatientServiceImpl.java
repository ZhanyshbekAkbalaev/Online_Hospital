package service.impl;

import dao.PatientDao;
import models.Patient;
import service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        return patientDao.addPatientToHospital(id,patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id,  patients);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return patientDao.updatePatientById(id,patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        return patientDao.getPatientByAge(age);
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
