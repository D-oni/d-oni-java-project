package d.oni.animal.domain;

import java.sql.Date;

public class Board { 
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + num;
		result = prime * result + ((scrap == null) ? 0 : scrap.hashCode());
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
		Board other = (Board) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (num != other.num)
			return false;
		if (scrap == null) {
			if (other.scrap != null)
				return false;
		} else if (!scrap.equals(other.scrap))
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
private int num;
  private String text;
  private Date date;
  private int viewCount;
  private String scrap;
  public int getNum() {
    return num;
  }
  
  public void setNum(int num) {
    this.num = num;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
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
    this.viewCount = viewCount ;
  }
  public String getScrap() {
    return scrap;
  }
  public void setScrap(String inputStr) {
    this.scrap = inputStr;
  }
}

