package d.oni.animal.domain;

import java.sql.Date;

public class Infomation {
  private int no;
  private String name;
  private String num;
  private String mail;
  private  String add;
  private String photo;
  private String phone;
  private String registeredDate;
  private Date date;
  private int viewCount;
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
  public String getNum() {
    return num;
  }
  public void setNum(String num) {
    this.num = num;
  }
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }
  public String getAdd() {
    return add;
  }
  public void setAdd(String add) {
    this.add = add;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(String registeredDate) {
    this.registeredDate = registeredDate;
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

}



