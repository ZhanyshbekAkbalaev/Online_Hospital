import dao.DoctorDao;
import dao.HospitalDao;
import database.Database;
import models.Department;
import models.Doctor;
import service.DepartmentService;
import service.HospitalService;
import service.PatientService;
import service.impl.DepartmentServiceImpl;
import service.impl.HospitalServiceImpl;
import service.impl.PatientServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalServiceImpl();
        DepartmentService departmentService = new DepartmentServiceImpl();
        PatientService patientService = new PatientServiceImpl();
        while (true){
            int num = new Scanner(System.in).nextInt();
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
            switch (num){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23:
                    break;
                case 24:
                    break;
                case 25:
                    break;
                default:
                    System.out.println( num+" No number!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
}