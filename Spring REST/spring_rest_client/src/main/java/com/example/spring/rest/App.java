package com.example.spring.rest;

import com.example.spring.rest.configuration.MyConfig;
import com.example.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> allEmployees = communication.getAllEmployees();

//        Employee empByID = communication.getEmployee(1);
//        System.out.println(empByID);

//        Employee emp = new Employee("Igor", "Karpov", "IT", 1000);
//        emp.setId(12);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(13);
    }

}
