package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Board;

public class BoardHandler {

  BoardList boardList;
  Scanner input;

  public BoardHandler(Scanner input) {
    this.input=input;
    this.boardList=new BoardList();

  }
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    this.boardList = new BoardList(capacity);
  }

  public void listBoard() {
    Board[] boards = this.boardList.toArray();
    for (Board b : boards) {
      System.out.printf("%d, %s, %d, %s, %d\n",
          b.getNum(), b.getText(), b.getScrap(), b.getDate(), b.getViewCount());
    }
  } 

  public void addBoard() {
    Board board = new Board();

    System.out.println("번호: ");
    board.setNum(input.nextInt());
    input.nextLine();

    System.out.println("내용: ");
    board.setText(input.nextLine());

    System.out.println("스크랩 수: ");
    board.setScrap(input.nextInt());

    input.nextLine();

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    this.boardList.add(board);

    System.out.println("저장하였습니다.");
  }


  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int num = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Board board = this.boardList.get(num);
    
    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
      }

    System.out.printf("번호: %d\n", board.getNum());
    System.out.printf("내용: %s\n", board.getText());
    System.out.printf("스크랩 수: %d\n", board.getScrap());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }
}
