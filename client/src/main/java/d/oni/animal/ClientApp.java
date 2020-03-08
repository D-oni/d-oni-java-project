package d.oni.animal;

import java.io.PrintStream;
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
public class ClientApp {
	public static void main(String[] args) {
		System.out.println("클라이언트 수업 관리 시스템");

	    String serverAddr = null;
	    int port = 0;

	    Scanner keyScan = new Scanner(System.in);

	    try {
	      System.out.print("서버? ");
	      serverAddr = keyScan.nextLine();

	      System.out.print("포트? ");
	      port = Integer.parseInt(keyScan.nextLine());

	    } catch (Exception e) {
	      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
	      keyScan.close();
	      return;
	    }

	    try (
	        Socket socket = new Socket(serverAddr, port);

	        PrintStream out = new PrintStream(socket.getOutputStream());
	        Scanner in = new Scanner(socket.getInputStream())) {

	      System.out.println("서버와 연결되었음!");

	      System.out.print("서버에 보낼 메시지: ");
	      String sendMsg = keyScan.nextLine();

	      out.println(sendMsg);
	      System.out.println("서버에 메시지를 전송하였음!");

	      String message = in.nextLine();
	      System.out.println("서버로부터 메시지를 수신하였음!");

	      System.out.println("서버: " + message);

	      System.out.println("서버와 연결을 끊었음!");

	    } catch (Exception e) {
	      System.out.println("예외 발생:");
	      e.printStackTrace();
	    }

	    keyScan.close();

	}
}
