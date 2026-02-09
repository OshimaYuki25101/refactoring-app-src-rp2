package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService {
	public static void findAll() throws IllegalInputException, SystemErrorException {
		List<Employee> employees = EmployeeDAO.findAll();
		ConsoleWriter.showEmployees(employees);
	}
}
