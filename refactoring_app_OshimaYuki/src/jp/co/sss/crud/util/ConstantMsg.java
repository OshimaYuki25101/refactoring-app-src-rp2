package jp.co.sss.crud.util;

public class ConstantMsg {
	
	private ConstantMsg(){
	}
	
	//メニュー名
	public static final String MENU_TAITOL 				= "=== 社員管理システム ===";
	public static final String MANU_FIND_ALL 				= "1.全件表示";
	public static final String MENU_FIND_BY_EMPNAME	 	= "2.社員名検索";
	public static final String MENU_FIND_BY_DEPTID 		= "3.部署ID検索";
	public static final String MENU_INSERT_EMP				= "4.新規登録";
	public static final String MENU_UPDATE_EMP				= "5.更新";
	public static final String MENU_DELETE_EMP 			= "6.削除";
	public static final String MENU_SYSTEM_CLOSE 			= "7.終了";
	public static final String MENU_NUMBER_QUESTION 		= "メニュー番号を入力してください：";

	//共通表示メッセージ
	public static final String NOT_FIND 					= "該当者はいませんでした";
	public static final String SHOW_HEADER 				= "社員ID\t社員名\t性別\t生年月日\t部署名";

	//社員情報入力メッセージ
	public static final String EMPLOYEE_NAME 				= "社員名";
	public static final String GENDER_TYPE 				= "性別(0:その他, 1:男性, 2:女性, 9:回答なし)";
	public static final String BIRTHDAY 					= "生年月日(西暦年/月/日)";
	public static final String DEPT_TYPE 					= "部署ID(1:営業部、2:経理部、3:総務部)";
	
	//登録完了メッセージ
	public static final String INSERT_COMPLET 				= "社員情報を登録しました";
	
	//更新用メッセージ
	public static final String UPDATE_EMP_ID 				= "更新する社員の社員IDを入力してください：";
	public static final String UPDATE_COMPLETE 			= "社員情報を更新しました";
	
	//削除用メッセージ
	public static final String DELETE_EMP_ID 				= "削除する社員の社員IDを入力してください：";
	public static final String DELETE_EMPLOYEE 			= "社員情報を削除しました";
	
	//システム終了用メッセージ
	public static final String SYSTEM_END 					= "システムを終了します。";
	
	//性別表示用メッセージ
	public static final String GENDER_NO_ANSWER 			= "回答なし";
	public static final String GENDER_MAN 					= "男性";
	public static final String GENDER_WOMAN  				= "女性";
	public static final String GENDER_OTHRES 				= "その他";
	
	//部署表示用メッセージ
	public static final String DEPT_SEALE 					= "営業部";
	public static final String DEPT_ACCUNTING 				= "経理部";
	public static final String DEPT_GENERAL_AFFAIRS 		= "総務部";
	
	//エラー用メッセージ
	public static final String MSG_SYSTEM_ERROR 			= "システムエラー";
}
