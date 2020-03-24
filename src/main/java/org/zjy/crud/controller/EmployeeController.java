package org.zjy.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zjy.crud.dao.DepartmentDao;
import org.zjy.crud.dao.EmployeeDao;
import org.zjy.crud.entities.Department;
import org.zjy.crud.entities.Employee;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("emps",all);
        return "emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String,Object> map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments",departments);
        return "emps/add";
    }

    @PostMapping("/emp")
    public String AddEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = employeeDao.get(id);
        map.put("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments",departments);
        return "emps/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:emps";
    }

    @DeleteMapping("/emp/{id}")
    public String DeleteEmp(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
