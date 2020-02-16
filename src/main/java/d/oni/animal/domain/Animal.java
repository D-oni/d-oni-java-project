package d.oni.animal.domain;

import java.sql.Date;

public class Animal{    //public:다른 패키지에서  사용 할 수 있게 하는 공개 클래스
    private int no;  //공개 변수
    private String name;
    private String text;
    private int choose;
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + choose;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + viewCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (choose != other.choose)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (viewCount != other.viewCount)
			return false;
		return true;
	}
	public int getNo() {
      return no;
    }
    public void setNo(int no) {
      this.no = no;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getText() {
      return text;
    }
    public void setText(String text) {
      this.text = text;
    }
    public int getChoose() {
      return choose;
    }
    public void setChoose(int choose) {
      this.choose = choose;
    }
    public String getNum() {
      return num;
    }
    public void setNum(String num) {
      this.num = num;
    }
    public Date getDate() {
      return date;
    }
    public void setDate(Date date) {
      this.date = date;
    }
    public int getViewCount() {
      return viewCount;
    }
    public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
    }
    private String num;
    private Date date;
    private int viewCount;

  }
