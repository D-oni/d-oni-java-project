package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Animal;

public class AnimalHandler {

  Animal[] animals = new Animal[animal_SIZE];
  int animal_count = 0;

  Scanner input;
  static final  int animal_SIZE=100;

  public AnimalHandler(Scanner input) {
    this.input = input;
    this.animals = new Animal[animal_SIZE];
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

    this.animals[this.animal_count++]=animal;

  } 
  public void listAnimal() {

    for (int i = 0; i < this.animal_count; i++) {
      Animal a=this.animals[i];
      System.out.printf("%d, %s, %s, %d, %s, %s, %d\n", 
          a.getNo(), a.getName(), a.getText(), a.getChoose(), a.getNum(), a.getDate(), a.getViewCount());
    }
  }

}








