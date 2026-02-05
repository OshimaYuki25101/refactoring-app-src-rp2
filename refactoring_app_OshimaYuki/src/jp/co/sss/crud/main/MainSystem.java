package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = ConstantValue.MENU_START;

		do {
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

			// メニュー番号の入力
			String inputMenuNo = br.readLine();
			menuNo = Integer.parseInt(inputMenuNo);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				DBController.findAll();
				break;

			case ConstantValue.MENU_FIND_BY_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.EMPLOYEE_NAME);

				// 検索機能の呼出
				DBController.findByName();
				break;

			case ConstantValue.MENU_FIND_BY_DEPTID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.DEPT_TYPE+"を入力してください:");
				String deptId = br.readLine();

				// 検索機能の呼出
				DBController.findByDeptId(deptId);
				break;

			case ConstantValue.MENU_INSERT_EMPLOYEE:
				// 登録する値を入力
				System.out.print(ConstantMsg.EMPLOYEE_NAME);
				String empName = br.readLine();
				System.out.print(ConstantMsg.GENDER_TYPE+":");
				String gender = br.readLine();
				System.out.print(ConstantMsg.BIRTHDAY+":");
				String birthday = br.readLine();
				System.out.print(ConstantMsg.DEPT_TYPE+":");
				String inputDeptId = br.readLine();

				// 登録機能の呼出
				DBController.insertEmployee(empName, gender, birthday, inputDeptId);
				break;

			case ConstantValue.MENU_UPDATE_EMPLOYEE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.UPDATE_EMP_ID);

				// 更新する値を入力する
				String empId = br.readLine();
				Integer.parseInt(empId);

				// 更新機能の呼出
				DBController.updateEmployee(empId);
				System.out.println(ConstantMsg.UPDATE_COMPLETE);

				break;

			case ConstantValue.MENU_DELETE_EMPLOYEE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_EMP_ID);

				// 削除機能の呼出
				DBController.deleteEmployee();
				break;

			}
		} while (menuNo != ConstantValue.MENU_SYSTEM_END);
		System.out.println(ConstantMsg.SYSTEM_END);
	}
}
