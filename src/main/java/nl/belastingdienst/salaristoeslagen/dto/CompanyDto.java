package nl.belastingdienst.salaristoeslagen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CompanyDto {


    private Long id;

    private String name;

}
