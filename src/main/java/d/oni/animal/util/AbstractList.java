package d.oni.animal.util;


public abstract class AbstractList<E> implements List<E> {
  
  protected int size;
  
  public int size() {
    return size;
  }
  @Override
	public Iterator<E> Iterator() {
	  return new ListIterator<E>(this);
  }
  
  public class ListIterator<E> implements Iterator<E>{
		List<E> list;
		int cursor;

		public ListIterator(List<E> list) {
			this.list=list;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}






