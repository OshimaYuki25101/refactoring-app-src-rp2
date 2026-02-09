package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService implements IEmployeeService {
	@Override
	public void execute() throws IllegalInputException, SystemErrorException {
		Employee emp = new Employee();
		Department dept = new Department();

		EmployeeNameReader inputName = new EmployeeNameReader();
		emp.setEmpName((String) inputName.inputName());

		EmployeeGenderReader inputGender = new EmployeeGenderReader();
		emp.setGender((int) inputGender.inputGender());

		EmployeeBirthdayReader inputBirthday = new EmployeeBirthdayReader();
		emp.setBirthday((String) inputBirthday.inputBirthday());

		EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
		dept.setDeptId((int) inputDeptId.inputDeptId());
		emp.setDepartment(dept);

		EmployeeDAO.insertEmployee(emp);

		System.out.println(ConstantMsg.INSERT_COMPLET);

	}
}
