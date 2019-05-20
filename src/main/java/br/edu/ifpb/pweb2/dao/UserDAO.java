package br.edu.ifpb.pweb2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.pweb2.model.Evento;
import br.edu.ifpb.pweb2.model.User;

@Repository
public class UserDAO {

	private static UserDAO instance = null;
	@PersistenceContext
	protected EntityManager manager;

	public static UserDAO getInstance(){
		if (instance == null){
			instance = new UserDAO();
		}

		return instance;
	}


	@Transactional
	public void gravar(User user) {
		manager.persist(user);
	}

	public List<User> findAll() {
		return manager.createQuery("select a from Aluno a", User.class).getResultList();
	}

	public User findByEmail(String email) {
		return manager.find(User.class, email);
	}
	public User findByName(String nome) {
		return manager.find(User.class, nome);
	}

	public User findById(Long id) {
		return manager.find(User.class, id);
	}
	
//	@Transactional
//	public User update(User user) {
//		return manager.merge(user);
//	}
//
	@Transactional
	public User delete(Long id) {
		User user = findById(id);
		manager.remove(user);
		return user;
	}
}


