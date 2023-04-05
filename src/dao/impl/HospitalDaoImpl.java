package dao.impl;

import dao.HospitalDao;
import database.Database;
import models.Hospital;

import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    private List<Database> db;

    @Override
    public String addHospital(Hospital hospital) {
        for (Database database : db) {
            database.getHospitals().add(hospital);
        }
        return "Successfully add Hospital!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return null;
    }
}
