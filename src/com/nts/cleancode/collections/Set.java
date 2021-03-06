package com.nts.cleancode.collections;

public class Set extends AbstractCollection{

	private int size = 0;
	private boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object element) {
		if (readOnly) 
			 return;
			if (shouldgrow()) 
				grow();
			

			if (contains(element))
				return;
			addElement(element);
		
	}

	protected void addElement(Object element) {
		elements[size++] = element;
	}

	protected void grow() {
		Object[] newElements =
			new Object[elements.length + INITIAL_CAPACITY];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	protected boolean shouldgrow() {
		return size + 1 > elements.length;
	}

	public boolean contains(Object element) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element)) {
				elements[i] = null;
				Object[] newElements = new Object[size - 1];
				int k = 0;
				for (int j = 0; j < size; j++) {
					if (elements[j] != null)
						newElements[k++] = elements[j];
				}
				size--;
				elements = newElements;
				return true;
			}
		return false;
	}



	public int capacity() {
		return elements.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}
}
