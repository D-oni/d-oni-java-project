package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Board;
import d.oni.animal.util.Prompt;

public class BoardDetailCommand implements Command{
	
	  List<Board> boardList;
	  Prompt prompt;
	  
	  public BoardDetailCommand(Prompt prompt, List<Board> list) {
	    this.prompt = prompt;
	    this.boardList = list;
	  }
	
	public void execute() {
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

	private int indexOfBoard(int no) {
		for(int i = 0; i< this.boardList.size();i++) {
			if(this.boardList.get(i).getNum()==no) {
				return i;
			}
		}
		return -1;
	}

}
