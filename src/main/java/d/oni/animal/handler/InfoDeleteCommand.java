package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoDeleteCommand implements Command {
	
	List<Infomation> infoList;
	Prompt prompt;
	
	public InfoDeleteCommand(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}
	public void execute() {

		int index = indexOfInfomation(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("회원 인덱스가 유효하지 않습니다.");
			return;
		}

		this.infoList.remove(index);

		System.out.println("회원을 삭제했습니다.");
	}

	private int indexOfInfomation(int no) {
		for(int i = 0; i<this.infoList.size();i++) {
			if(this.infoList.get(i).getNo()==no) {
				return i;
			}
		}
		return -1;
	}
}
