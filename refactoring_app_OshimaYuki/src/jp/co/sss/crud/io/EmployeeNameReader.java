package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeNameReader implements IConsoleReader {

	public String inputName() {
		//ローカル変数用の初期値代入
		String empName = "";
		//無限ループ用の変数
		boolean isError = false;
		do {
			try {
				isError = false;
				System.out.print(ConstantMsg.EMPLOYEE_NAME + ":");
				empName = (String) IConsoleReader.super.input();
			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				System.out.println();
				isError = true;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (isError);
		return empName;
	}

	@Override
	public String getErrorMsg() {
		return ConstantValue.NAME_MIN + "文字以上" + ConstantValue.NAME_MAX + "文字以下の文字列を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		//1以上30以下ならtrue、それ以外はfalse
		if (ConstantValue.NAME_MIN <= inputString.length() && inputString.length() <= ConstantValue.NAME_MAX) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}
