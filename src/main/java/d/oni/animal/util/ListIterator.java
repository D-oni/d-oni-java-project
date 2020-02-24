package d.oni.animal.util;

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
