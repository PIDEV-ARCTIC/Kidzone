package tn.esprit.spring.services;

public interface DAOservices <T>
{	
	T add(T s) ;
	T update(T s, Long id);
	java.util.List<T> getall() ;
	T getByid(Long id) ;
	T delete(Long id);

}
