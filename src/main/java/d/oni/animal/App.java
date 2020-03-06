package d.oni.animal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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

	static LinkedList<Animal> animalList = new LinkedList<>();
	static ArrayList<Board> boardList = new ArrayList<>();
	static LinkedList<Infomation> infoList = new LinkedList<>();

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

		File file = new File("./board.csv");

		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);

			dataScan = new Scanner(in);
			int count = 0;

			while(true) {
				try {
					String line = dataScan.nextLine();

					String[] data = line.split(",");

					Board board = new Board();
					board.setNum(Integer.parseInt(data[0]));
					board.setText(data[1]);
					board.setScrap(Integer.parseInt(data[2]));
					board.setDate(Date.valueOf(data[3]));
					board.setViewCount(Integer.parseInt(data[4]));

					boardList.add(board);
					count++;

				} catch (Exception e) {
					break;
				}
			}
			System.out.printf("총 %d 개의 수업 데이터를 로딩했습니다.\n", count);

		} catch (FileNotFoundException e) {
			System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
		} finally {
			try {
				dataScan.close();
			} catch (Exception e) {
			}
			try {
				in.close();
			} catch (Exception e) {
			}
		}
	}
	private static void saveBoardData() {

		File file = new File("./board.csv");

		FileWriter out = null;

		try {
			out = new FileWriter(file);
			int count = 0;

			for(Board board: boardList) {
				String line = String.format("%d,%s,%d,%s,%d",board.getNum(),board.getText(),board.getScrap(),
						board.getDate(),board.getViewCount());
				out.write(line);
				count++;
			}
			System.out.printf("총 %d개의 수업 데이터를 저장했습니다.\n",count);

		} catch (IOException e) {
			System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}
	private static void loadInfoData() {

		File file = new File("./info.csv");

		FileReader in = null;
		Scanner dataScan = null;

		try {
			in = new FileReader(file);
			dataScan = new Scanner(in);
			int count = 0;

			while (true) {
				try {
					String line = dataScan.nextLine();
					String[] data = line.split(",");
					
					Infomation info = new Infomation();

					info.setNo (Integer.parseInt(data[0]));
					info.setName(data[1]);
					info.setNum(Integer.parseInt(data[2]));
					info.setMail(data[3]);
					info.setAdd(data[4]);
					info.setPhoto(data[5]);
					info.setPhone(data[6]);
					info.setRegisteredDate(data[7]);

					 infoList.add(info);
			          count++;

			        } catch (Exception e) {
			          break;
			        }
			      }
			      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", count);

			    } catch (FileNotFoundException e) {
			      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
			    } finally {
			      try {
			        dataScan.close();
			      } catch (Exception e) {
			      }
			      try {
			        in.close();
			      } catch (Exception e) {
			      }
			    }
			  }
	
			private static void saveInfoData() {
				  File file = new File("./info.csv");

				    FileWriter out = null;

				    try {
				      out = new FileWriter(file);
				      int count = 0;

				      for (Infomation info: infoList) {
				        String line = String.format("%d,%s,%d,%s,%s,%s,%s,%s\n",
				        		info.getNo(), info.getName(), info.getNum(), info.getMail(), info.getAdd(), info.getPhoto(), info.getPhone(), info.getRegisteredDate());
				        out.write(line);
				        count++;
				      }
				      System.out.printf("총 %d 개의 회원 데이터를 저장했습니다.\n", count);

				    } catch (IOException e) {
				      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

				    } finally {
				      try {
				        out.close();
				      } catch (IOException e) {
				      }
				    }
				  }


			private static void loadAnimalData() {
				 File file = new File("./animal.csv");

				    FileReader in = null;
				    Scanner dataScan = null;

				    try {
				      in = new FileReader(file);
				      dataScan = new Scanner(in);
				      int count = 0;

				      while (true) {
				        try {
				          String line = dataScan.nextLine();
				          String[] data = line.split(",");

				          Animal animal = new Animal();

				  		animal.setNo(Integer.parseInt(data[0]));
				  		animal.setName(data[1]);
				  		animal.setText(data[2]);
				  		animal.setChoose(Integer.parseInt(data[3]));
				  		animal.setNum(data[4]);
				  		animal.setDate(Date.valueOf(data[2]));
				  		animal.setViewCount(Integer.parseInt(data[3]));


				          animalList.add(animal);
				          count++;

				        } catch (Exception e) {
				          break;
				        }
				      }
				      System.out.printf("총 %d 개의 게시물 데이터를 로딩했습니다.\n", count);

				    } catch (FileNotFoundException e) {
				      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
				    } finally {
				      try {
				        dataScan.close();
				      } catch (Exception e) {
				      }
				      try {
				        in.close();
				      } catch (Exception e) {
				      }
				    }
				  }

			private static void saveAnimalData() {
				  File file = new File("./animal.csv");

				    FileWriter out = null;

				    try {
				      out = new FileWriter(file);
				      int count = 0;

				      for (Animal animal: animalList) {
				        String line = String.format("%d, %s, %s, %d, %s, %s, %d\n",
				        		animal.getNo(), animal.getName(), animal.getText(), animal.getChoose(), animal.getNum(), animal.getDate(), animal.getViewCount());
				        out.write(line);
				        count++;
				      }
				      System.out.printf("총 %d 개의 게시물 데이터를 저장했습니다.\n", count);

				    } catch (IOException e) {
				      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

				    } finally {
				      try {
				        out.close();
				      } catch (IOException e) {
				      }
				    }
				  }
				}





