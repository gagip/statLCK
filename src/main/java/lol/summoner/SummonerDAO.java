package lol.summoner;

import static util.DBUtil.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import base.DAOBase;

public class SummonerDAO extends DAOBase{
	
	private static SummonerDAO instance;
	
	private SummonerDAO() {
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
	
	public static SummonerDAO getInstance() {
		if (instance == null)
			instance = new SummonerDAO();
		return instance;
	}
	
	public ArrayList<SummonerDTO> selectList() {
		String sql = "SELECT * FROM Summoner";
		ArrayList<SummonerDTO> summonerList = new ArrayList<SummonerDTO>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SummonerDTO summonerDTO = new SummonerDTO();
				
				summonerDTO.setAccountId(rs.getString("account_id"));
				summonerDTO.setProfileIconId(rs.getInt("profile_icon_id"));
				summonerDTO.setRevisionDate(rs.getLong("revision_date"));
				summonerDTO.setName(rs.getString("name"));
				summonerDTO.setId(rs.getString("id"));
				summonerDTO.setPuuid(rs.getString("puuid"));
				summonerDTO.setSummonerLevel(rs.getLong("summoner_level"));
				
				summonerList.add(summonerDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return summonerList;
	}
	
	public void insert(SummonerDTO summonerDTO) {
		String sql = "INSERT INTO Summoner (account_id, profile_icon_id, revision_date, name, id, puuid, summoner_level) "
				+ "				VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, summonerDTO.getAccountId());
			pstmt.setLong(2, summonerDTO.getProfileIconId());
			pstmt.setLong(3, summonerDTO.getRevisionDate());
			pstmt.setString(4, summonerDTO.getName());
			pstmt.setString(5, summonerDTO.getId());
			pstmt.setString(6, summonerDTO.getPuuid());
			pstmt.setLong(7, summonerDTO.getSummonerLevel());
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
				System.out.println("SummonerDAO - 삽입 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
	}
}
