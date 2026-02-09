package jp.co.sss.crud.util;

public class ConstantValue {
	private ConstantValue() {
	}

	//汎用
	//初期値用
	public static final int INITIAL_VALUE = 0;
	//メニュー
	//全件検索
	public static final int MENU_FIND_ALL = 1;
	//社員名検索
	public static final int MENU_FIND_BY_NAME = 2;
	//部署ID検索
	public static final int MENU_FIND_BY_DEPTID = 3;
	//登録
	public static final int MENU_INSERT_EMPLOYEE = 4;
	//更新
	public static final int MENU_UPDATE_EMPLOYEE = 5;
	//削除
	public static final int MENU_DELETE_EMPLOYEE = 6;
	//終了
	public static final int MENU_END = 7;

	//性別用
	//回答なし
	public static final int GENDER_NO_ANSWER = 0;
	//男性
	public static final int GENDER_MAN = 1;
	//女性
	public static final int GENDER_WOMAN = 2;
	//その他
	public static final int GENDER_OTHERS = 9;

	//部署ID用
	//営業部
	public static final int SALES_DEPT = 1;
	//経理部
	public static final int ACCUNTING_DEPT = 2;
	//総務部
	public static final int GENERAL_AFFAIRS_DEPT = 3;

	//エラーメッセージ用
	//社員ID最小値
	public static final int EMP_ID_MIN = 1;
	//社員ID最大値
	public static final int EMP_ID_MAX = 9999;
	//文字数最小値
	public static final int NAME_MIN = 1;
	//文字数最大値
	public static final int NAME_MAX = 30;
	//部署ID最小値
	public static final int DEPT_ID_MIN = 1;
	//部署ID最大値
	public static final int DEPT_ID_MAX = 3;
}
