package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;


public class AnimalDetailCommand implements Command{
	 List<Animal> animalList;

	  Prompt prompt;

	  public AnimalDetailCommand(Prompt prompt, List<Animal> list) {
	    this.prompt = prompt;
	    this.animalList = list;
	  }
	  
	  public void execute() {
		  int index = indexOfAnimal(prompt.inputInt("번호? "));

			if (index == -1) {
				System.out.println("해당 동물번호를 찾을 수 없습니다.");
				return;
			}

			Animal animal =  this.animalList.get(index);

			System.out.printf("번호: %d\n", animal.getNo());
			System.out.printf("이름: %s\n", animal.getName());
			System.out.printf("설명: %s\n", animal.getText());
			System.out.printf("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : %d\n", animal.getChoose());
			System.out.printf("동물등록번호여부(Y/n): %s\n", animal.getNum());
			System.out.printf("등록일 : %s\n", animal.getDate());
			System.out.printf("조회수: %d\n", animal.getViewCount());
		  
	  }
	  private int indexOfAnimal(int no) {
			for(int i =0; i<this.animalList.size(); i++) {
				if(this.animalList.get(i).getNo()==no) {
					return i;
				}
			}
			return -1;
		}


	
}
