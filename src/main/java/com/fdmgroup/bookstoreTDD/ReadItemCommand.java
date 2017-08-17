package com.fdmgroup.bookstoreTDD;

import java.util.List;

public interface ReadItemCommand<T> {
	
	List<T> readAll();

}
