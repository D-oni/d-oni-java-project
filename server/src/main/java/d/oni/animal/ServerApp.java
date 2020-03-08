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
			        // 서버쪽 연결 준비
			        // => 클라이언트의 연결을 9999번 포트에서 기다린다.
			        ServerSocket serverSocket = new ServerSocket(9999)) {

			      System.out.println("클라이언트 연결 대기중...");

			      while (true) {
			        // 서버에 대기하고 있는 클라이언트와 연결
			        // => 대기하고 있는 클라이언트와 연결될 때까지 리턴하지 않는다.
			        Socket socket = serverSocket.accept();
			        System.out.println("클라이언트와 연결되었음!");

			        // 클라이언트의 요청 처리
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
			        // 요청 처리가 끝난 후 클라이언트와 연결된 소켓을 자동으로 닫으려면
			        // 이 괄호 안에 별도의 로컬 변수에 담는다.
			        Socket socket = clientSocket;

			        // 클라이언트의 메시지를 수신하고 클라이언트로 전송할 입출력 도구 준비
			        Scanner in = new Scanner(socket.getInputStream());
			        PrintStream out = new PrintStream(socket.getOutputStream())) {

			      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

			      // 클라이언트가 보낸 메시지를 수신한다.
			      // => 한 줄의 메시지를 읽을 때까지 리턴하지 않는다.
			      String message = in.nextLine();
			      System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

			      System.out.println("클라이언트: " + message);

			      // 클라이언트에게 메시지를 전송한다.
			      // => 클라이언트가 메시지를 모두 읽을 때까지 리턴하지 않는다.
			      out.println("Hi(강사)");
			      System.out.println("클라이언트로 메시지를 전송하였음!");


			    } catch (Exception e) {
			      System.out.println("예외 발생:");
			      e.printStackTrace();
			    }
	}
}
