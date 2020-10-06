package com.phyrextsai.boilerplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phyrextsai.boilerplate.adapter.parameter.EmployeeRequest;
import com.phyrextsai.boilerplate.parameter.Response;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootOrdsBoilerplateRESTfulTests {
  
  @Autowired
  private MockMvc mockMvc;

  private HttpHeaders httpHeaders;

  @Test
  public void testGetEmployeeByIdSuccess() throws Exception {
    httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    Response response = new Response();
    response.setError_code(null);
    response.setError_message(null);

    String id = "1234";

    mockMvc.perform(get("/employee/" + id)
      .headers(httpHeaders))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.error_code").value(response.getError_code()))
      .andExpect(jsonPath("$.error_message").value(response.getError_message()))
      .andExpect(jsonPath("$.status").value(true))
      .andExpect(jsonPath("$.result.empno").value(1234))
      .andExpect(jsonPath("$.result.ename").value("PT"));
  }

  @Test
  public void testGetEmployeeListSuccess() throws Exception {
    httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    Response response = new Response();
    response.setError_code(null);
    response.setError_message(null);

    mockMvc.perform(get("/employee/")
      .headers(httpHeaders))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.error_code").value(response.getError_code()))
      .andExpect(jsonPath("$.error_message").value(response.getError_message()))
      .andExpect(jsonPath("$.status").value(true))
      .andExpect(jsonPath("$.result.length()").value(15));
  }

  @Test
  public void testDeleteEmployeeSuccess() throws Exception {
    httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    Response response = new Response();
    response.setError_code(null);
    response.setError_message(null);

    String id = "5555";

    mockMvc.perform(delete("/employee/" + id)
      .headers(httpHeaders))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.error_code").value(response.getError_code()))
      .andExpect(jsonPath("$.error_message").value(response.getError_message()))
      .andExpect(jsonPath("$.status").value(true));
  }

  @Test
  public void testCreateEmployeeSuccess() throws Exception {
    httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    Response response = new Response();
    response.setError_code(null);
    response.setError_message(null);

    EmployeeRequest employeeRequest = new EmployeeRequest();
    employeeRequest.setId(5555);
    employeeRequest.setName("TOM");
    employeeRequest.setJob("ADMIN");
    employeeRequest.setManager(1234);
    employeeRequest.setHireDate("1990-01-01");
    employeeRequest.setSalary(3000);
    employeeRequest.setComm(100);
    employeeRequest.setDepartment(10);

    ObjectMapper mapper = new ObjectMapper();

    mockMvc.perform(post("/employee/")
      .headers(httpHeaders)
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(employeeRequest)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.error_code").value(response.getError_code()))
      .andExpect(jsonPath("$.error_message").value(response.getError_message()))
      .andExpect(jsonPath("$.status").value(true));
  }

  @Test
  public void testUpdateEmployeeSuccess() throws Exception {
    httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    Response response = new Response();
    response.setError_code(null);
    response.setError_message(null);

    EmployeeRequest employeeRequest = new EmployeeRequest();
    employeeRequest.setId(5555);
    employeeRequest.setName("TOM");
    employeeRequest.setJob("CLERK");
    employeeRequest.setManager(1234);
    employeeRequest.setHireDate("1991-01-01");
    employeeRequest.setSalary(4000);
    employeeRequest.setComm(200);
    employeeRequest.setDepartment(10);

    ObjectMapper mapper = new ObjectMapper();

    mockMvc.perform(put("/employee/")
      .headers(httpHeaders)
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(employeeRequest)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.error_code").value(response.getError_code()))
      .andExpect(jsonPath("$.error_message").value(response.getError_message()))
      .andExpect(jsonPath("$.status").value(true));
  }
  
}
