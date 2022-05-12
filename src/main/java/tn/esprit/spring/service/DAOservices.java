package tn.esprit.spring.service;

import java.util.List;

public interface DAOservices <T>
{	
	T add(T s) ;
	List<T> getall() ;
	T getByid(Long id) ;
	T delete(Long id);
	T update(T s);

}
