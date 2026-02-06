package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
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

			ConsoleWriter.showMenu();
			// メニュー番号の入力
			MenuNoReader inputNo = new MenuNoReader();
			menuNo = (int) inputNo.input();

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				EmployeeAllFindService.findAll();
				break;

			case ConstantValue.MENU_FIND_BY_NAME:

				// 検索機能の呼出
				EmployeeFindByEmpNameService.findByEmpName();
				break;

			case ConstantValue.MENU_FIND_BY_DEPTID:
				// 検索する部署IDを入力
				

				// 検索機能の呼出
				EmployeeFindByDeptIdService.findByDeptId();
				break;

			case ConstantValue.MENU_INSERT_EMPLOYEE:
				
				// 登録機能の呼出
				EmployeeRegisterService.empRegist();
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
