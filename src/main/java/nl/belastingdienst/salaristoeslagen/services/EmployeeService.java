package nl.belastingdienst.salaristoeslagen.services;

import nl.belastingdienst.salaristoeslagen.dto.EmployeeDto;
import nl.belastingdienst.salaristoeslagen.exception.RecordNotFoundException;
import nl.belastingdienst.salaristoeslagen.models.Employee;
import nl.belastingdienst.salaristoeslagen.repositorie.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for(Employee employee : employees){
            employeeDtos.add(fromEmployee(employee));
        }
        return employeeDtos;
    }
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> EmployeeOptional = employeeRepository.findById(id);
        if (!EmployeeOptional.isPresent()) {
            throw new RecordNotFoundException("Employee not found");
        } else {
            Employee employee = EmployeeOptional.get();
            EmployeeDto employeeDto = fromEmployee(employee);
            return employeeDto;
        }
    }
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = toEmployee(employeeDto);
        Employee newEmployee = employeeRepository.save(employee);
        EmployeeDto dto = fromEmployee(newEmployee);
        return dto;

    }
    

    private EmployeeDto fromEmployee(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setCity(employee.getCity());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setCommuteKm(employee.getCommuteKm());
        employeeDto.setCompanyId(employee.getCompanyId());
        employeeDto.setHoursAWeek(employee.getHoursAWeek());
        employeeDto.setSalary(employee.getSalary());
        return employeeDto;
    }

    private Employee toEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employee.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setCity(employeeDto.getCity());
        employee.setAddress(employeeDto.getAddress());
        employee.setCommuteKm(employeeDto.getCommuteKm());
        employee.setCompanyId(employeeDto.getCompanyId());
        employee.setHoursAWeek(employeeDto.getHoursAWeek());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }
    }

