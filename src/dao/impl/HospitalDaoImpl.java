package dao.impl;

import dao.HospitalDao;
import database.Database;
import models.Hospital;
import models.Patient;

import java.util.*;

public class HospitalDaoImpl implements HospitalDao {
    private Database data;

    @Override
    public String addHospital(Hospital hospital) {
        return "Succesfully add Hospital!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        Hospital hospital1 = new Hospital();
        for (Hospital hospital : data.getHospitals()) {
            if (Objects.equals(hospital.getId(), id)) {
                hospital1 = hospital;
            } else {
                System.out.println(hospital + "No!!!!!!!!!!!!!!!!!!");
            }
        }
        return hospital1;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return data.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Patient> patients = new ArrayList<>();
        for (Hospital hospital : data.getHospitals()) {
            if (Objects.equals(hospital.getId(), id)) {
                patients.addAll(hospital.getPatients());
            } else {
                System.out.println("No! PATIENTS");
            }
        }
        return patients;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital : data.getHospitals()) {
            if (Objects.equals(hospital.getId(), id)) {
                data.getHospitals().remove(hospital);
            } else {
                return "No delete NO id!" + id;
            }
        }
        return "Successfully remove hospita id" + id;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> getAll = new HashMap<>();
        for (Hospital hospital : data.getHospitals()) {
            if (hospital.getAddress().equals(address)) {
                getAll.put(address, hospital);
            } else {
                System.out.println(address + "NO!! Address");
            }
        }
        return getAll;
    }
}
