package nl.belastingdienst.salaristoeslagen.services;

import nl.belastingdienst.salaristoeslagen.dto.ManagerDto;
import nl.belastingdienst.salaristoeslagen.exception.RecordNotFoundException;
import nl.belastingdienst.salaristoeslagen.models.Manager;
import nl.belastingdienst.salaristoeslagen.repositorie.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<ManagerDto> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        List<ManagerDto> managerDtos = new ArrayList<>();
        for(Manager manager : managers){
            managerDtos.add(fromManager(manager));
        }
        return managerDtos;
    }
    public ManagerDto getManagerById(Long id) {
        Optional<Manager> ManagerOptional = managerRepository.findById(id);
        if (!ManagerOptional.isPresent()) {
            throw new RecordNotFoundException("Manager not found");
        } else {
            Manager manager = ManagerOptional.get();
            ManagerDto managerDto = fromManager(manager);
            return managerDto;
        }
    }
    public ManagerDto createManager(ManagerDto managerDto) {
        Manager manager = toManager(managerDto);
        Manager newManager = managerRepository.save(manager);
        ManagerDto dto = fromManager(newManager);
        return dto;

    }
    

    private ManagerDto fromManager(Manager manager){
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setBirthday(manager.getBirthday());
        managerDto.setCity(manager.getCity());
        managerDto.setAddress(manager.getAddress());
        managerDto.setCommuteKm(manager.getCommuteKm());
        managerDto.setCompanyId(manager.getCompanyId());
        managerDto.setHoursAWeek(manager.getHoursAWeek());
        managerDto.setSalary(manager.getSalary());
        return managerDto;
    }

    private Manager toManager(ManagerDto managerDto){
        Manager manager = new Manager();
        manager.setId(manager.getId());
        manager.setFirstName(managerDto.getFirstName());
        manager.setLastName(managerDto.getLastName());
        manager.setBirthday(managerDto.getBirthday());
        manager.setCity(managerDto.getCity());
        manager.setAddress(managerDto.getAddress());
        manager.setCommuteKm(managerDto.getCommuteKm());
        manager.setCompanyId(managerDto.getCompanyId());
        manager.setHoursAWeek(managerDto.getHoursAWeek());
        manager.setSalary(managerDto.getSalary());
        return manager;
    }
    }

