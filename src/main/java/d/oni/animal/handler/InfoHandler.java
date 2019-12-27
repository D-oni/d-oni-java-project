package d.oni.animal.handler;

import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Infomation;

public class InfoHandler {

  Infomation[] infomations = new Infomation[Info_SIZE];
  int Info_count=0;

   Scanner input;
  static final int Info_SIZE=100;
  
  
  public InfoHandler(Scanner input) {
    this.input=input;
    this.infomations = new Infomation[Info_SIZE];
  }
  

  public void addInfo() {

    Infomation info = new Infomation();

    System.out.println("번호: ");
    info.no = input.nextInt();
    input.nextLine();

    System.out.println("이름: ");
    info.name=input.nextLine();

    System.out.println("동물등록번호 : ");
    info.num=input.nextInt();
    input.nextLine();

    System.out.println("이메일: ");
    info.mail=input.nextLine();

    System.out.println("주소 : ");
    info.add=input.nextLine();

    System.out.println("사진 : ");
    info.photo=input.nextLine();

    System.out.println("전화번호 : ");
    info.phone=input.nextLine();

    System.out.println("가입일 : ");
    info.registeredDate=input.nextLine();

    info.date = new Date(System.currentTimeMillis());

    info.viewCount=0;

    this.infomations[this.Info_count++]=info;

  }

  public void listInfo() {
    for(int i=0; i<this.Info_count;i++) { 
      Infomation in = this.infomations[i];
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          in.no, in.name, in.num, in.mail, in.add, in.photo, in.phone, in.registeredDate, in.date, in.viewCount);
    }


  }
}
