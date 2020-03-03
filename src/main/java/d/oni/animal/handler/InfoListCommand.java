package d.oni.animal.handler;

import java.util.Iterator;
import java.util.List;

import d.oni.animal.domain.Infomation;
import d.oni.animal.util.Prompt;

public class InfoListCommand implements Command{

	List<Infomation> infoList;
	Prompt prompt;

	public InfoListCommand(Prompt prompt, List<Infomation> list) {
		this.prompt=prompt;
		this.infoList = list;
	}

	public void execute() {
	Iterator<Infomation> iterator =infoList.iterator();
		
		while(iterator.hasNext()) {
			Infomation i = iterator.next();
			System.out.printf("%d,%s,%d,%s,%s,%s,%s,%s\n",
					i.getNo(), i.getName(), i.getNum(), i.getMail(), i.getAdd(), i.getPhoto(), i.getPhone(), i.getRegisteredDate());
		}
	}

}
