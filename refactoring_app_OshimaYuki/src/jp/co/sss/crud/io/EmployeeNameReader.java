package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantValue;

public class EmployeeNameReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return ConstantValue.NAME_MIN + "文字以上" + ConstantValue.NAME_MAX + "文字以下の文字列を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
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
