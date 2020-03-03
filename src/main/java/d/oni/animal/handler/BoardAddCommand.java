package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Board;
import d.oni.animal.util.Prompt;

public class BoardAddCommand implements Command{
	
	  List<Board> boardList;
	  Prompt prompt;
	  
	  public BoardAddCommand(Prompt prompt, List<Board> list) {
	    this.prompt = prompt;
	    this.boardList = list;
	  }
	  
	
	public void execute() {
		Board board = new Board();

		board.setNum(prompt.inputInt("번호: "));
		board.setText(prompt.inputString("내용: "));
		board.setScrap(prompt.inputInt("스크랩 수: "));
		board.setDate(prompt.inputDate("등록일? "));
		board.setViewCount(prompt.inputInt("조회수? "));

		this.boardList.add(board);

		System.out.println("저장하였습니다.");
	}

}
