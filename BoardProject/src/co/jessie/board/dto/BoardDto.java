package co.jessie.board.dto;

import java.sql.Date;

public class BoardDto {
	private int board_id;
	private String writer;
	private Date write_date;  //디폴트값 잡혀있음
	private String title;
	private String subject;
	private int hit; //디폴트값 잡혀있음
	
	public BoardDto() { //디폴트 생성자 꼭 만들어주기. 밑에 매개변수를 넣은 생성자가 있기 때문에.
		
	}
	
	public BoardDto(int id, String writer, String title, String subject){
		this.board_id = id;
		this.writer = writer;
		this.title = title;
		this.subject = subject;
		
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String toString() {
		System.out.println("순    번: " + board_id);
		System.out.println("작성자: " + writer);
		System.out.println("작성일자: " + write_date);
		System.out.println("제    목: " + title);
		System.out.println("내    용: " + subject);
		System.out.println("조회수: " + hit);		
		return null;
		
	}
}
