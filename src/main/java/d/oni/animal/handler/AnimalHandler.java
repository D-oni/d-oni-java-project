package d.oni.animal.handler;
import java.sql.Date;
import java.util.Scanner;
import d.oni.animal.domain.Animal;
import d.oni.animal.util.ArrayList;

public class AnimalHandler {

  ArrayList<Animal> animalList ;

  public Scanner input;

  public AnimalHandler(Scanner input) {
    this.input = input;
    this.animalList = new ArrayList<>();
  }
  public void listAnimal() {
    Animal[] arr =this.animalList.toArray(new Animal[this.animalList.size()]);
    for(Animal a : arr) {
      System.out.printf("%d, %s, %s, %d, %s, %s, %d\n",
          a.getNo(), a.getName(), a.getText(), a.getChoose(), a.getNum(), a.getDate(), a.getViewCount());
    }
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
    System.out.print("번호? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Animal animal =  this.animalList.get(index);

    if (animal == null) {
      System.out.println("해당 동물번호를 찾을 수 없습니다".);
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
  public void updateAnimal() {
    System.out.println("번호?");
    int index =input.nextInt();
    input.nextLine();

    Animal oldAnimal = this.animalList.get(index);

    if(oldAnimal == null) {
      System.out.println("해당 번호를 찾을 수 없습니다.");
      return;
    }
    boolean changed = false;
    String inputStr = null;
    Animal newAnimal = new Animal();

    newAnimal.setNo(oldAnimal.getNo());

    System.out.printf("이름(%s)? ", oldAnimal.getName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newAnimal.setName(oldAnimal.getName());
    } else {
      newAnimal.setName(inputStr);
      changed = true;
    }


    System.out.print("설명? ");
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newAnimal.setText(oldAnimal.getText());
    } else {
      newAnimal.setText(inputStr);
      changed = true;
    }

    System.out.printf("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 ? ");
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newAnimal.setChoose(oldAnimal.getChoose());
    } else {
      newAnimal.setChoose(Integer.parseInt(inputStr));
      changed = true;
    }

    System.out.printf("동물등록번호여부(Y/n)? ");
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newAnimal.setNum(oldAnimal.getNum());
    } else {
      newAnimal.setNum(inputStr);
      changed = true;
    }
    if (changed) {
      this.animalList.set(index, newAnimal);
      System.out.println("정보를 변경했습니다.");
    } else {
      System.out.println("정보 변경을 취소하였습니다.");
    }
   }
    public void deleteAnimal() {
      System.out.print("번호? ");
      int index = input.nextInt();
      input.nextLine(); // 숫자 뒤의 남은 공백 제거

      Animal animal = this.animalList.get(index);

      if (animal == null) {
        System.out.println("해당 번호를 찾을 수 없습니다.");
        return;
      }

      this.animalList.remove(index);

      System.out.println("정보를 삭제했습니다.");
    }


}








