package d.oni.animal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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

	static Scanner keyboard = new Scanner(System.in);

	static Deque<String> commandStack = new ArrayDeque<>();
	static Queue<String> commandQueue = new LinkedList<>();

	static List<Animal> animalList = new ArrayList<>();
	static List<Board> boardList = new ArrayList<>();
	static List<Infomation> infoList = new ArrayList<>();

	public static void main(String[] args) {

		loadAnimalData();
		loadInfoData();
		loadBoardData();

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

		saveAnimalData();
		saveInfoData();
		saveBoardData();

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

	private static void loadBoardData() {

		File file = new File("./board.data");

		try (DataInputStream in = 
				new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
			int size = in.readInt();
			for(int i = 0; i < size; i++) {
				Board board = new Board();
				board.setNum(in.readInt());
				board.setText(in.readUTF());
				board.setScrap(in.readInt());
				board.setDate(Date.valueOf(in.readUTF()));
				board.setViewCount(in.readInt());
				String writer = in.readUTF();
				if(writer.length() > 0) {
					board.setWriter(writer);
				}
				boardList.add(board);
			}
			System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", boardList.size());

		} catch (IOException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}
	private static void saveBoardData() {

		File file = new File("./board.data");

		try (DataOutputStream out 
				= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			out.write(boardList.size());
			for(Board board : boardList) {
				out.writeInt(board.getNum());
				out.writeUTF(board.getText());
				out.writeInt(board.getScrap());
				out.writeUTF(board.getDate().toString());
				out.writeInt(board.getViewCount());
			}
			System.out.printf("총 %d개의 게시물 데이터를 저장했습니다.\n",boardList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

		} 
	}
	private static void loadInfoData() {

		File file = new File("./info.data");

		try(DataInputStream in =
				new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
			int size = in.readInt();
			for(int i = 0; i < size; i++) {
				Infomation info = new Infomation();
				info.setNo(in.readInt());
				info.setName(in.readUTF());
				info.setNum(in.readInt());
				info.setMail(in.readUTF());
				info.setAdd(in.readUTF());
				info.setPhoto(in.readUTF());
				info.setPhone(in.readUTF());
				info.setRegisteredDate(Date.valueOf(in.readUTF()));
				infoList.add(info);
			}
			System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", infoList.size());

		} catch (IOException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}

	private static void saveInfoData() {
		File file = new File("./info.data");

		try (DataOutputStream out =
				new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			out.writeInt(infoList.size());
			for(Infomation info : infoList) {
				out.writeInt(info.getNo());
				out.writeUTF(info.getName());
				out.writeInt(info.getNum());
				out.writeUTF(info.getMail());
				out.writeUTF(info.getAdd());
				out.writeUTF(info.getPhoto());
				out.writeUTF(info.getPhone());
				out.writeUTF(info.getRegisteredDate().toString());
			}
			 System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", infoList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
		}  
	}
	private static void loadAnimalData() {
		File file = new File("./animal.data");

		try (DataInputStream in = 
				new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
			int size = in.readInt();
			for(int i = 0; i < size; i++) {
				Animal animal = new Animal();
				animal.setNo(in.readInt());
				animal.setName(in.readUTF());
				animal.setText(in.readUTF());
				animal.setChoose(in.readInt());
				animal.setNum(in.readUTF());
				animal.setDate(Date.valueOf(in.readUTF()));
				animal.setViewCount(in.readInt());
				animalList.add(animal);
			}
			System.out.printf("총 %d 개의 동물 데이터를 로딩했습니다.\n", animalList.size());

		} catch (IOException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} 
	}

	private static void saveAnimalData() {
		File file = new File("./animal.data");

		try (DataOutputStream out = 
				new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){ 
				out.writeInt(animalList.size());
				for(Animal animal : animalList) {
					out.writeInt(animal.getNo());
					out.writeUTF(animal.getName());
					out.writeUTF(animal.getText());
					out.writeInt(animal.getChoose());
					out.writeUTF(animal.getNum());
					out.writeUTF(animal.getDate().toString());
					out.writeInt(animal.getViewCount());
				}
			System.out.printf("총 %d 개의 동물 데이터를 저장했습니다.\n", animalList.size());

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

		} 
	}
}
