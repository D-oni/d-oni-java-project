package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;

public class AnimalUpdateCommand implements Command{
	
	List<Animal> animalList;
	Prompt prompt;
	
	public  AnimalUpdateCommand(Prompt prompt, List<Animal> animalList) {
		this.prompt = prompt;
		this.animalList = animalList;
	}
	
	public void execute() {

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
	
	private int indexOfAnimal(int no) {
		for(int i =0; i<this.animalList.size(); i++) {
			if(this.animalList.get(i).getNo()==no) {
				return i;
			}
		}
		return -1;
	}
}
