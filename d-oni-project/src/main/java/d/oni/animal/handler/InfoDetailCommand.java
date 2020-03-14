package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoDetailCommand implements Command{

	List<Infomation> infoList;
	Prompt prompt;

	public InfoDetailCommand(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}
	
	public void execute() {

		int index = indexOfInfomation(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("회원 번호가 유효하지 않습니다.");
			return;
		}

		Infomation info = this.infoList.get(index);

		System.out.printf("번호: %d\n", info.getNo());
		System.out.printf("이름: %s\n", info.getName());
		System.out.printf("동물등록번호: %s\n", info.getNum());
		System.out.printf("이메일: %s\n", info.getMail());
		System.out.printf("주소: %s\n", info.getAdd());
		System.out.printf("사진: %s\n", info.getPhoto());
		System.out.printf("전화번호: %s\n", info.getPhone());
		System.out.printf("가입일: %s\n", info.getRegisteredDate());
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
