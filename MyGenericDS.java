public class MyGenericDS<E> implements GenericOrderedCollection<E>{
	private Element<E> tail;
	private Element<E> head;
	private int length;
	
	public static void main(String[] args) {
		
	}
	
	public MyGenericDS() {
		this.tail = null;
		this.head = null;
		this.length = 0;
	}
	@Override
	public void append(E toAppend) {
		// TODO Auto-generated method stub
		Element<E> newTail = new Element<E>(toAppend);
		newTail.nextElem = this.tail;
		this.tail = newTail;
		this.length++;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if (this.length == 0) {
			return null;
		}
		else {
			return this.tail.elemValue;
		}
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if (this.length == 0) {
			return null;
		}
		else {
			E oldTailValue = this.tail.elemValue;
			this.tail = this.tail.nextElem;
			this.length--;
			return oldTailValue;
		}
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		Element<E> tempTail = this.tail;
		for(int i = length - 1; i > index; i--) {
			if (i != index) {
				tempTail = tempTail.nextElem;
			}
			else {
				tempTail.nextElem = tempTail.nextElem.nextElem;
			}
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}
  
}
class Element<T> {
	public T elemValue;
	public Element<T> nextElem;
	public Element(T _elemValue) {
		this.elemValue = _elemValue;
	}
}