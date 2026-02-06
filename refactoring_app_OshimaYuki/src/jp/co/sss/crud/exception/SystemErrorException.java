package jp.co.sss.crud.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Extension;

public class SystemErrorException implements Extension{

	@Override
	public String getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean isCritical() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public byte[] getValue() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void encode(OutputStream out) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
