package d.oni.animal.domain;

import java.sql.Date;

public class Board { 
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

