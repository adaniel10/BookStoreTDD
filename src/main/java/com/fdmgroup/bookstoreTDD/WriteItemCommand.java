package com.fdmgroup.bookstoreTDD;

public interface WriteItemCommand<T> {
	
	void insertItem(T t);

}
