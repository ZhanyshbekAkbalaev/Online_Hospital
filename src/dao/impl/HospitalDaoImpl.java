package dao.impl;

import dao.HospitalDao;
import database.Database;
import models.Hospital;
import models.Patient;

import java.util.*;

public class HospitalDaoImpl implements HospitalDao {
    private Database data;

    public HospitalDaoImpl(Database data) {
        this.data = data;
    }

    @Override
    public String addHospital(Hospital hospital) {
        data.getHospitals().add(hospital);
        return "Successfully add Hospital!";
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
        try {
            for (Hospital hospital : data.getHospitals()) {
                if (hospital.getId().equals(id)) {
                    data.getHospitals().remove(hospital);
                } else {
                    return "No delete NO id!" + id;
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "Successfully remove hospita id" + id;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> getAll = new TreeMap<>();
        try {
            for (Hospital hospital : data.getHospitals()) {
                if (hospital.getAddress().equals(address)) {
                    assert false;
                    getAll.put(address, hospital);
                } else {
                    System.out.println(address + "NO!! Address");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return getAll;
    }

}
