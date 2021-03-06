package d.oni.animal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import d.oni.animal.context.ApplicationContextListener;
import d.oni.animal.domain.Animal;
import d.oni.animal.domain.Board;
import d.oni.animal.domain.Infomation;
import d.oni.animal.handler.AnimalAddCommand;
import d.oni.animal.handler.AnimalDeleteCommand;
import d.oni.animal.handler.AnimalDetailCommand;
import d.oni.animal.handler.AnimalListCommand;
import d.oni.animal.handler.AnimalUpdateCommand;
import d.oni.animal.handler.BoardAddCommand;
import d.oni.animal.handler.BoardDeleteCommand;
import d.oni.animal.handler.BoardDetailCommand;
import d.oni.animal.handler.BoardListCommand;
import d.oni.animal.handler.BoardUpdateCommand;
import d.oni.animal.handler.Command;
import d.oni.animal.handler.InfoAddCommand;
import d.oni.animal.handler.InfoDeleteCommand;
import d.oni.animal.handler.InfoDetailCommand;
import d.oni.animal.handler.InfoListCommand;
import d.oni.animal.handler.InfoUpdateCommand;
import d.oni.animal.util.Prompt;
public class App {

	Scanner keyboard = new Scanner(System.in);

	Deque<String> commandStack = new ArrayDeque<>();
	Queue<String> commandQueue = new LinkedList<>();

	Set<ApplicationContextListener> listeners = new HashSet<>();

	Map<String, Object> context = new HashMap<>();

	public void addApplicationContextListener(ApplicationContextListener listener) {
		listeners.add(listener);
	}

	public void removeApplicationContextListener(ApplicationContextListener listener) {
		listeners.remove(listener);
	}

	private void notifyApplicationInitialized() {
		for (ApplicationContextListener listener : listeners) {
			listener.contextInitialized(context);
		}
	}

	private void notifyApplicationDestroyed() {
		for (ApplicationContextListener listener : listeners) {
			listener.contextDestroyed(context);
		}
	}

	@SuppressWarnings("unchecked")
	public void service() {

		notifyApplicationInitialized();

		List<Animal> animalList = (List<Animal>) context.get("animalList");
		List<Board> boardList = (List<Board>) context.get("boardList");
		List<Infomation> infoList = (List<Infomation>) context.get("infoList");

		Prompt prompt = new Prompt(keyboard);
		HashMap<String,Command> commandMap = new HashMap<>();

		commandMap.put("/animal/add", new AnimalAddCommand(prompt,animalList));
		commandMap.put("/animal/list", new AnimalListCommand(prompt,animalList));
		commandMap.put("/animal/detail", new AnimalDetailCommand(prompt,animalList));
		commandMap.put("/animal/update", new AnimalUpdateCommand(prompt,animalList));
		commandMap.put("/animal/delete", new AnimalDeleteCommand(prompt,animalList));

		commandMap.put("/board/add", new BoardAddCommand(prompt,boardList));
		commandMap.put("/board/list", new BoardListCommand(prompt,boardList));
		commandMap.put("/board/detail", new BoardDetailCommand(prompt,boardList));
		commandMap.put("/board/update", new BoardUpdateCommand(prompt,boardList));
		commandMap.put("/board/delete", new BoardDeleteCommand(prompt,boardList));

		commandMap.put("/info/add", new InfoAddCommand(prompt,infoList));
		commandMap.put("/info/list", new InfoListCommand(prompt,infoList));
		commandMap.put("/info/detail", new InfoDetailCommand(prompt,infoList));
		commandMap.put("/info/update", new InfoUpdateCommand(prompt,infoList));
		commandMap.put("/info/delete", new InfoDeleteCommand(prompt,infoList));

		commandMap.put("/hello", new HelloCommand(prompt));
		commandMap.put("/compute/plus", new ComputePlusCommand(prompt));
		String command;

		while(true) {
			System.out.print("\n명령> ");
			command = keyboard.nextLine();

			if (command.length() == 0)
				continue;

			if (command.equals("quit")) {
				System.out.println("안녕!");
				break;
			} else if (command.equals("history")) {
				printCommandHistory(commandStack.iterator());
				continue;
			} else if (command.equals("history2")) {
				printCommandHistory(commandQueue.iterator());
				continue;
			}

			commandStack.push(command);

			commandQueue.offer(command);

			Command commandHandler = commandMap.get(command);

			if (commandHandler != null) {
				try {
					commandHandler.execute();
				} catch(Exception e) {
					e.printStackTrace();
					System.out.printf("명령어 실행 중 오류 발생: %s\n",e.getMessage());
				}
			} else {
				System.out.println("실행할 수 없는 명령입니다.");
			}
		}

		keyboard.close();

		notifyApplicationDestroyed();

	}

	private void printCommandHistory(Iterator<String> iterator) {
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

	public static void main(String[] args) {
		App app = new App();

		app.addApplicationContextListener(new DataLoaderListener());
		app.addApplicationContextListener(new GreetingListener());

		app.service();
	}
}
