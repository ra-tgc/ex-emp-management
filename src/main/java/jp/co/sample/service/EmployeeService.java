package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public void testRepository() {
		employeeRepository.findAll().forEach(System.out::println);

		System.out.println();

		Employee emp = employeeRepository.load(1);
		System.out.println(emp);
	}
}
