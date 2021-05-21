package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DAOBase {
	protected static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	protected static final String USERID = "gagip";
	protected static final String PASSWORD = "sos123";
	
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
}
