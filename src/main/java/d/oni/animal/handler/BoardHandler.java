package d.oni.animal.handler;
import java.sql.Date;

import d.oni.animal.domain.Board;
import d.oni.animal.util.LinkedList;
import d.oni.animal.util.Prompt;

public class BoardHandler {

	LinkedList<Board> boardList;
	Prompt prompt;

	public BoardHandler(Prompt prompt) {
		this.prompt = prompt;
		this.boardList = new LinkedList<>();
	}

	public void listBoard() {
		// BoardList의 보관된 값을 받을 배열을 준비한다.
		Board[] arr = new Board[this.boardList.size()];

		// toArray()에게 빈 배열을 넘겨서 복사 받는다.
		this.boardList.toArray(arr);

		for (Board b : arr) {
			System.out.printf("%d, %s, %d, %s, %d\n",
					b.getNum(), b.getText(), b.getScrap(), b.getDate(), b.getViewCount());
		}
	}

	public void addBoard() {
		Board board = new Board();

		board.setNum(prompt.inputInt("번호: "));
		board.setText(prompt.inputString("내용: "));
		board.setScrap(prompt.inputInt("스크랩 수: "));
		board.setDate(prompt.inputDate("등록일? "));
		board.setViewCount(prompt.inputInt("조회수? "));

		this.boardList.add(board);

		System.out.println("저장하였습니다.");
	}


	public void detailBoard() {

		int index = indexOfBoard(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("해당 게시글을 찾을 수 없습니다.");
			return;
		}
		Board board = this.boardList.get(index);

		System.out.printf("번호: %d\n", board.getNum());
		System.out.printf("내용: %s\n", board.getText());
		System.out.printf("스크랩 수: %s\n", board.getScrap());
		System.out.printf("등록일: %s\n", board.getDate());
		System.out.printf("조회수: %d\n", board.getViewCount());
	}

	public void updateBoard() {

		int index = indexOfBoard(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("해당 게시글을 찾을 수 없습니다.");
			return;
		}

		Board oldBoard = this.boardList.get(index);
		Board newBoard = new Board();

		newBoard.setNum(oldBoard.getNum());
		newBoard.setViewCount(oldBoard.getViewCount());
		newBoard.setScrap(oldBoard.getScrap());
		 newBoard.setDate(new Date(System.currentTimeMillis()));
		newBoard.setText(prompt.inputString(
				String.format("내용(%s)? ", oldBoard.getText()),oldBoard.getText()));


		if (newBoard.equals(oldBoard)) {
			System.out.println("게시글 변경을 취소하였습니다.");  
			return;
		}
		this.boardList.set(index, newBoard);
			System.out.println("게시글을 변경했습니다.");
		}

	public void deleteBoard() {
	
		int index = indexOfBoard(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("해당 게시글을 찾을 수 없습니다.");
			return;
		}

		this.boardList.remove(index);

		System.out.println("게시물을 삭제했습니다.");
	}

	private int indexOfBoard(int no) {
		for(int i = 0; i< this.boardList.size();i++) {
			if(this.boardList.get(i).getNum()==no) {
				return i;
			}
		}
		return -1;
	}
}
