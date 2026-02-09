package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDeptIdReader implements IConsoleReader {

	public int inputDeptId() throws SystemErrorException, IllegalInputException {
		int inputDeptId = ConstantValue.INITIAL_VALUE;
		boolean isError = false;
		do {
			try {
				isError = false;
				System.out.print(ConstantMsg.DEPT_TYPE + "を入力してください:");
				inputDeptId = (int) IConsoleReader.super.input();
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
		return inputDeptId;
	}

	@Override
	public String getErrorMsg() {
		return ConstantValue.DEPT_ID_MIN + "以上" + ConstantValue.DEPT_ID_MAX + "以下の整数を入力してください";
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
