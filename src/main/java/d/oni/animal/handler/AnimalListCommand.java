package d.oni.animal.handler;

import java.util.Iterator;
import java.util.List;

import d.oni.animal.domain.Animal;
import d.oni.animal.util.Prompt;

public class AnimalListCommand implements Command{

	List<Animal> animalList;
	Prompt prompt;

	public  AnimalListCommand(Prompt prompt, List<Animal> animalList) {
		this.prompt = prompt;
		this.animalList = animalList;
	}

	public void execute() {
		Iterator<Animal> iterator = animalList.iterator();

		while(iterator.hasNext()) {
			Animal a = iterator.next();

			System.out.printf("%d, %s, %s, %d, %s, %s, %d\n",
					a.getNo(), a.getName(), a.getText(), a.getChoose(), a.getNum(), a.getDate(), a.getViewCount());
		}
	}

}
