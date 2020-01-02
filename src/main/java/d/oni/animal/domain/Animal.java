package d.oni.animal.domain;

import java.sql.Date;

public class Animal{    //public:다른 패키지에서  사용 할 수 있게 하는 공개 클래스
    private int no;  //공개 변수
    private String name;
    private String text;
    private int choose;
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
