/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.BP.services;

import com.mii.BP.entities.Employee;
import com.mii.BP.entities.EmployeeLogin;
import com.mii.BP.entities.LoginData;
import com.mii.BP.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Tutus W
 */
@Service
public class LoginRest {

    @Value("${data.api.url}")    
    private String url;
//    private String uri ="http://localhost:8084/secureapi/dept";
    
    @Autowired
    EmployeeRepository emp;
    
//    @Value("${data.api.key}")
    private String key = "Bootcamp eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBc3NldCBNYW5hZ2VtZW50IiwiaWF0IjoxNTcxMjEwMzQ0fQ.egQGVL6fHVvPnann4tvJlDR-4N7Pg8J-KC9hhbqa0w90ulWKya2sQUpIVQyqghy4iwBAmQu1fkVopr3eFPk34A";
    private static final RestTemplate restTemplate = new RestTemplate();
    
    private HttpHeaders getHeaders(){
        return new HttpHeaders(){
            {
                set("Authorization", key);
                setContentType(MediaType.APPLICATION_JSON);
            }
        };
    }
    
    public EmployeeLogin login(LoginData loginData){
        HttpEntity<LoginData> request = new HttpEntity(loginData, getHeaders());
        System.out.println(request.getBody().getEmail()+ " - " +request.getBody().getPassword());
        
        ResponseEntity<EmployeeLogin> responseEntity = restTemplate.exchange(
        url+"/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<EmployeeLogin>(){}
        );
        EmployeeLogin result = responseEntity.getBody();
        return result;
    }
    
    public Employee save(Employee e){
        return emp.save(e);
    }
}
