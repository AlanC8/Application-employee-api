package kz.dar.microservice.microservices.controller;

import jakarta.validation.Valid;
import kz.dar.microservice.microservices.model.EmployeeModel;
import kz.dar.microservice.microservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        employeeService.createEmployee(employeeModel);
        return new ResponseEntity<String>("Successfully created", HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<EmployeeModel> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{employeeId}")
    public EmployeeModel getEmployeeById(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @PutMapping("/{employeeId}")
     public ResponseEntity<String> updateEmployeeById(@PathVariable String employeeId,@Valid @RequestBody EmployeeModel employeeModel){
        employeeService.updateEmployeeById(employeeId, employeeModel);
        return new ResponseEntity<String>("Succesfully Updated", HttpStatus.OK);
     }
     @DeleteMapping
     public ResponseEntity<String> deleteEmployeeById(@PathVariable String employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Succesfully", HttpStatus.OK);
     }

}
