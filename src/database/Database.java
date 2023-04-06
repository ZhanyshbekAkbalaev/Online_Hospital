package database;

import models.Hospital;
import models.Patient;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Hospital> hospitals = new ArrayList<>();

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
