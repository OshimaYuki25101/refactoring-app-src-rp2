package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeGenderReader implements IConsoleReader {

	public int inputGender() {
		//ローカル変数用の初期値代入
		int gender = ConstantValue.INITIAL_VALUE;
		//無限ループ用の変数
		boolean isError = false;
		do {
			try {
				isError = false;
				System.out.print(ConstantMsg.GENDER_TYPE + ":");
				gender = (int) IConsoleReader.super.input();
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
		return gender;
	}

	@Override
	public String getErrorMsg() {
		return ConstantValue.GENDER_NO_ANSWER + "以上" + ConstantValue.GENDER_WOMAN + "以下、もしくは"
				+ ConstantValue.GENDER_OTHERS + "で入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[0129０１２９]{1}$");//0・1・2・9どれかの整数
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
