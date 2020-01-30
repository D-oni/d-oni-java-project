package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Animal;
import d.oni.animal.util.ArrayList;

public class AnimalHandler {
  
  ArrayList<Animal> animalList ;
  Scanner input;

  public AnimalHandler(Scanner input) {
    this.input = input;
    this.animalList = new ArrayList<>();
  }

  public void addAnimal() {

    Animal animal = new Animal();

    System.out.println("번호: ");  
    animal.setNo(input.nextInt());
    input.nextLine();

    System.out.println("이름: ");  
    animal.setName(input.nextLine());

    System.out.println("설명: ");  
    animal.setText(input.nextLine());

    System.out.println("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : ");  
    animal.setChoose(input.nextInt());
    input.nextLine();

    System.out.println("동물등록번호여부(Y/n): ");  
    animal.setNum(input.nextLine());

    animal.setDate(new Date(System.currentTimeMillis()));
    animal.setViewCount(0);

    this.animalList.add(animal);
    
    System.out.println("저장하였습니다.");

  } 
  public void detailAnimal() {
    System.out.print("게시물 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Animal animal = this.animalList.get(index);
    
    if (animal == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
      }

    System.out.printf("번호: %d\n", animal.getNo());
    System.out.printf("이름: %s\n", animal.getName());
    System.out.printf("설명: %s\n", animal.getText());
    System.out.printf("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : %d\n", animal.getChoose());
    System.out.printf("동물등록번호여부(Y/n): %s\n", animal.getNum());
    System.out.printf("등록일 : %s\n", animal.getDate());
    System.out.printf("조회수: %d\n", animal.getViewCount());
  }
  public void listAnimal() {
      Animal[] arr =new Animal[this.animalList.size()];
      
      this.animalList.toArray(arr);

      for(Animal a : arr) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
          a.getNo(), a.getName(), a.getText(), a.getChoose(), a.getNum(), a.getDate(), a.getViewCount());
    }
  }

}








