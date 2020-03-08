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
public class ClientApp {
	public static void main(String[] args) {
		System.out.println("클라이언트 수업 관리 시스템");
	}
}
