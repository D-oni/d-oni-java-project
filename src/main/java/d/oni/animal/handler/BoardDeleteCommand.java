package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Board;
import d.oni.animal.util.Prompt;

public class BoardDeleteCommand implements Command{
	
	List<Board> boardList;
	
	Prompt prompt;
	
	public BoardDeleteCommand(Prompt prompt, List<Board> list) {
		this.prompt = prompt;
		this.boardList = list;
	}
	
	public void execute() {
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
