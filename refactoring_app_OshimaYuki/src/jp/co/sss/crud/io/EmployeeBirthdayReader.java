package jp.co.sss.crud.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeBirthdayReader implements IConsoleReader {

	public String inputBirthday() {
		//ローカル変数用の初期値代入
		String inputBirthday = "";
		//無限ループ用の変数
		boolean isError = false;
		do {
			try {
				isError = false;
				System.out.print(ConstantMsg.BIRTHDAY + ":");
				inputBirthday = (String) IConsoleReader.super.input();
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
		return inputBirthday;
	}

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		try {
			//正しい形式ではない、または存在しない日付だと例外をおこす
			LocalDate.parse(inputString,
					DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean isParseInt() {

		return false;
	}

}
