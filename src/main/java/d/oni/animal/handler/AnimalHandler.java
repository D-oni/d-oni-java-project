package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Animal;

public class AnimalHandler {
   
     Animal[] animals = new Animal[animal_SIZE];
     int animal_count = 0;
    
    public static Scanner keyboard;
     static final  int animal_SIZE=100;
    
public static void addAnimal(AnimalHandler animalHandler) {
  
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

          animalHandler.animals[animalHandler.animal_count++]=animal;

}
public static void listAnimal(AnimalHandler animalHandler) {
        
          for (int i = 0; i < animalHandler.animal_count; i++) {
            Animal a=animalHandler.animals[i];
            System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
                a.no, a.name, a.text, a.choose, a.num, a.date, a.viewCount);
          }
      }
   
}








