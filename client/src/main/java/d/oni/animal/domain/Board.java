package d.oni.animal.domain;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {    
	
	private static final long serialVersionUID = 20200131L; 
 
private int num;
  private String text;
  private int scrap;
  private Date date;
  private int viewCount;
  private String writer;

public static Board valueOf(String csv) {

		String[] data = csv.split(",");

		Board board = new Board();
		board.setNum(Integer.parseInt(data[0]));
		board.setText(data[1]);
		board.setScrap(Integer.parseInt(data[2]));
		board.setDate(Date.valueOf(data[3]));
		board.setViewCount(Integer.parseInt(data[4]));
		return board;

  }
  
  public String toString() {
	  return String.format("%d,%s,%d,%s,%d",this.getNum(),this.getText(),this.getScrap(),
				this.getDate(),this.getViewCount());
  }
  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + num;
	result = prime * result + scrap;
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
	if (scrap != other.scrap)
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
  public int getScrap() {
    return scrap;
  }
  public void setScrap(int scrap) {
    this.scrap = scrap;
  }
  
  public String getWriter() {
	  return writer;
  }
  
  public void setWriter(String writer) {
	  this.writer = writer;
  }

}

