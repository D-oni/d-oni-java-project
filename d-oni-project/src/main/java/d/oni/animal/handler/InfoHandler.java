package d.oni.animal.handler;

import java.util.Iterator;
import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoHandler {

	List<Infomation> infoList;
	Prompt prompt;

	public InfoHandler(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}


	public void addInfo() {

		Infomation info = new Infomation();

		info.setNo (prompt.inputInt("번호: "));
		info.setName(prompt.inputString("이름: "));
		info.setNum(prompt.inputInt("동물등록번호 : "));
		info.setMail(prompt.inputString("이메일: "));
		info.setAdd(prompt.inputString("주소 : "));
		info.setPhoto(prompt.inputString("사진 : "));
		info.setPhone(prompt.inputString("전화번호 : "));
		info.setRegisteredDate(prompt.inputString("가입일 : "));

		this.infoList.add(info);

		System.out.println("저장하였습니다.");

	}

	public void listInfo() {
		Iterator<Infomation> iterator =infoList.iterator();
		
		while(iterator.hasNext()) {
			Infomation i = iterator.next();
			System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s\n",
					i.getNo(), i.getName(), i.getNum(), i.getMail(), i.getAdd(), i.getPhoto(), i.getPhone(), i.getRegisteredDate());
		}
	}
	public void detailInfo() {

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
	public void updateInfo() {

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

	public void deleteInfo() {

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
