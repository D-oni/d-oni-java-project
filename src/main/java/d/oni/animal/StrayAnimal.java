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

    final  int SIZE=100;
    Animal[] animals = new Animal[SIZE];

    String response;
    int count = 0;


    for(int i=0; i<100; i++) {
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

      animals[i]=animal;

      count++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Animal animal=animals[i];
      System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
          animal.no, animal.name, animal.text, animal.choose, animal.num, animal.date, animal.viewCount);
    }
  }
}