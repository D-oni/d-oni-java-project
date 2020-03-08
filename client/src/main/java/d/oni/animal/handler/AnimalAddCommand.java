package d.oni.animal.handler;

import java.sql.Date;
import java.util.List;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;

public class AnimalAddCommand implements Command {
	
	List<Animal> animalList;
	Prompt prompt;
	
	public AnimalAddCommand(Prompt prompt, List<Animal> list) {
		this.prompt = prompt;
		this.animalList = list;
	}
	
	
	public void execute() {
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

}
