package nl.belastingdienst.salaristoeslagen.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import nl.belastingdienst.salaristoeslagen.Controller.CompanyController;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private int companyId;
    private String city;

    private double commuteKm;

    private double salary;

    private String address;

    private double hoursAWeek;

    public Manager() {
    }

    public Manager(Long id, String firstName, String lastName, LocalDate birthday, String address, String city, double commuteKm, double salary, double hoursAWeek, int companyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.commuteKm = commuteKm;
        this.salary = salary;
        this.hoursAWeek = hoursAWeek;
        this.companyId = companyId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adres) {
        this.address = adres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String woonplaats) {
        this.city = woonplaats;
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

    public double getHoursAWeek() {
        return hoursAWeek;
    }

    public void setHoursAWeek(double hoursAWeek) {
        this.hoursAWeek = hoursAWeek;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", woonplaats='" + city + '\'' +
                ", commuteKm=" + commuteKm +
                ", salary=" + salary +
                ", adres='" + address + '\'' +
                ", hoursAWeek=" + hoursAWeek +
                '}';
    }
}
