package models;

public class Doctor {
    private Long id;
    private String lastName;
    private String firstName;
    private int experienceYear;
    private Gender gender;

    public Doctor() {
    }

    public Doctor(Long id, String lastName, String firstName, int experienceYear, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.experienceYear = experienceYear;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Doctor: " +
                "id ->" + id +
                " lastName -> " + lastName + '\'' +
                " firstName -> " + firstName + '\'' +
                " experienceYear -> " + experienceYear +
                " gender -> " + gender ;
    }
}
