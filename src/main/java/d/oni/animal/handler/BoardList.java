package d.oni.animal.handler;

import java.util.Arrays;
import java.util.Scanner;
import d.oni.animal.domain.Board;

public class BoardList {
  static final int DEFAULT_CAPACITY = 100;

  Board[] list ;
  int size=0;

  public BoardList() {
    this.list = new Board[DEFAULT_CAPACITY];
  }


  public BoardList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Board[DEFAULT_CAPACITY];
    else 
      this.list = new Board[capacity];

  }
  public Board[] toArray() {

    return Arrays.copyOf(this.list, this.size);
  }
  public void add(Board board) {
    if (this.size == this.list.length) {
      // 현재 배열에 게시글 객체가 꽉 찼으면, 배열을 늘린다.
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = board;
  }

  public Board get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNum() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}