package jp.co.sss.crud.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class EmployeeDAO {

	/** インスタンス化を禁止 */
	private EmployeeDAO() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				Department dept = new Department();

				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(resultSet.getInt("gender"));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);

				employees.add(emp);
			}
			return employees;

		} catch (ClassNotFoundException | SQLException e) {

			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {

			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);

			} catch (SQLException e) {

				throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static List<Employee> findByName(String empName)
			throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<>();

		try {

			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + empName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				Department dept = new Department();

				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(resultSet.getInt("gender"));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);

				employees.add(emp);
			}
			return employees;

		} catch (ClassNotFoundException | SQLException e) {

			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {

			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);

			} catch (SQLException e) {

				throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 * @throws IllegalInputException 
	 * @throws SystemErrorException 
	 */
	public static List<Employee> findByDeptId(int searchDeptId) throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, searchDeptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				Department dept = new Department();

				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(resultSet.getInt("gender"));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);

				employees.add(emp);
			}

			return employees;

		} catch (ClassNotFoundException | SQLException e) {

			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {

			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);

			} catch (SQLException e) {

				throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insertEmployee(String empName, int gender, String birthday, int deptId)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, deptId);

			// SQL文を実行
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {

			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {

			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);

			} catch (SQLException e) {

				throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void updateEmployee(Employee emp)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, emp.getEmpName());
			preparedStatement.setInt(2, emp.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parseObject(emp.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, emp.getDepartment().getDeptId());
			preparedStatement.setInt(5, emp.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {

			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {

			try {
				// クローズ処理
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
			}
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void deleteEmployee(int empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.DELETE_EMPLOYEE);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
