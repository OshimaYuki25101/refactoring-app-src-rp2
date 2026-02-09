package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {
	public static void findByEmpName() throws IllegalInputException, SystemErrorException {
		String empName = "";
		boolean isError = false;
		do {
			try {
				System.out.print(ConstantMsg.EMPLOYEE_NAME + ":");
				EmployeeNameReader inputName = new EmployeeNameReader();
				empName = (String) inputName.input();
			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				isError = true;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (isError);
		List<Employee> employees = EmployeeDAO.findByName(empName);
		ConsoleWriter.showEmployees(employees);
	}
}
