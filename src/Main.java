import dao.DepartmentDao;
import dao.DoctorDao;
import dao.HospitalDao;
import dao.PatientDao;
import dao.impl.DepartmentDaoImpl;
import dao.impl.DoctorDaoImpl;
import dao.impl.HospitalDaoImpl;
import dao.impl.PatientDaoImpl;
import database.Database;
import enums.Gender;
import models.Department;
import models.Doctor;
import models.Hospital;
import models.Patient;
import service.DepartmentService;
import service.DoctorService;
import service.HospitalService;
import service.PatientService;
import service.impl.DepartmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleConsumer;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        HospitalDao hospitalDao = new HospitalDaoImpl(database);
        HospitalService hospitalService = new HospitalServiceImpl(hospitalDao);
        DepartmentDao dao = new DepartmentDaoImpl(database);
        DepartmentService departmentService = new DepartmentServiceImpl(dao);
        PatientDao patientDao = new PatientDaoImpl(database);
        PatientService patientService = new PatientServiceImpl(patientDao);
        DoctorDao doctorDao = new DoctorDaoImpl(database);
        DoctorService doctorService = new DoctorServiceImpl(doctorDao);
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Sadyr", "Japarov", 46, Gender.MALE));
        patients.add(new Patient(2L, "Kurmanbek", "Bakiev", 50, Gender.MALE));
        List<Long> longs = new ArrayList<>();
        longs.add(2L);
        while (true) {
            System.out.println("""
                    HOSPITAL METHODS
                    1-> add Hospital:
                    2-> find Hospital by Id:
                    3-> get all Hospital:
                    4-> get all Patient from Hospital:
                    5-> delete Hospital by Id:
                    6-> get all Hospital by Address:
                    ~~~~~~~~~~~~~~~~~~~
                    DEPARTMENT METHODS
                    7-> add Department To Hospital:
                    8-> get all Department by Hospital:
                    9-> find Department by Name:
                    10-> delete Department by Id:
                    11-> Update Department by Id:
                    ~~~~~~~~~~~~~~~~~~
                    DOCTOR METHODS
                    12-> Add Doctor to Hospital:
                    13-> find Doctor by Id:
                    14-> Update Doctor By Id:
                    15-> delete Doctor by Id:
                    16-> Assign Doctor to Department:
                    17-> get all Doctors by Hospital Id:
                    18-> get all Doctors by Department by Id:
                    ~~~~~~~~~~~~~~~~~~
                    PATIENT METHODD
                    19-> add Patient to Hospital:
                    20-> add Patients to Hospital:
                    21-> Update Patient by Id:
                    22-> Remove Patient by Id:
                    23-> Get Patient by Id:
                    24-> get Patient by Age:
                    25-> sort Patient by Age:
                    """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> System.out.println(hospitalService.addHospital(new Hospital(1L, "Hospital", "Vostok")));
                case 2 -> System.out.println(hospitalService.findHospitalById(1L));
                case 3 -> System.out.println(hospitalService.getAllHospital());
                case 4 -> System.out.println(hospitalService.getAllPatientFromHospital(1L));
                case 5 -> System.out.println(hospitalService.deleteHospitalById(1L));
                case 6 -> System.out.println(hospitalService.getAllHospitalByAddress("Vostok"));
                case 7 -> System.out.println(departmentService.addDepartmentToHospital(1L, new Department(2L, "GGG")));
                case 8 -> System.out.println(departmentService.getAllDepartmentByHospital(1L));
                case 9 -> System.out.println(departmentService.findDepartmentByName("GGG"));
                case 10 -> departmentService.deleteDepartmentById(2L);
                case 11 -> System.out.println(departmentService.updateDepartmentById(2L, new Department(3L, "VVV")));
                case 12 -> System.out.println(doctorService.addDoctorToHospital(1L, new Doctor(4L, "Erkinbek", "Koshaliev", 35, Gender.MALE)));
                case 13 -> System.out.println(doctorService.findDoctorById(4L));
                case 14 -> System.out.println(doctorService.updateDoctor(4L, new Doctor(5L, "Jeyson", "Stathen", 40)));
                case 15 -> doctorService.deleteDoctorById(5L);
                case 16 -> System.out.println(doctorService.assignDoctorToDepartment(3L, longs));
                case 17 -> System.out.println(doctorService.getAllDoctorsByHospitalId(1L));
                case 18 -> System.out.println(doctorService.getAllDoctorsByDepartmentId(5L));
                case 19 -> System.out.println(patientService.addPatientToHospital(1L, new Patient(7L, "F", "F", 18, Gender.MALE)));
                case 20 -> System.out.println(patientService.addPatientsToHospital(1L, patients));
                case 21 -> System.out.println(patientService.updatePatientById(7L, new Patient(8L, "Askar", "Akaev", 70, Gender.MALE)));
                case 22 -> patientService.removePatientById(7L);
                case 23 -> System.out.println(patientService.getPatientById(7L));
                case 24 -> System.out.println(patientService.getPatientByAge(46));
                case 25 -> System.out.println(patientService.sortPatientsByAge("asc"));
                default -> System.out.println(num + " No NUMBER !!!!!!!!!!!!!!!!!!!");
            }
        }
    }
}