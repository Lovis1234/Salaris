package nl.belastingdienst.salaristoeslagen.Controller;
import nl.belastingdienst.salaristoeslagen.dto.EmployeeDto;
import nl.belastingdienst.salaristoeslagen.models.Employee;
import nl.belastingdienst.salaristoeslagen.repositorie.EmployeeRepository;
import nl.belastingdienst.salaristoeslagen.services.EmployeeService;
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
@RequestMapping(value = "/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> getOneEmployee(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult br){
        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            EmployeeDto newEmployeeDto = employeeService.createEmployee(employeeDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newEmployeeDto.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }



}