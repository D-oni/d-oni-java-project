package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;

public class AnimalDeleteCommand implements Command{

	List<Animal> animalList;

	Prompt prompt;

	public AnimalDeleteCommand(Prompt prompt, List<Animal> list) {
		this.prompt = prompt;
		this.animalList = list;
	}
	public void execute() {
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


