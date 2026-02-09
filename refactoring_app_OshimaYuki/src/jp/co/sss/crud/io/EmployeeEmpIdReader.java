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
				System.out.print(ConstantMsg.UPDATE_EMP_ID + ":");
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isValid(String inputString) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isParseInt() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
