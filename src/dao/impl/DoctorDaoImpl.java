package dao.impl;

import dao.DoctorDao;
import database.Database;
import models.Department;
import models.Doctor;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoctorDaoImpl implements DoctorDao {
    private Database database;

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        for (Hospital hosp : database.getHospitals()) {
            if (hosp.getId() == id) {
                hosp.getDoctors().add(doctor);
                System.out.println(hosp.getDoctors() + "doctor added successfully ");

            }
        }

        return " successfully added ";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        Doctor doctor1 = new Doctor();
        for (Hospital hosp : database.getHospitals()) {
            for (Doctor doctor : hosp.getDoctors()) {
                if (doctor.getId()==id){
                   doctor1 = doctor;
                }else {
                    System.out.println("no such id");

                }
            }
        }
        return doctor1;
    }
    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        for (Hospital hosp : database.getHospitals()) {
            for (Doctor hospDoctor : hosp.getDoctors()) {
                if (hosp.getId() == id) {
                    hospDoctor.setFirstName(doctor.getFirstName());
                    hospDoctor.setLastName(doctor.getLastName());
                    hospDoctor.setExperienceYear(doctor.getExperienceYear());
                }else {
                    System.out.println("doctor not renamed");
                }
            }
        }
        return "Update doctor Successfully";
    }
    @Override
    public void deleteDoctorById(Long id) {
        for (Hospital hosp : database.getHospitals()) {
            for (Doctor doctor : hosp.getDoctors()) {
                if (doctor.getId() == id) {
                    hosp.getDoctors().remove(doctor);
                } else {
                    System.out.println("no id!");
                }
            }
        }
    }
    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital hosp : database.getHospitals()) {
            for (Department department : hosp.getDepartments()) {
                if (Objects.equals(department.getId(), departmentId)) {
                    for (Doctor doctor : hosp.getDoctors()) {
                        for (Long aLong : doctorsId) {
                            if (Objects.equals(doctor.getId(), aLong)) {
                                department.setDoctors(hosp.getDoctors());
                            } else {
                                return "No id:";
                            }
                        }
                    }
                }
            }
        }
        return "assign doctor to department Successfully!!!!!!!!!!!!!!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Doctor> doctors = new ArrayList<>();
        for (Hospital hospital : database.getHospitals()) {
            if (hospital.getId() == id) {
                doctors.addAll(hospital.getDoctors());
            }else {
                System.out.println("did not find a doctor");
            }
        }
        return doctors;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Doctor> doctors = new ArrayList<>();
        for (Hospital hospital : database.getHospitals()) {
            for (Department department : hospital.getDepartments()) {
                if (Objects.equals(department.getId(), id)){
                    doctors.addAll(department.getDoctors());
                }else {
                    System.out.println("did not add a doctor to the department");
                }
            }
        }
        return doctors;
    }
}
