package d.oni.animal.handler;

import java.util.Iterator;
import java.util.List;

import d.oni.animal.domain.Board;
import d.oni.animal.util.Prompt;

public class BoardListCommand implements Command{

	  List<Board> boardList;
	  
	  Prompt prompt;
	  
	  public BoardListCommand(Prompt prompt, List<Board> list) {
	    this.prompt = prompt;
	    this.boardList = list;
	  }
	  

	public void execute() {

		Iterator<Board> iterator =  boardList.iterator();

		while (iterator.hasNext()) {

			Board b = iterator.next();
			
			System.out.printf("%d, %s, %d, %s, %d\n",
					b.getNum(), b.getText(), b.getScrap(), b.getDate(), b.getViewCount());
		}
	}

}
