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
    info.setNo (input.nextInt());
    input.nextLine();

    System.out.println("이름: ");
    info.setName(input.nextLine());

    System.out.println("동물등록번호 : ");
    info.setNum(input.nextInt());
    input.nextLine();

    System.out.println("이메일: ");
    info.setMail(input.nextLine());

    System.out.println("주소 : ");
    info.setAdd(input.nextLine());

    System.out.println("사진 : ");
    info.setPhoto(input.nextLine());

    System.out.println("전화번호 : ");
    info.setPhone(input.nextLine());

    System.out.println("가입일 : ");
    info.setRegisteredDate(input.nextLine());

    info.setDate(new Date(System.currentTimeMillis()));

    info.setViewCount(0);

    this.infomations[this.Info_count++]=info;

  }

  public void listInfo() {
    for(int i=0; i<this.Info_count;i++) { 
      Infomation in = this.infomations[i];
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          in.getNo(), in.getName(), in.getNum(), in.getMail(), in.getAdd(), in.getPhoto(), in.getPhone(), in.getRegisteredDate(), in.getDate(), in.getViewCount());
    }


  }
}
