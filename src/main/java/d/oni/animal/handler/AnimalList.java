package d.oni.animal.handler;

import java.util.Arrays;
import d.oni.animal.domain.Animal;

public class AnimalList {
  static final  int DEFAULT_CAPACITY=100;

  Animal[] list ;
  int size = 0;

  public AnimalList() {
    this.list = new Animal[DEFAULT_CAPACITY];
  }
  public AnimalList(int capacity) {
    if(capacity <DEFAULT_CAPACITY || capacity>10000)
      this.list = new Animal[DEFAULT_CAPACITY];
    else
      this.list = new Animal[capacity];
  }
  public Animal[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Animal animal) {
    if(this.size==this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
     
      this.list =Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = animal;
  }
  public Animal get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }

    }
    return null;
  }
}
