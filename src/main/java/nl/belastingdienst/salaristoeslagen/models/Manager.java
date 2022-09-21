package nl.belastingdienst.salaristoeslagen.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.belastingdienst.salaristoeslagen.Controller.CompanyController;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
