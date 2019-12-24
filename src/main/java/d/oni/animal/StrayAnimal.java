package d.oni.animal;
import java.util.Scanner;
import d.oni.animal.handler.AnimalHandler;
import d.oni.animal.handler.BoardHandler;
import d.oni.animal.handler.InfoHandler;


public class StrayAnimal {
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {

    AnimalHandler.keyboard = keyboard;
    InfoHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;

    BoardHandler 상세정보 = new BoardHandler();
    BoardHandler 게시판 = new BoardHandler();
    AnimalHandler 동물정보 = new AnimalHandler();
    InfoHandler 사용자정보 = new InfoHandler();
    
    String command;
    do {
      System.out.println("입력> ");
      command = keyboard.nextLine();

      switch(command) {

        case "/animal/add":
          
          AnimalHandler.addAnimal(동물정보);
          
          break;
        case "/animal/list":
          
          AnimalHandler.listAnimal(동물정보);
          
          break;
        case "/info/add":
          
          InfoHandler.addInfo(사용자정보);
          
          break;
        case "/info/list":
          
          InfoHandler.listInfo(사용자정보);
          
          break;
        case "/board/add":
          
       BoardHandler.addBoard(게시판);
       
       break;
        case"/board/list":
          
          BoardHandler.listBoard(게시판);
          
          break;
        case "/board/detail":
          
       BoardHandler.detailBoard(상세정보);
       
       break;
       
        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
            System.out.println();
          }
      }


    }while(!command.equalsIgnoreCase("quit")); 
      System.out.println("종료!"); 
      keyboard.close();
    

  }
}










