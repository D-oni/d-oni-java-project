package d.oni.animal;

import java.util.Scanner;
import d.oni.animal.handler.AnimalHandler;
import d.oni.animal.handler.BoardHandler;
import d.oni.animal.handler.InfoHandler;
import d.oni.animal.util.Prompt;
import d.oni.animal.util.Queue;
import d.oni.animal.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();
  public static void main(String[] args) {
    Prompt prompt = new Prompt(keyboard);

    AnimalHandler animalHandler = new AnimalHandler(prompt);
    BoardHandler boardHandler = new BoardHandler(prompt);
    InfoHandler infoHandler = new InfoHandler(prompt);


    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      commandStack.push(command);

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
        case "/animal/update":
          animalHandler.updateAnimal();
          break;
        case "/animal/delete":
          animalHandler.deleteAnimal();
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
        case "/board/update":
          boardHandler.updateBoard();
          break;
        case "/board/delete":
          boardHandler.deleteBoard();
          break;
        case "/info/add":
          infoHandler.addInfo();
          break;
        case "/info/list":
          infoHandler.listInfo();
          break;
        case "/info/detail":
          infoHandler.detailInfo();
          break;
        case "/info/update":
          infoHandler.updateInfo();
          break;
        case "/info/delete":
          infoHandler.deleteInfo();
          break;
        case "history":
          printCommandHistory();
          break;
        case "history2":
          printCommandHistory2();
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
  private static void printCommandHistory() {
    Stack<String> historyStack = commandStack.clone();
    int count = 0;
    while(!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;

      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;

    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());

      if ((++count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}






