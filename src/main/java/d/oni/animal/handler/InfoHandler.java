package d.oni.animal.handler;

import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Infomation;

public class InfoHandler {

  Infomation[] infomations = new Infomation[Info_SIZE];
  int Info_count=0;

  public static Scanner keyboard;
  static final int Info_SIZE=100;

  public static void addInfo(InfoHandler infoHandler) {

    Infomation info = new Infomation();

    System.out.println("번호: ");
    info.no = keyboard.nextInt();
    keyboard.nextLine();

    System.out.println("이름: ");
    info.name=keyboard.nextLine();

    System.out.println("동물등록번호 : ");
    info.num=keyboard.nextInt();
    keyboard.nextLine();

    System.out.println("이메일: ");
    info.mail=keyboard.nextLine();

    System.out.println("주소 : ");
    info.add=keyboard.nextLine();

    System.out.println("사진 : ");
    info.photo=keyboard.nextLine();

    System.out.println("전화번호 : ");
    info.phone=keyboard.nextLine();

    System.out.println("가입일 : ");
    info.registeredDate=keyboard.nextLine();

    info.date = new Date(System.currentTimeMillis());

    info.viewCount=0;

    infoHandler.infomations[infoHandler.Info_count++]=info;

  }

  public static void listInfo(InfoHandler infoHandler) {
    for(int i=0; i<infoHandler.Info_count;i++) { 
      Infomation in = infoHandler.infomations[i];
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          in.no, in.name, in.num, in.mail, in.add, in.photo, in.phone, in.registeredDate, in.date, in.viewCount);
    }


  }
}
