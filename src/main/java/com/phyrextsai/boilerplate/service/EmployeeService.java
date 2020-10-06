package com.phyrextsai.boilerplate.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.phyrextsai.boilerplate.adapter.converter.EntityConverter;
import com.phyrextsai.boilerplate.adapter.parameter.Employee;
import com.phyrextsai.boilerplate.adapter.parameter.EmployeeRequest;
import com.phyrextsai.boilerplate.adapter.webclient.ORDSWebClient;
import com.phyrextsai.boilerplate.parameter.Response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.ClientResponse;

@Service
@Validated
public class EmployeeService {

  public Response getEmployeeById(@Valid @Pattern(regexp = "[0-9]{4}", message = "Id is invalid") String id)
      throws Exception {
    Response response = new Response();
    Employee employee = ORDSWebClient.client().loadEmployeeById(Integer.parseInt(id));
    response.setResult(employee);

    return response;
  }

  public Response getEmployeeList() throws Exception {
    Response response = new Response();
    List<Employee> employeeList = ORDSWebClient.client().loadEmployeeList();
    response.setResult(employeeList);

    return response;
  }

  public Response createEmployee(EmployeeRequest employeeRequest) throws Exception {
    Response response = new Response();
    ClientResponse clientResponse = ORDSWebClient.client()
        .createEmployee(EntityConverter.fromEmployeeRequest(employeeRequest));
    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
      response.setError_code(null);
      response.setError_message(null);
      response.setResult(null);
    }

    return response;
  }

  public Response updateEmployee(EmployeeRequest employeeRequest) throws Exception {
    Response response = new Response();
    ClientResponse clientResponse = ORDSWebClient.client()
        .updateEmployee(EntityConverter.fromEmployeeRequest(employeeRequest));
    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
      response.setError_code(null);
      response.setError_message(null);
      response.setResult(null);
    }
    
    return response;
  }

  public Response deleteEmployee(@Valid @Pattern(regexp = "[0-9]{4}", message = "Id is invalid") String id) throws Exception {
    Response response = new Response();
    ClientResponse clientResponse = ORDSWebClient.client()
        .deleteEmployee(Integer.parseInt(id));
    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
      response.setError_code(null);
      response.setError_message(null);
      response.setResult(null);
    }
    
    return response;
  }

}
