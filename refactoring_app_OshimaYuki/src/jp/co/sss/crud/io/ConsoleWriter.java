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

	public static void showMenu() {
		// メニューの表示
		System.out.println(ConstantMsg.MENU_TAITOL);
		System.out.println(ConstantMsg.MANU_FIND_ALL);
		System.out.println(ConstantMsg.MENU_FIND_BY_EMPNAME);
		System.out.println(ConstantMsg.MENU_FIND_BY_DEPTID);
		System.out.println(ConstantMsg.MENU_INSERT_EMP);
		System.out.println(ConstantMsg.MENU_UPDATE_EMP);
		System.out.println(ConstantMsg.MENU_DELETE_EMP);
		System.out.println(ConstantMsg.MENU_SYSTEM_CLOSE);
		System.out.print(ConstantMsg.MENU_NUMBER_QUESTION);
	}
}
