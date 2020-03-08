package d.oni.animal.handler;

import java.sql.Date;
import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoAddCommand implements Command {

	List<Infomation> infoList;
	Prompt prompt;

	public InfoAddCommand(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}
	
	public void execute() {

		Infomation info = new Infomation();

		info.setNo(prompt.inputInt("번호: "));
		info.setName(prompt.inputString("이름: "));
		info.setNum(prompt.inputInt("동물등록번호 : "));
		info.setMail(prompt.inputString("이메일: "));
		info.setAdd(prompt.inputString("주소 : "));
		info.setPhoto(prompt.inputString("사진 : "));
		info.setPhone(prompt.inputString("전화번호 : "));
		info.setRegisteredDate(new Date(System.currentTimeMillis()));

		this.infoList.add(info);

		System.out.println("저장하였습니다.");

	}

	
}
