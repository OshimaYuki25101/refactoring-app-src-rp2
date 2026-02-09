package jp.co.sss.crud.io;

import jp.co.sss.crud.util.ConstantValue;

public class MenuNoReader implements IConsoleReader{

	@Override
	public String getErrorMsg() {
		return ConstantValue.MENU_START+"以上"+ConstantValue.MENU_END+"以下の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]$");//1-7 までの数値;
	}

	@Override
	public boolean isParseInt() {
		return true;
	}



}
