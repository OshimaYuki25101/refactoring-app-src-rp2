package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
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
	public static void main(String[] args)  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = ConstantValue.INITIAL_VALUE;

		do {
			try {

			ConsoleWriter.showMenu();
			// メニュー番号の入力
			MenuNoReader inputNo = new MenuNoReader();
			menuNo = (int) inputNo.input();

			// 機能の呼出
			IEmployeeService selectMenu = IEmployeeService.getInstanceByMenuNo(menuNo);
			selectMenu.execute();

			}catch(IllegalInputException e){
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			}catch(SystemErrorException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (menuNo != ConstantValue.MENU_END);
		System.out.println(ConstantMsg.SYSTEM_END);
	}
}
