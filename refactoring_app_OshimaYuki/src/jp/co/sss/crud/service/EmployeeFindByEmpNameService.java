package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	@Override
	public void execute() throws IllegalInputException, SystemErrorException {
		
		IEmployeeDAO IEmployee = new EmployeeDAO();
		EmployeeNameReader inputName = new EmployeeNameReader();
		
		String empName = inputName.inputName();
		List<Employee> employees = IEmployee.findByEmployeeName(empName);
		
		ConsoleWriter.showEmployees(employees);
	}

}
