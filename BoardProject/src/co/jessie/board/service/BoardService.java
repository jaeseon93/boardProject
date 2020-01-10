package co.jessie.board.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import co.jessie.board.dto.BoardDto;

public abstract class BoardService {
	public Connection conn;
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private void getConnection() {
		Properties proper = new Properties();
		try {
			Reader reader = new FileReader("config/db.properties"); //중요함. 파일...!! 
			proper.load(reader);
			driver = proper.getProperty("driver");
			url = proper.getProperty("url");
			user = proper.getProperty("user");
			password = proper.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BoardService() {
		getConnection();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
//			System.out.println("서비스가 잠시 중단되었습니다. 관리자에게 문의하세요.");
		}
	}
	
	public abstract List<BoardDto> allselect() throws SQLException; //interface면 abstract안넣어줘도 됨
	public abstract BoardDto select(BoardDto dto) throws SQLException;
	public abstract int insert (BoardDto dto) throws SQLException;
	public abstract int update (BoardDto dto) throws SQLException;
	public abstract int delete (BoardDto dto) throws SQLException;
	
	
}
