package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService {
	public static void findByDeptId() throws IllegalInputException, SystemErrorException {
		int deptId = 0;
		boolean isError = false;
		do {
			try {
				System.out.print(ConstantMsg.DEPT_TYPE + "を入力してください:");
				EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
				deptId = (int) inputDeptId.input();
			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				isError = true;
			}catch(SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (isError);
		List<Employee> employees = EmployeeDAO.findByDeptId(deptId);
		ConsoleWriter.showEmployees(employees);
	}
}
