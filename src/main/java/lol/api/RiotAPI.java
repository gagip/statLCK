package lol.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import lol.championMastery.ChampionMasteryDTO;
import lol.summoner.SummonerDAO;
import lol.summoner.SummonerDTO;





public class RiotAPI {
	ObjectMapper objectMapper = new ObjectMapper();
	String apiKey = "RGAPI-a3fd838d-db11-4c4c-924d-fbdf084c6f6e";
	
	

	SummonerDTO getSummoner(String summonerName) {
		String modiSummonerName = summonerName.replaceAll(" ", "%20");		// 공백 처리
		String requestURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + modiSummonerName
				+ "?api_key=" + apiKey; 
		SummonerDTO summonerDTO = null;
		
		
		BufferedReader reader = null;
		String result = null;
		InputStream in = null;
		
		try {
			URL url = new URL(requestURL);
			HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
			
			
			httpsConn.setRequestMethod("GET");
			httpsConn.setConnectTimeout(1000); //서버 연결 제한 시간
			httpsConn.setReadTimeout(1000); // 서버 연결 후 데이터 read 제한 시간
			
			int responseCode = httpsConn.getResponseCode();
			
			if (responseCode == HttpsURLConnection.HTTP_OK) {
				in = httpsConn.getInputStream();
			}
			
			reader = new BufferedReader(new InputStreamReader(in));
			result = reader.lines().collect(Collectors.joining());
			
			summonerDTO = objectMapper.readValue(result, SummonerDTO.class);
//			while ((line = reader.readLine()) != null) { 
//				System.out.printf("%s\n", line); 
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return summonerDTO;
	}
	
	ChampionMasteryDTO getChampionMastery(String encryptedSummonerId) {
		String requestURL = "https://kr.api.riotgames.com/lol/champion-mastery/v4/"
						+ "champion-masteries/by-summoner/" + encryptedSummonerId
						+ "?api_key=" + apiKey; 
		ChampionMasteryDTO championMasteryDTO = null;
		
		
		BufferedReader reader = null;
		String result = null;
		InputStream in = null;
		
		try {
			URL url = new URL(requestURL);
			HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
			
			
			httpsConn.setRequestMethod("GET");
			httpsConn.setConnectTimeout(1000); //서버 연결 제한 시간
			httpsConn.setReadTimeout(1000); // 서버 연결 후 데이터 read 제한 시간
			
			int responseCode = httpsConn.getResponseCode();
			
			if (responseCode == HttpsURLConnection.HTTP_OK) {
				in = httpsConn.getInputStream();
			}
			
			reader = new BufferedReader(new InputStreamReader(in));
			result = reader.lines().collect(Collectors.joining());
			
			championMasteryDTO = objectMapper.readValue(result, ChampionMasteryDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return championMasteryDTO;
	}

	
	public static void main(String[] args) {
		RiotAPI riotAPI = new RiotAPI();
		SummonerDAO summonerDAO = SummonerDAO.getInstance();
		ArrayList<SummonerDTO> summonerList = new ArrayList<SummonerDTO>();
		
		
		
		// 삽입 전
		summonerList = summonerDAO.selectList();
		printsummonerList(summonerList);
		
		
		
		// Riot API -> DTO -> DAO -> DB
		String[] idList = {"서렌누르면대충함", "ndbg", "어리고싶다", "쪼렙이다말로하자", "DRX Decky",
							"T1 Gumayusi", "BRO Hoya", "T1 Keria", "BRO Hena", "shenzhenshaoye"};
		
		for (String id : idList) {
			SummonerDTO summoner = riotAPI.getSummoner(id);
			summonerDAO.insert(summoner);
		}
		System.out.println();
		
		
		
		// 삽입 후
		summonerList = summonerDAO.selectList();
		printsummonerList(summonerList);
		
		
		
	}
	
	static void printsummonerList(ArrayList<SummonerDTO> summonerList) {
		System.out.println("name\t\t\tid\t\tsummoner_level");
		for (SummonerDTO summoner : summonerList) {
			String str = String.format("%s\t\t%s\t\t%d",
									summoner.getName(),
									summoner.getId(),
									summoner.getSummonerLevel());
			System.out.println(str);
		}
		System.out.println();
	}
}
