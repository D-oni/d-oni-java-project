package d.oni.animal;
import java.util.Scanner;
import d.oni.animal.handler.AnimalHandler;
import d.oni.animal.handler.BoardHandler;
import d.oni.animal.handler.InfoHandler;


public class StrayAnimal {
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {


    BoardHandler 상세정보 = new BoardHandler(keyboard);
    BoardHandler 게시판 = new BoardHandler(keyboard);
    AnimalHandler 동물정보 = new AnimalHandler(keyboard);
    InfoHandler 사용자정보 = new InfoHandler(keyboard);

    String command;
    do {
      System.out.println("입력> ");
      command = keyboard.nextLine();

      switch(command) {

        case "/animal/add":

          동물정보.addAnimal();

          break;
        case "/animal/list":

          동물정보.listAnimal();

          break;
        case "/info/add":

          사용자정보.addInfo();

          break;
        case "/info/list":

          사용자정보.listInfo();

          break;
        case "/board/add":

          게시판.addBoard();

          break;
        case"/board/list":

          게시판.listBoard();

          break;
        case "/board/detail":

          게시판.detailBoard();
    

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










