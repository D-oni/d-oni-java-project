package d.oni.animal.handler;
import java.sql.Date;
import java.util.AbstractList;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;

public class AnimalHandler {

	AbstractList<Animal> animalList ;

	Prompt prompt;

	public AnimalHandler(Prompt prompt, AbstractList<Animal> animalList) {
		this.prompt = prompt;
		this.animalList = animalList;
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

		animal.setNo(prompt.inputInt("번호: "));

		animal.setName(prompt.inputString("이름: "));

		animal.setText(prompt.inputString("설명: "));

		animal.setChoose(prompt.inputInt("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 : "));

		animal.setNum(prompt.inputString("동물등록번호여부(Y/n): "));

		animal.setDate(new Date(System.currentTimeMillis()));
		animal.setViewCount(0);

		this.animalList.add(animal);

		System.out.println("저장하였습니다.");

	}

	public void detailAnimal() {

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
	public void updateAnimal() {

		int index = indexOfAnimal(prompt.inputInt("번호? "));

		if(index == -1) {
			System.out.println("해당 번호를 찾을 수 없습니다.");
			return;
		}

		Animal oldAnimal = this.animalList.get(index);
		Animal newAnimal = new Animal();

		newAnimal.setNo(oldAnimal.getNo());
		newAnimal.setName(prompt.inputString(
				String.format("이름(%s)? ", oldAnimal.getName()),oldAnimal.getName()));
		newAnimal.setName(prompt.inputString(
				String.format("설명(%s)? ", oldAnimal.getText()),oldAnimal.getText()));
		newAnimal.setChoose(prompt.inputInt(
				String.format("1.유기동물 입양  2.유기동물 보호  3.반려동물 찾기 ? ", oldAnimal.getChoose()),oldAnimal.getChoose()));
		newAnimal.setNum(prompt.inputString(
				String.format("동물등록번호여부(Y/n)? ", oldAnimal.getNum()),oldAnimal.getNum()));


		if (newAnimal.equals(oldAnimal)) {
			System.out.println("정보 변경을 취소하였습니다.");
			return;
		}
		this.animalList.set(index, newAnimal);
		System.out.println("정보를 변경했습니다.");
	}
public void deleteAnimal() {

	int index = indexOfAnimal(prompt.inputInt("번호? "));

	if (index == -1) {
		System.out.println("해당 번호를 찾을 수 없습니다.");
		return;
	}

	this.animalList.remove(index);

	System.out.println("정보를 삭제했습니다.");
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








