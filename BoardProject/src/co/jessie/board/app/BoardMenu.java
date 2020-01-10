package co.jessie.board.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.jessie.board.dto.BoardDto;
import co.jessie.board.service.BoardService;
import co.jessie.board.serviceImpl.BoardServiceImpl;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		int choice; // 숫자로 입력받을것이기때문에 int
		boolean b = true;

		do {
			System.out.println("==========자유게시판==========");
			System.out.println("       1.전체목록보기 ");
//			System.out.println("       2.게시글 작성 ");
//			System.out.println("       3.게시글 수정");
//			System.out.println("       4.게시글 삭제");
			System.out.println("       2.종          료");
			System.out.println("========================");
			System.out.println("원하는 메뉴번호를 입력하세요.");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				boardList();
				break;
			case 2:
				b = false; // 실행문 빠져나감.
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			}
		} while (b);
	}

	private void boardDelete() {
		// TODO Auto-generated method stub

	}

	private void boardEdit() {
		// TODO Auto-generated method stub

	}

	private void boardWrite() {
		// TODO Auto-generated method stub

	}

	private void boardSearch(int key) {
		BoardService service = new BoardServiceImpl();
		BoardDto dto = new BoardDto();
		dto.setBoard_id(key);
		try {
			dto=service.select(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dto.toString();
		System.out.println("==========================");
		System.out.println("아무키나 누르세요.");
		String str = sc.nextLine();
	}

	private void boardList() {
		BoardService service = new BoardServiceImpl();
		List<BoardDto> list = new ArrayList<BoardDto>();
		BoardDto sdto;
		try {
			list = service.allselect();
			System.out.println("순번--작성자---작성일자------제   목---조회수");
			for (BoardDto dto : list) {
				System.out.print(dto.getBoard_id() + " ");
			    System.out.print(dto.getWriter() + " ");
			    System.out.print(dto.getWrite_date() + " ");
			    System.out.print(dto.getTitle() + " ");
//			    System.out.print(dto.getSubject() + " ");
			    System.out.println(dto.getHit() + " ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("==========================");
		System.out.println("내용을 볼 순번을 입력하세요.");
		System.out.println("==========================");
		int key = sc.nextInt();
		boardSearch(key);
	}
}
