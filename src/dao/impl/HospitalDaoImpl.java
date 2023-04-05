package dao.impl;

import dao.HospitalDao;
import database.Database;
import models.Hospital;
import models.Patient;

import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {
    private List<Database> data;

    @Override
    public String addHospital(Hospital hospital) {
        for (Database database : data) {
            database.getHospitals().add(hospital);
        }
        return "Succesfully add Hospital!";
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
