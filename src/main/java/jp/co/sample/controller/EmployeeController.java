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
	 * @return 従業員一覧画面のビュー
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
	 * @return 従業員詳細画面のビュー
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);

		return "employee/detail.html";
	}

	/**
	 * 従業員の情報を更新する.
	 * 
	 * @param form 従業員情報のフォーム
	 * @return 従業員一覧画面のビュー
	 */
	@RequestMapping("/update")
	public String update(UpdateEmployeeForm form) {

		Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

		employeeService.update(employee);
		return "redirect:/employee/showList";
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
