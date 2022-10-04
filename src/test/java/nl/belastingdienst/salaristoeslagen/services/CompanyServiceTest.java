package nl.belastingdienst.salaristoeslagen.services;

import nl.belastingdienst.salaristoeslagen.dto.CompanyDto;
import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    @Mock
    CompanyRepository companyRepository ;
    @InjectMocks
    CompanyService companyService;

    @Autowired
    MockMvc mockMvc;
    @Mock
    Company company;

    @BeforeEach
    public void setup(){
        company = new Company(1L,"Test",null);
    }
    @Test
    void getAllCompanys() {
    }

    @Test
    void getOneCompanyById() {
        // arrange
        CompanyDto expected = new CompanyDto(1L,"Test",null);
        // act
        Mockito
                .when(companyRepository.findById(company.getId()))
                .thenReturn(Optional.of(company));

        CompanyDto actual = companyService.getCompanyById(company.getId()) ;

        //assert
        assertEquals(expected,actual);
        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());

    }

    @Test
    void createCompany() {
    }

    @Test
    void fromCompany() {
    }

    @Test
    void toCompany() {
    }
}