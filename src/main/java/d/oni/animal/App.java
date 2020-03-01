package d.oni.animal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import d.oni.animal.domain.Animal;
import d.oni.animal.domain.Board;
import d.oni.animal.domain.Infomation;
import d.oni.animal.handler.AnimalHandler;
import d.oni.animal.handler.BoardHandler;
import d.oni.animal.handler.InfoHandler;
import d.oni.animal.util.Prompt;

public class App {

	static Scanner keyboard = new Scanner(System.in);

	 static Deque<String> commandStack = new ArrayDeque<>();
	  static Queue<String> commandQueue = new LinkedList<>();
	 

	public static void main(String[] args) {

		Prompt prompt = new Prompt(keyboard);
		LinkedList<Animal> animalList = new LinkedList<>();
		AnimalHandler animalHandler = new AnimalHandler(prompt, animalList);

		ArrayList<Board> boardList = new ArrayList<>();
		BoardHandler boardHandler = new BoardHandler(prompt, boardList);

		LinkedList<Infomation> infoList = new LinkedList<>();
		InfoHandler infoHandler = new InfoHandler(prompt , infoList);


		String command;

		do {
			System.out.print("\n명령> ");
			command = keyboard.nextLine();

			if (command.length() == 0)
				continue;

			commandStack.push(command);
			commandQueue.offer(command);

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
				printCommandHistory(commandStack.iterator());
				break;
			case "history2":
				printCommandHistory(commandQueue.iterator());
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
	private static void printCommandHistory(Iterator<String> iterator) {
		int count = 0;
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
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
}






