package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println(ConstantMsg.NOT_FIND);
		} else {

			// レコードを出力
			System.out.println(ConstantMsg.SHOW_HEADER);
			for (Employee emp : employees) {
				System.out.println(emp.toString());
			}
		}
	}
}
