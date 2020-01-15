package d.oni.animal.handler;

import java.util.Arrays;
import d.oni.animal.domain.Infomation;

public class InfoList {

  static final int DEFAULT_CAPACITY=100;

  Infomation[] list;
  int size=0;

  public InfoList() {
    this.list = new Infomation[DEFAULT_CAPACITY];
  }
  public InfoList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Infomation[DEFAULT_CAPACITY];
    else 
      this.list = new Infomation[capacity];

  }

  public Infomation[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Infomation infomation) {
    if(this.size == this.list .length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity +(oldCapacity>>1);
      
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = infomation;
  }
  
  public Infomation get(int no) {
    for(int i = 0; i< this.size; i++) {
      if(this.list[i].getNo()==no) {
        return this.list[i];
      }
    }
    return null;
  }
  
  

}
