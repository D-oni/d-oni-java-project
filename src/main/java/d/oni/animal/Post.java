package d.oni.animal;
import java.sql.Date;
import java.util.Scanner;

public class Post {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class Board{
      int num;
      String text;
      Date date;
      int viewCount;
      int scrap;
      String response;
    }
    final int SIZE = 100;
    Board[] boards = new Board[SIZE];
    
    String response;
    int count=0;
    
    for(int i=0; i<3; i++) {
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
      
      boards[i]=board;
      
      board.viewCount=0;
      count++;
      
      System.out.println();
      
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      response =keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
      }

    }
    keyboard.close();
    
    System.out.println();


    for(int i=0;i<count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %d, %s, %d\n",
          board.num, board.text, board.scrap, board.date, board.viewCount);
    }


  } 
}
