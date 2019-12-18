
package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class Post {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int[] num = new int[100];
    String[] text = new String[100];
    Date[] date = new Date[100];
    int[] viewCount = new int[100];
    int[] scrap = new int[100];
    String response;

    int count=0;
    for(int i=0; i<3; i++) {
      System.out.println("번호: ");
      num[i]=keyboard.nextInt();
      keyboard.nextLine();

      System.out.println("내용: ");
      text[i]=keyboard.nextLine();
      

      System.out.println("스크랩 수: ");
      scrap[i]=keyboard.nextInt();

      keyboard.nextLine();
      
      date[i]=new Date(System.currentTimeMillis());
      

      viewCount[i]=0;
      count++;
      
      System.out.println();
      
      System.out.println("계속 입력하시겠습니까?(Y/n)");
      response =keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
      }

    }
    keyboard.close();
    
    System.out.println();


    for(int i=0;i<count; i++) {
      System.out.printf("%d, %s, %d, %s, %d\n",
          num[i], text[i], scrap[i], date[i], viewCount[i]);
    }


  } 
}
