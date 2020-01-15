package d.oni.animal.handler;

import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Infomation;

public class InfoHandler {

  InfoList infoList;
  Scanner input;

  public InfoHandler(Scanner input) {
    this.input=input;
    this.infoList = new InfoList();
  }
  
  public InfoHandler(Scanner input, int capacity) {
    this.input = input;
    this.infoList = new InfoList(capacity);
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

    this.infoList.add(info);
    
    System.out.println("저장하였습니다.");

  }

  public void listInfo() {
    Infomation[] infom = this.infoList.toArray();
    for(Infomation i : infom) { 
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s\n",
          i.getNo(), i.getName(), i.getNum(), i.getMail(), i.getAdd(), i.getPhoto(), i.getPhone(), i.getRegisteredDate());
    }
  }
  public void detailInfo() {
  System.out.print("게시물 번호? ");
  int num = input.nextInt();
  input.nextLine(); // 숫자 뒤의 남은 공백 제거
  
  Infomation infomation = this.infoList.get(num);

  
  if (infomation == null) {
    System.out.println("게시물 번호가 유효하지 않습니다.");
    return;
    }

  System.out.printf("번호: %d\n", infomation.getNo());
  System.out.printf("이름: %s\n", infomation.getName());
  System.out.printf("동물등록번호: %d\n", infomation.getNum());
  System.out.printf("이메일: %s\n", infomation.getMail());
  System.out.printf("주소: %s\n", infomation.getAdd());
  System.out.printf("사진: %s\n", infomation.getPhoto());
  System.out.printf("전화번호: %s\n", infomation.getPhone());
  System.out.printf("가입일: %s\n", infomation.getRegisteredDate());
}
}
