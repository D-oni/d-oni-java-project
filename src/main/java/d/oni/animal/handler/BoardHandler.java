package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Board;

public class BoardHandler {

  Board[] boards = new Board[Board_SIZE];
  int Board_count=0;

  Scanner input;
  static final int Board_SIZE = 100;
  
  public BoardHandler(Scanner input) {
    this.input=input;
    this.boards=new Board[Board_SIZE];
    
  }
  public BoardHandler(Scanner input, int capacity) {
    this.input=input;
    if(capacity < Board_SIZE || capacity > 10000)
      this.boards = new Board[Board_SIZE];
      else
        this.boards = new Board[capacity];
      
  }
  
  
  
  
  public void addBoard() {

    Board board = new Board();

    System.out.println("번호: ");
    board.num=input.nextInt();
    input.nextLine();

    System.out.println("내용: ");
    board.text=input.nextLine();


    System.out.println("스크랩 수: ");
    board.scrap=input.nextInt();

    input.nextLine();

    board.date=new Date(System.currentTimeMillis());

    this.boards[this.Board_count++]=board;

    board.viewCount=0;

  }
  public void listBoard() {

    for(int i=0;i<this.Board_count; i++) {
      Board b = this.boards[i];
      System.out.printf("%d, %s, %d, %s, %d\n",
          b.num, b.text, b.scrap, b.date, b.viewCount);
    }


  } 
  
  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int num = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Board board = null;
    for (int i = 0; i < this.Board_count; i++) {
      if (this.boards[i].num == num) {
        board = this.boards[i];
        break;
      }
    }
    
    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    
    System.out.printf("번호: %d\n", board.num);
    System.out.printf("내용: %s\n", board.text);
    System.out.printf("스크랩 수: %d\n", board.scrap);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.println();
  }
}
