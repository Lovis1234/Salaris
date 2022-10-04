package nl.belastingdienst.salaristoeslagen.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.belastingdienst.salaristoeslagen.dto.CompanyDto;
import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;
import nl.belastingdienst.salaristoeslagen.services.CompanyService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureMockMvc

@ExtendWith(MockitoExtension.class)
class CompanyControllerTest {
    @Mock
    CompanyService companyService;

    @MockBean
    DataSource dataSource;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllCompanys() {
        // arrange
//        CompanyDto expected = new CompanyDto(1L,"Test",null);
//        Company company = new Company(1L,"Test",null);
//        // act
//        Mockito
//                .when(companyRepository.findById(company.getId()))
//                .thenReturn(Optional.of(company));
//
//        CompanyDto actual = companyController.getOneCompany(company.getId()) ;
//
//        //assert
//        assertEquals(expected,actual);
//        assertEquals(expected.getId(),actual.getId());
    }

    @Test
    void getOneCompany() {
        // arrange
//        CompanyDto expected = new CompanyDto(1L,"Test",null);
//        Company company = new Company(1L,"Test",null);
//        // act
//        Mockito
//                .when(companyRepository.findById(company.getId()))
//                .thenReturn(Optional.of(company));
//
//        CompanyDto actual = companyService.getCompanyById(company.getId()) ;
//
//        //assert
//        assertEquals(expected,actual);
//        assertEquals(expected.getId(),actual.getId());
//        assertEquals(expected.getName(),actual.getName());

    }

    @Test
    void createCompany() throws Exception {
        //arrange
        CompanyDto expected = new CompanyDto(1L,"Test",null);
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        //act
        Mockito
                .when(companyService.createCompany(expected))
                .thenReturn(expected);

        //assert
        mockMvc.perform(MockMvcRequestBuilders.post("/company")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(objectMapper.writeValueAsString(expected))))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}