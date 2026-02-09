package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		
		if (employees.isEmpty()) {
			//該当者が居なかった場合
			System.out.println(ConstantMsg.NOT_FIND);
		} else {

			// レコードを出力
			System.out.println(ConstantMsg.SHOW_HEADER);
			for (Employee emp : employees) {
				System.out.println(emp.toString());
			}
		}
	}

	/**メニューの表示*/
	public static void showMenu() {
		// タイトル
		System.out.println(ConstantMsg.MENU_TAITOL);
		//1.全件検索
		System.out.println(ConstantMsg.MANU_FIND_ALL);
		//2.社員名検索
		System.out.println(ConstantMsg.MENU_FIND_BY_EMPNAME);
		//3.部署ID検索
		System.out.println(ConstantMsg.MENU_FIND_BY_DEPTID);
		//4.登録
		System.out.println(ConstantMsg.MENU_INSERT_EMP);
		//5.更新
		System.out.println(ConstantMsg.MENU_UPDATE_EMP);
		//6.削除
		System.out.println(ConstantMsg.MENU_DELETE_EMP);
		//7.終了
		System.out.println(ConstantMsg.MENU_SYSTEM_CLOSE);
		//メニュー番号の入力を促す
		System.out.print(ConstantMsg.MENU_NUMBER_QUESTION);
	}
}
