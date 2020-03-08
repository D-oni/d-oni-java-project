package d.oni.animal;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
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
public class ServerApp {
	public static void main(String[] args) {
		System.out.println("서버 수업 관리 시스템");
		 try (
			        ServerSocket serverSocket = new ServerSocket(9999)) {

			      System.out.println("클라이언트 연결 대기중...");

			      while (true) {
			        Socket socket = serverSocket.accept();
			        System.out.println("클라이언트와 연결되었음!");

			        processRequest(socket);

			        System.out.println("--------------------------------------");
			      }

			    } catch (Exception e) {
			      System.out.println("서버 준비 중 오류 발생!");
			      return;
			    }
			  }

			  static void processRequest(Socket clientSocket) {
			    try (
			        Socket socket = clientSocket;

			        Scanner in = new Scanner(socket.getInputStream());
			        PrintStream out = new PrintStream(socket.getOutputStream())) {

			      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

			      String message = in.nextLine();
			      System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

			      System.out.println("클라이언트: " + message);

			      out.println("Hi(강사)");
			      System.out.println("클라이언트로 메시지를 전송하였음!");


			    } catch (Exception e) {
			      System.out.println("예외 발생:");
			      e.printStackTrace();
			    }
	}
}
