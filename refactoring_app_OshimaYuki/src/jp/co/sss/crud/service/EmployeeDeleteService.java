package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws IllegalInputException, SystemErrorException {

		IEmployeeDAO IEmployee = new EmployeeDAO();
		EmployeeEmpIdReader inputEmpId = new EmployeeEmpIdReader();

		int empId = (int) inputEmpId.inputEmpId();

		int deleteComplate = IEmployee.delete(empId);
		if (deleteComplate == 0) {
			System.out.println(ConstantMsg.NOT_FIND);
		} else {
			System.out.println(ConstantMsg.DELETE_EMPLOYEE);
		}
	}
}
