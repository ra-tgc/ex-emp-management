package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author masaki.taguchi
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 従業員情報を全件取得する.
	 * 
	 * @return 従業員情報全件
	 */
	public List<Employee> showList() {
		return employeeRepository.findAll();
	}

	/**
	 * 従業員情報を1件取得する.
	 * 
	 * @param id 主キー
	 * @return 従業員情報1件
	 */
	public Employee showDetail(Integer id) {
		return employeeRepository.load(id);
	}

	public void update(Employee employee) {
		employeeRepository.update(employee);
	}

//	デバッグ用
//	public void testRepository() {
//		employeeRepository.findAll().forEach(System.out::println);
//
//		System.out.println();
//
//		Employee emp = employeeRepository.load(1);
//		System.out.println(emp);
//	}
}
