package d.oni.animal.handler;

import java.util.Scanner;
import d.oni.animal.domain.Infomation;
import d.oni.animal.util.ArrayList;

public class InfoHandler {

  ArrayList<Infomation> infoList;
  Scanner input;

  public InfoHandler(Scanner input) {
    this.input=input;
    this.infoList = new ArrayList();
  }

  public InfoHandler(Scanner input, int capacity) {
    this.input = input;
    this.infoList = new ArrayList(capacity);
  }


  public void addInfo() {

    Infomation info = new Infomation();

    System.out.println("번호: ");
    info.setNo (input.nextInt());
    input.nextLine();

    System.out.println("이름: ");
    info.setName(input.nextLine());

    System.out.println("동물등록번호 : ");
    info.setNum(input.nextLine());

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
    Object[] arr = this.infoList.toArray();
    for(Object obj : arr) {
      Infomation i = (Infomation)obj;
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s\n",
          i.getNo(), i.getName(), i.getNum(), i.getMail(), i.getAdd(), i.getPhoto(), i.getPhone(), i.getRegisteredDate());
    }
  }
  public void detailInfo() {
  System.out.print("번호? ");
  int index = input.nextInt();
  input.nextLine(); // 숫자 뒤의 남은 공백 제거

  Infomation infomation = this.infoList.get(index);


  if (infomation == null) {
    System.out.println("회원 번호가 유효하지 않습니다.");
    return;
    }

  System.out.printf("번호: %d\n", infomation.getNo());
  System.out.printf("이름: %s\n", infomation.getName());
  System.out.printf("동물등록번호: %s\n", infomation.getNum());
  System.out.printf("이메일: %s\n", infomation.getMail());
  System.out.printf("주소: %s\n", infomation.getAdd());
  System.out.printf("사진: %s\n", infomation.getPhoto());
  System.out.printf("전화번호: %s\n", infomation.getPhone());
  System.out.printf("가입일: %s\n", infomation.getRegisteredDate());
}
  public void updateInfo() {
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Infomation oldInfo= this.infoList.get(index);

    if (oldInfo == null) {
      System.out.println("회원 인덱스가 유효하지 않습니다.");
      return;
    }

    boolean changed = false;
    String inputStr = null;
    Infomation newInfo = new Infomation();

    newInfo.setNo(oldInfo.getNo());

    System.out.printf("이름(%s)? ", oldInfo.getName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setName(oldInfo.getName());
    } else {
      newInfo.setName(inputStr);
      changed = true;
    }
    System.out.printf("동물등록번호(%s)? ", newInfo.getNum());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setNum(oldInfo.getNum());
    } else {
      newInfo.setNum(inputStr);
      changed = true;
    }

    System.out.printf("이메일(%s)? ", oldInfo.getMail());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setMail(oldInfo.getMail());
    } else {
      newInfo.setMail(inputStr);
      changed = true;
    }

    System.out.printf("주소(%s)? ", oldInfo.getAdd());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setAdd(oldInfo.getAdd());
    } else {
      newInfo.setAdd(inputStr);
      changed = true;
    }

    System.out.printf("사진(%s)? ", oldInfo.getPhoto());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setPhoto(oldInfo.getPhoto());
    } else {
      newInfo.setPhoto(inputStr);
      changed = true;
    }

    System.out.printf("전화(%s)? ", oldInfo.getPhone());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newInfo.setPhone(oldInfo.getPhone());
    } else {
      newInfo.setPhone(inputStr);
      changed = true;
    }

    if (changed) {
      this.infoList.set(index, newInfo);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }

    public void deleteInfo() {
      System.out.print("회원 인덱스? ");
      int index = input.nextInt();
      input.nextLine(); // 숫자 뒤의 남은 공백 제거

      Infomation info = this.infoList.get(index);

      if (info == null) {
        System.out.println("회원 인덱스가 유효하지 않습니다.");
        return;
      }

      this.infoList.remove(index);

      System.out.println("회원을 삭제했습니다.");
    }

}
