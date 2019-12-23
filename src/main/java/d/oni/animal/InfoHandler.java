package d.oni.animal;

import java.sql.Date;
import java.util.Scanner;

public class InfoHandler {


    static class Info{
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

    static final int Info_SIZE=100;
    static Info[] infomations = new Info[Info_SIZE];
    static int Info_count=0;
    static Scanner keyboard;
    
    static void addInfo() {
    
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

      infomations[Info_count++]=infomation;
   
      }
    
static void listInfo() {
    for(int i=0; i<Info_count;i++) { 
      Info in = infomations[i];
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          in.no, in.name, in.num, in.mail, in.add, in.photo, in.phone, in.registeredDate, in.date, in.viewCount);
    }


  }
}
