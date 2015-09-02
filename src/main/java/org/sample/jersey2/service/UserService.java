package org.sample.jersey2.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.sample.jersey2.entity.User;

@ApplicationScoped
public class UserService {

	@Inject
	protected EntityManager em;

	public List<User> findAll() {
		return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	public List<User> findEnableUsers() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> root = query.from(User.class);

		query
			.select(root)
			.where(
				cb.and(
					cb.equal(root.get("disableFlag"), "0")
				)
			);
		return em.createQuery(query).getResultList();
	}

}
