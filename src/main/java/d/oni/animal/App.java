package d.oni.animal;

import java.util.Scanner;
import d.oni.animal.handler.BoardHandler;
import d.oni.animal.handler.AnimalHandler;
import d.oni.animal.handler.InfoHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판 마다 따로 생성한다.
    AnimalHandler animalHandler = new AnimalHandler(keyboard);
    BoardHandler boardHandler = new BoardHandler(keyboard, 200);
    InfoHandler infoHandler = new InfoHandler(keyboard, 1000);


    String command;
    
    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      
      switch (command) {
        case "/animal/add":
          animalHandler.addAnimal();
          break;
        case "/animal/list":
          animalHandler.listAnimal();
          break;
        case "/animal/detail":
          animalHandler.detailAnimal();
          break;
        case "/board/add":
          boardHandler.addBoard();
          break;
        case "/board/list":
          boardHandler.listBoard();
          break;
        case "/board/detail":
          boardHandler.detailBoard();
          break;
        case "/infomation/add":
          infoHandler.addInfo();
          break;  
        case "/infomation/list":
          infoHandler.listInfo();
          break;
        case "/infomation/detail":
          infoHandler.detailInfo();
          break;
        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
      
    } while (!command.equalsIgnoreCase("quit"));
    
    System.out.println("안녕!");
    
    keyboard.close();
  }
}






