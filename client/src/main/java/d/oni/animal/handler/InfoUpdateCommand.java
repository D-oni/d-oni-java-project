package d.oni.animal.handler;

import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoUpdateCommand implements Command{

	List<Infomation> infoList;
	Prompt prompt;

	public InfoUpdateCommand(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}

	
	public void execute() {
		int index = indexOfInfomation(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("회원 인덱스가 유효하지 않습니다.");
			return;
		}
		Infomation oldInfo= this.infoList.get(index);
		Infomation newInfo = new Infomation();


		newInfo.setNo(oldInfo.getNo());
		newInfo.setName(prompt.inputString(
				String.format("이름(%s)? ", oldInfo.getName(),oldInfo.getName())));

		newInfo.setNum(prompt.inputInt(
				String.format("동물등록번호(%s)? ",oldInfo.getNum(),oldInfo.getNum())) );

		newInfo.setMail(prompt.inputString(
				String.format("이메일(%s)? ",oldInfo.getMail(),oldInfo.getMail())) );

		newInfo.setAdd(prompt.inputString(
				String.format("주소(%s)? ",oldInfo.getAdd(),oldInfo.getAdd())) );

		newInfo.setPhoto(prompt.inputString(
				String.format("사진(%s)? ",oldInfo.getPhoto(),oldInfo.getPhoto())) );

		newInfo.setPhone(prompt.inputString(
				String.format("전화(%s)? ",oldInfo.getPhone(),oldInfo.getPhone())) );

		if (oldInfo.equals(newInfo)) {
			this.infoList.set(index, newInfo);
			System.out.println("회원 변경을 취소하였습니다.");
		}
		this.infoList.set(index, newInfo);
		System.out.println("회원을 변경했습니다.");
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
