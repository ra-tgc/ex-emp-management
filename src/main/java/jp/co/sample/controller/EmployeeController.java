package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員関連機能の制御を行うコントローラ.
 * 
 * @author masaki.taguchi
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * UpdateEmployeeFormをインスタンス化する.
	 * 
	 * @return インスタンス化されたUpdateEmployeeForm
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧を出力する.
	 * 
	 * @param model requestスコープ
	 * @return employee/list.htmlのビュー
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = employeeService.showList();
		model.addAttribute("employeeList", employeeList);

		return "employee/list";
	}

	/**
	 * 従業員の詳細情報を出力する.
	 * 
	 * @param id    主キー(リクエストパラメータで送られてくる)
	 * @param model requestスコープ
	 * @return employee/detail.htmlのビュー
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);

		return "employee/detail.html";
	}

//	デバッグ用
//	@RequestMapping("/test-emp")
//	public String testEmp() {
//
//		employeeService.testRepository();
//
//		return "finished";
//	}
}
