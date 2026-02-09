package jp.co.sss.crud.service;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantValue;

public interface IEmployeeService {

	/**
	 * サービスクラスのインスタンスを生成する
	 * @param menuNo
	 * @return IEmployeeServiceを実装したサービスクラス
	 */
	public static IEmployeeService getInstanceByMenuNo(int menuNo) {
		IEmployeeService newInstance = null;

		/*====menuNoごとにインスタンスを生成する。必要に応じてcaseを追加する====*/
		switch (menuNo) {
		//menu1 全件検索
		case ConstantValue.MENU_FIND_ALL:
			newInstance = new EmployeeAllFindService();
			break;
		//menu2 社員名検索
		case ConstantValue.MENU_FIND_BY_NAME:
			newInstance = new EmployeeFindByEmpNameService();
			break;
		//menu3 部署ID検索
		case ConstantValue.MENU_FIND_BY_DEPTID:
			newInstance = new EmployeeFindByDeptIdService();
			break;
		//menu4 新規登録
		case ConstantValue.MENU_INSERT_EMPLOYEE:
			newInstance = new EmployeeRegisterService();
			break;
		//menu5 更新
		case ConstantValue.MENU_UPDATE_EMPLOYEE:
			newInstance = new EmployeeUpdateService();
			break;
		//menu6 削除
		case ConstantValue.MENU_DELETE_EMPLOYEE:
			newInstance = new EmployeeDeleteService();
			break;

		}
		return newInstance;
	}

	/**
	 * ビジネスロジックの実行
	 * DAOのメソッドを呼び出し、ユースケース（登録や更新）を実装する
	 * また実行結果のコンソールへの表示を行う
	 * 
	 * @throws SystemErrorException, IllegalInputException
	 */
	public void execute() throws SystemErrorException, IllegalInputException;
}
