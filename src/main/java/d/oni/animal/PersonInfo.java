package d.oni.animal;

import java.sql.Date;
import java.util.Scanner;

public class PersonInfo {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    
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

    final int SIZE=100;
    Info[] infomations = new Info[SIZE];

    int count=0;
    String response;
    
    for(int i =0; i<100; i++) {
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

      infomations[i]=infomation;
      count++;

      System.out.println();

      System.out.println("계속 입력하시겠습니까?(Y/n)");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")){
        break;
      }
    }

    keyboard.close();
    System.out.println();

    for(int i=0; i<count;i++) { 
      Info infomation = infomations[i];
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          infomation.no, infomation.name, infomation.num, infomation.mail, infomation.add, infomation.photo, infomation.phone, infomation.registeredDate, infomation.date, infomation.viewCount);
    }


  }
}
