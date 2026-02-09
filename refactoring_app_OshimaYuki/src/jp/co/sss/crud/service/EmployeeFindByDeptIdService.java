package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	@Override
	public void execute() throws IllegalInputException, SystemErrorException {
		IEmployeeDAO IEmployee = new EmployeeDAO();
		EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
		int deptId = inputDeptId.inputDeptId();
		List<Employee> employees = IEmployee.findByDeptId(deptId);
		ConsoleWriter.showEmployees(employees);
	}
}
