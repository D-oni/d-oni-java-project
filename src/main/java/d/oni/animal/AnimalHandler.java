package d.oni.animal;
import java.sql.Date;
import java.util.Scanner;

public class AnimalHandler {

    static class Animal{
      int no;
      String name;
      String text;
      int choose;
      String num;
      Date date;
      int viewCount;

    }
    static final  int animal_SIZE=100;
    static Animal[] animals = new Animal[animal_SIZE];
    static int animal_count = 0;
    static Scanner keyboard;
    
    
static void addAnimal() {
  
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

          animals[animal_count++]=animal;

}
      static void listAnimal() {
        
          for (int i = 0; i < animal_count; i++) {
            Animal a=animals[i];
            System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
                a.no, a.name, a.text, a.choose, a.num, a.date, a.viewCount);
          }
      }
   
}








