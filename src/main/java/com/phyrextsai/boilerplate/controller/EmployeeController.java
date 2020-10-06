package com.phyrextsai.boilerplate.controller;

import io.swagger.annotations.*;

import javax.servlet.http.HttpServletRequest;

import com.phyrextsai.boilerplate.adapter.parameter.EmployeeRequest;
import com.phyrextsai.boilerplate.parameter.Response;
import com.phyrextsai.boilerplate.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Employee API",
  tags="Employee Controller",
  description = "Interact with Employee Service", 
  produces = "application/json")
public class EmployeeController {
  
  @Autowired
  private EmployeeService employeeService;

  /**
   * Get employee information by id
   * @param id employee id
   * @param request request
   * @return response
   */
  @ApiOperation(value = "Get employee list", produces = "application/json")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Id mismatch"),
    @ApiResponse(code = 401, message = "Unauthorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
    @ApiResponse(code = 500, message = "Internal server error")
  })
  @RequestMapping(value = "/", 
    produces = "application/json", 
    method = RequestMethod.GET)
  public ResponseEntity<Response> getEmployeeList(HttpServletRequest request) throws Exception {
    Response response = employeeService.getEmployeeList();
    return ResponseEntity.ok(response);
  }
  
  /**
   * Get employee information by id
   * @param id employee id
   * @param request request
   * @return response
   */
  @ApiOperation(value = "Get employee information by id", produces = "application/json")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Id mismatch"),
    @ApiResponse(code = 401, message = "Unauthorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
    @ApiResponse(code = 500, message = "Internal server error")
  })
  @RequestMapping(value = "/{id}", 
    produces = "application/json", 
    method = RequestMethod.GET)
  public ResponseEntity<Response> getEmployeeById(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
    Response response = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(response);
  }

  @ApiOperation(value = "Create employee", produces = "application/json")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Id mismatch"),
    @ApiResponse(code = 401, message = "Unauthorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
    @ApiResponse(code = 500, message = "Internal server error")
  })
  @RequestMapping(value = "/", 
    produces = "application/json", 
    method = RequestMethod.POST)
  public ResponseEntity<Response> createEmployee(@RequestBody EmployeeRequest employeeRequest, HttpServletRequest request) throws Exception {
    Response response = employeeService.createEmployee(employeeRequest);
    return ResponseEntity.ok(response);
  }

  @ApiOperation(value = "Update employee", produces = "application/json")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Id mismatch"),
    @ApiResponse(code = 401, message = "Unauthorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
    @ApiResponse(code = 500, message = "Internal server error")
  })
  @RequestMapping(value = "/", 
    produces = "application/json", 
    method = RequestMethod.PUT)
  public ResponseEntity<Response> updateEmployee(@RequestBody EmployeeRequest employeeRequest, HttpServletRequest request) throws Exception {
    Response response = employeeService.updateEmployee(employeeRequest);
    return ResponseEntity.ok(response);
  }

  /**
   * Delete employee information by id
   * @param id employee id
   * @param request request
   * @return response
   */
  @ApiOperation(value = "Delete employee by id", produces = "application/json")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Id mismatch"),
    @ApiResponse(code = 401, message = "Unauthorized to view the resource"),
    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
    @ApiResponse(code = 500, message = "Internal server error")
  })
  @RequestMapping(value = "/{id}", 
    produces = "application/json", 
    method = RequestMethod.DELETE)
  public ResponseEntity<Response> deleteEmployee(@PathVariable("id") String id, HttpServletRequest request) throws Exception {
    Response response = employeeService.deleteEmployee(id);
    return ResponseEntity.ok(response);
  }
}
