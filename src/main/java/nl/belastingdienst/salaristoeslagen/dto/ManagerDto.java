package nl.belastingdienst.salaristoeslagen.dto;

import java.time.LocalDate;

public class ManagerDto {

    private Long id;

    private String firstName;

    private String lastName;
    private LocalDate birthday;

    private int companyId;
    private String city;

    private double commuteKm;

    private double salary;

    private String address;

    private double hoursAWeek;

    public ManagerDto() {
    }

    public ManagerDto(Long id, String firstName, String lastName, LocalDate birthday, int companyId, String city, double commuteKm, double salary, String address, double hoursAWeek) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.companyId = companyId;
        this.city = city;
        this.commuteKm = commuteKm;
        this.salary = salary;
        this.address = address;
        this.hoursAWeek = hoursAWeek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCommuteKm() {
        return commuteKm;
    }

    public void setCommuteKm(double commuteKm) {
        this.commuteKm = commuteKm;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHoursAWeek() {
        return hoursAWeek;
    }

    public void setHoursAWeek(double hoursAWeek) {
        this.hoursAWeek = hoursAWeek;
    }
}
