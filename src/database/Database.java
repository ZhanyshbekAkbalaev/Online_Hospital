package database;

import models.Department;
import models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Hospital> hospitals = new ArrayList<>();
    private final List<Department> departments = new ArrayList<>();

    public Database() {
    }

    public Database(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }


    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "Database{" +
                "hospitals=" + hospitals +
                '}';
    }


}
