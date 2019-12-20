package d.oni.animal;
import java.sql.Date;
import java.util.Scanner;

public class StrayAnimal {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class Animal{
      int no;
      String name;
      String text;
      int choose;
      String num;
      Date date;
      int viewCount;

    }
    final  int animal_SIZE=100;
    Animal[] animals = new Animal[animal_SIZE];
    int animal_count = 0;

    class Info{
      int no;
      String name;
      int num;
      String mail;
      String add;
      String photo;
      String phone;
      String registeredDate;
      Date date;
      int viewCount;

    }

    final int info_SIZE=100;
    Info[] infomations = new Info[info_SIZE];
    int info_count=0;

    class Board{
      int num;
      String text;
      Date date;
      int viewCount;
      int scrap;
   
    }
    final int board_SIZE = 100;
    Board[] boards = new Board[board_SIZE];
    int board_count=0;

    String command;
    do {
      System.out.println("입력> ");
      command = keyboard.nextLine();

      switch(command) {

        case "/animal/add":
          Animal animal = new Animal();

          System.out.println("번호: ");  
          animal.no=keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("이름: ");  
          animal.name=keyboard.nextLine();

          System.out.println("설명: ");  
          animal.text=keyboard.nextLine();

          System.out.println("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : ");  
          animal.choose=keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("동물등록번호여부(Y/n): ");  
          animal.num=keyboard.nextLine();

          animal.date = new Date(System.currentTimeMillis());
          animal.viewCount = 0;

          animals[animal_count++]=animal;

          break;
        case "/animal/list":
          for (int i = 0; i < animal_count; i++) {
            Animal a=animals[i];
            System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
                a.no, a.name, a.text, a.choose, a.num, a.date, a.viewCount);
          }
          break;
        case "/info/add":
          Info infomation = new Info();

          System.out.println("번호: ");
          infomation.no = keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("이름: ");
          infomation.name=keyboard.nextLine();

          System.out.println("동물등록번호 : ");
          infomation.num=keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("이메일: ");
          infomation.mail=keyboard.nextLine();

          System.out.println("주소 : ");
          infomation.add=keyboard.nextLine();

          System.out.println("사진 : ");
          infomation.photo=keyboard.nextLine();

          System.out.println("전화번호 : ");
          infomation.phone=keyboard.nextLine();

          System.out.println("가입일 : ");
          infomation.registeredDate=keyboard.nextLine();

          infomation.date = new Date(System.currentTimeMillis());

          infomation.viewCount=0;

          infomations[info_count++]=infomation;

          break;
        case "/info/list":
          for(int i=0; i<info_count;i++) { 
            Info in = infomations[i];
            System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
                in.no, in.name, in.num, in.mail, in.add, in.photo, in.phone, in.registeredDate, in.date, in.viewCount);
          }
          break;
        case "/board/add":
          Board board = new Board();

          System.out.println("번호: ");
          board.num=keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("내용: ");
          board.text=keyboard.nextLine();


          System.out.println("스크랩 수: ");
          board.scrap=keyboard.nextInt();

          keyboard.nextLine();

          board.date=new Date(System.currentTimeMillis());

          boards[board_count++]=board;

          board.viewCount=0;
        case"/board/list":
          for(int i=0;i<board_count; i++) {
            Board b = boards[i];
            System.out.printf("%d, %s, %d, %s, %d\n",
                b.num, b.text, b.scrap, b.date, b.viewCount);
          }
          break;
        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
            System.out.println();
          }
      }


    }while(!command.equalsIgnoreCase("quit")); {
      System.out.println("종료!"); 
      keyboard.close();
    }

  }
}










