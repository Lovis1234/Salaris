package nl.belastingdienst.salaristoeslagen.Controller;
import nl.belastingdienst.salaristoeslagen.dto.CompanyDto;
import nl.belastingdienst.salaristoeslagen.models.Company;
import nl.belastingdienst.salaristoeslagen.repositorie.CompanyRepository;
import nl.belastingdienst.salaristoeslagen.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<CompanyDto>> getAllCompanys(){
        List<CompanyDto> companyDtos = companyService.getAllCompanys();
        return ResponseEntity.ok(companyDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CompanyDto> getOneCompany(@PathVariable Long id){
        CompanyDto companyDto = companyService.getCompanyById(id);
        return ResponseEntity.ok(companyDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyDto companyDto, BindingResult br){
        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            CompanyDto newCompanyDto = companyService.createCompany(companyDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newCompanyDto.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }



}