package tn.esprit.spring.services;

import java.util.List;

public interface DAOservices <T>
{	
	T add(T s) ;
	T update(T s, Long id);
	java.util.List<T> getall() ;
	T getByid(Long id) ;
	T delete(Long id);
	List<T> getall(String keyword);

}
