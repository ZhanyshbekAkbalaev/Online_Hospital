package service.impl;

import dao.HospitalDao;
import dao.impl.HospitalDaoImpl;
import models.Hospital;
import models.Patient;
import service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    private HospitalDao dao;

    public HospitalServiceImpl(HospitalDao dao) {
        this.dao = dao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        return dao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return dao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return dao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return dao.deleteHospitalById(id);
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return dao.getAllHospitalByAddress(address);
    }
}
