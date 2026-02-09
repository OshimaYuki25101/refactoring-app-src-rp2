package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantValue.DEPTID_MIN + "以上" + ConstantValue.DEPTID_MAX + "以下の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");//1-3 までの数値
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
