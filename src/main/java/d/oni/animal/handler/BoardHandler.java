package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Board;

public class BoardHandler {

  Board[] boards = new Board[Board_SIZE];
  int Board_count=0;

  public static Scanner keyboard;
  static final int Board_SIZE = 100;
  
  
  
  public static void addBoard(BoardHandler boardHandler) {

    Board board = new Board();

    System.out.println("번호: ");
    board.num=keyboard.nextInt();
    keyboard.nextLine();

    System.out.println("내용: ");
    board.text=keyboard.nextLine();


    System.out.println("스크랩 수: ");
    board.scrap=keyboard.nextInt();

    keyboard.nextLine();

    board.date=new Date(System.currentTimeMillis());

    boardHandler.boards[boardHandler.Board_count++]=board;

    board.viewCount=0;

  }
  public static void listBoard(BoardHandler boardHandler) {

    for(int i=0;i<boardHandler.Board_count; i++) {
      Board b = boardHandler.boards[i];
      System.out.printf("%d, %s, %d, %s, %d\n",
          b.num, b.text, b.scrap, b.date, b.viewCount);
    }


  } 
  
  public static void detailBoard(BoardHandler boardHandler) {
    System.out.print("게시물 번호? ");
    int num = keyboard.nextInt();
    keyboard.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Board board = null;
    for (int i = 0; i < boardHandler.Board_count; i++) {
      if (boardHandler.boards[i].num == num) {
        board = boardHandler.boards[i];
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
