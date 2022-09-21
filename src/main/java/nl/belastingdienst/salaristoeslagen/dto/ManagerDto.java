package nl.belastingdienst.salaristoeslagen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
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
}
