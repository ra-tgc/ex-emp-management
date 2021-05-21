package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

//	デバッグ用
//	@RequestMapping("/test-emp")
//	public String testEmp() {
//
//		employeeService.testRepository();
//
//		return "finished";
//	}
}
