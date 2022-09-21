package nl.belastingdienst.salaristoeslagen.Controller;
import nl.belastingdienst.salaristoeslagen.dto.ManagerDto;
import nl.belastingdienst.salaristoeslagen.models.Manager;
import nl.belastingdienst.salaristoeslagen.repositorie.ManagerRepository;
import nl.belastingdienst.salaristoeslagen.services.ManagerService;
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
@RequestMapping(value = "/manager")
public class ManagerController {

    ManagerService managerService;

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ManagerDto>> getAllManagers(){
        List<ManagerDto> managerDtos = managerService.getAllManagers();
        return ResponseEntity.ok(managerDtos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ManagerDto> getOneManager(@PathVariable Long id){
        ManagerDto managerDto = managerService.getManagerById(id);
        return ResponseEntity.ok(managerDto);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createManager(@Valid @RequestBody ManagerDto managerDto, BindingResult br){
        StringBuilder sb = new StringBuilder();
        if(br.hasErrors()){
            for(FieldError error : br.getFieldErrors()){
                sb.append(error.getField() + ": ");
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            ManagerDto newManagerDto = managerService.createManager(managerDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newManagerDto.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }



}