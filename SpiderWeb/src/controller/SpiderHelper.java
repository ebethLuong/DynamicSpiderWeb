package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SpiderModel;

public class SpiderHelper 
{
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SpiderWeb");

	public void insertSpider(SpiderModel sp)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sp);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<SpiderModel> showAllItems()
	{
		EntityManager em = emfactory.createEntityManager();
		List <SpiderModel> allItems = em.createQuery("SELECT i FROM SpiderModel i").getResultList();
		return allItems;
	}

	public void deleteSpider(SpiderModel toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpiderModel> typedQuery = em.createQuery("select li from SpiderModel li where li.name = :selectedname and li.species = :selectedspecies", SpiderModel.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedname", toDelete.getName());
		typedQuery.setParameter("selectedspecies", toDelete.getSpecies());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		SpiderModel result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	public void cleanUp(){
		emfactory.close();
		}
	
	public SpiderModel searchById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SpiderModel found = em.find(SpiderModel.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<SpiderModel> searchBySpecies(String spSpecies) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpiderModel> typedQuery = em.createQuery("select li from SpiderModel li where li.species = :selectedSpecies", SpiderModel.class);
		typedQuery.setParameter("selectedSpecies", spSpecies);
		List<SpiderModel> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;

	}
	
	public List<SpiderModel> searchByName(String spName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SpiderModel> typedQuery = em.createQuery("select li from SpiderModel li where li.name = :selectedName", SpiderModel.class);
		typedQuery.setParameter("selectedName", spName);
		List<SpiderModel> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;

	}


	
	public void updateSpider(SpiderModel toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}


}

