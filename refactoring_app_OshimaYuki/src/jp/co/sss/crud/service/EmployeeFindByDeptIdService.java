package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService {
public static void findByDeptId() throws ClassNotFoundException, SQLException, IOException, ParseException {
	System.out.print(ConstantMsg.DEPT_TYPE+"を入力してください:");
	EmployeeDeptIdReader inputDeptId = new EmployeeDeptIdReader();
	int deptId = (int) inputDeptId.input();
	List<Employee> employees = EmployeeDAO.findByDeptId(deptId);
	ConsoleWriter.showEmployees(employees);
}
}
