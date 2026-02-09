package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeEmpIdReader implements IConsoleReader {

	public int inputEmpId() {
		int inputEmpId = ConstantValue.INITIAL_VALUE;
		boolean isError = false;
		do {
			try {
				isError = false;
				System.out.print(ConstantMsg.DELETE_EMP_ID);
				inputEmpId = (int) IConsoleReader.super.input();
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
		return inputEmpId;
	}

	@Override
	public String getErrorMsg() {
		return ConstantValue.EMP_ID_MIN + "以上" + ConstantValue.EMP_ID_MIN + "以下の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$");
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}
