package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class PersonInfo {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int[] no = new int[100];
    String[] name = new String[100];
    int[] num = new int[100];
    String[] mail = new String[100];
    String[] add = new String[100];
    String[] photo = new String[100];
    String[] phone = new String[100];
    String[] registeredDate=new String[100];
    Date[] date = new Date[100];
    int[] viewCount = new int[100];
    String response;

    int count=0;
    for(int i =0; i<3; i++) {

      System.out.println("번호: ");
      no[i] = keyboard.nextInt();
      keyboard.nextLine();

      System.out.println("이름: ");
      name[i]=keyboard.nextLine();

      System.out.println("동물등록번호 : ");
      num[i]=keyboard.nextInt();
      keyboard.nextLine();

      System.out.println("이메일: ");
      mail[i]=keyboard.nextLine();

      System.out.println("주소 : ");
      add[i]=keyboard.nextLine();

      System.out.println("사진 : ");
      photo[i]=keyboard.nextLine();

      System.out.println("전화번호 : ");
      phone[i]=keyboard.nextLine();
      
      System.out.println("가입일 : ");
      registeredDate[i]=keyboard.nextLine();

      date[i] = new Date(System.currentTimeMillis());

      viewCount[i]=0;

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
      System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s,%s,%d\n",
          no[i], name[i], num[i], mail[i], add[i], photo[i], phone[i], registeredDate[i], date[i], viewCount[i]);
    }


  }
}
