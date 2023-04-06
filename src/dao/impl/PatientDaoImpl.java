package dao.impl;

import dao.PatientDao;
import database.Database;
import models.Hospital;
import models.Patient;

import java.util.*;
import java.util.stream.Collectors;


public class PatientDaoImpl implements PatientDao {
    Database database;


    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId() == id){
                hospital.getPatients().add(patient);
            } else {
                return "Not added";
            }
        }
        return "Patient s successful saved!";

    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId() == id) {
                hospital.setPatients(patients);
            } else {
                System.out.println("Not added");
            }
        }
        return "Added to hospital";
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    patient.setFirstName(patientsNewInfo.getFirstName());
                    patient.setLastName(patientsNewInfo.getLastName());
                    patient.setAge(patientsNewInfo.getAge());
                    patient.setGender(patientsNewInfo.getGender());
                } else {
                    System.out.println("Not update");
                }
            }
        }
        return "Update";

    }

    @Override
    public void removePatientById(Long id) {
        for (Hospital hos :database.getHospitals()) {
            for (Patient patient : hos.getPatients()) {
                if (patient.getId() == id) {
                    hos.getPatients().remove(patient);
                }
            }
            database.getHospitals().remove(hos);
            System.out.println("removed");


        }
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId() == id) {
                    return patient;
                } else {
                    System.out.println("Not get");
                }
            }

        }
        return null;

    }

    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> getPatient = new HashMap<>();
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getAge() == age) {
                    getPatient.put(age, patient);
                } else {
                    System.out.println("Not get");
                }
            }
        }
        return getPatient;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        for (Hospital hospital : database.getHospitals()) {
            for (Patient patient : hospital.getPatients()) {
                if (ascOrDesc.equalsIgnoreCase("asc")) {
                    List<Patient> sortedListAsc = hospital.getPatients().stream()
                            .sorted()
                            .collect(Collectors.toList());

                    return sortedListAsc;
                } else if (ascOrDesc.equalsIgnoreCase("desc"))

                    return hospital.getPatients().stream().sorted(Comparator.comparing(Patient::getAge).
                               reversed()).toList();

            }

        }
        return null;
    }

}
