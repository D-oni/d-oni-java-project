package d.oni.animal;
import java.sql.Date;
import java.util.Scanner;


public class StrayAnimal {
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {

    AnimalHandler.keyboard = keyboard;
    InfoHandler.keyboard = keyboard;
    PostHandler.keyboard = keyboard;


    String command;
    do {
      System.out.println("입력> ");
      command = keyboard.nextLine();

      switch(command) {

        case "/animal/add":
          
          AnimalHandler.addAnimal();
          
          break;
        case "/animal/list":
          
          AnimalHandler.listAnimal();
          
          break;
        case "/info/add":
          
          InfoHandler.addInfo();
          
          break;
        case "/info/list":
          
          InfoHandler.listInfo();
          
          break;
        case "/board/add":
          
       PostHandler.addBoard();
       
       break;
        case"/board/list":
          
          PostHandler.listBoard();
          
          break;
        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
            System.out.println();
          }
      }


    }while(!command.equalsIgnoreCase("quit")); {
      System.out.println("종료!"); 
      keyboard.close();
    }

  }
}










