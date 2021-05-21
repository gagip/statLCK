package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERID = "gagip";
	private static final String PASSWORD = "sos123";
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static DBConnection instance;
	
	private DBConnection() {
		super();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
		
		try {
			conn = DriverManager.getConnection(URL, USERID, PASSWORD);
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}
	
	
	/**
	 * 싱글턴 패턴
	 */
	public static DBConnection getInstance() {
		if (instance == null)
			instance = new DBConnection();
		return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	
	private void runSQL() {
		String sql = "SELECT * FROM Member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("DB 서버에서 응답 성공");
			ResultSet resultSet = this.pstmt.executeQuery(sql);
			System.out.println("BOOKID \t\t BOOK NAME \t\t PUBLISHER \t\t PRICE");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 서버에서 응답 실패");
		}
		
	}
	
	public void insert(String table, String[] var, String[] val) {
		String sql = "INSERT INTO ? (?) VALUES (?)";
		
		
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DBConnection dbc = DBConnection.getInstance();
		
		dbc.runSQL();
	}
}
