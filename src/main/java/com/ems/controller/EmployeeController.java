package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/add-employee")
	public String showEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("action", "add");
		return "employee-form";
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee, Model model){
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/update-employee/{id}")
	public String updateEmployee(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("action", "update");
		return "employee-form";
	}
	
	@GetMapping("/delete-employee/{id}")
	public String deleteEmployee(@PathVariable int id, Model model) {
		employeeService.deleteEmployeeById(id);
		model.addAttribute("message", "Employee Successfully Removed!");
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}
	
	
}
