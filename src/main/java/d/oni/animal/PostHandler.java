package d.oni.animal;
import java.sql.Date;
import java.util.Scanner;

public class PostHandler {
 
    static class Board{
      int num;
      String text;
      Date date;
      int viewCount;
      int scrap;
    }
    static final int Board_SIZE = 100;
    static Board[] boards = new Board[Board_SIZE];
    static int Board_count=0;
    static Scanner keyboard;
    
static void addBoard() {
  
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
      
      boards[Board_count++]=board;
      
      board.viewCount=0;
   
      }
static void listBoard() {
  
    for(int i=0;i<Board_count; i++) {
      Board b = boards[i];
      System.out.printf("%d, %s, %d, %s, %d\n",
          b.num, b.text, b.scrap, b.date, b.viewCount);
    }


  } 
}
