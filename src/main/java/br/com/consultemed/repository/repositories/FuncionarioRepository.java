/**
 * 
 */
package br.com.consultemed.repository.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.models.Funcionario;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class FuncionarioRepository {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public List<Funcionario> listaFuncionarios() {
		Query query = this.factory.createQuery("SELECT object(f) FROM Funcionario as f");
		return query.getResultList();
	}

	public Funcionario buscaPorCPF(Funcionario funcionario) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT f FROM Funcionario f WHERE f.cpf = :cpf");
		query.setParameter("cpf", funcionario.getCpf());
		Funcionario result = (Funcionario) query.getSingleResult();
		return result;
	}
	
	public Collection<Funcionario> listarFuncionarios() throws Exception {
		this.factory = emf.createEntityManager();
		List<Funcionario> contatos = new ArrayList<Funcionario>();
		try {
			factory.getTransaction().begin();
			TypedQuery<Funcionario> query = factory.createNamedQuery("Funcionario.findAll", Funcionario.class);
			contatos = query.getResultList();
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

		return contatos;
	}

	public void salvarFuncionario(Funcionario Funcionario) {
		this.factory = emf.createEntityManager();
		try {
			factory.getTransaction().begin();
			if (Funcionario.getId() == null) {
				factory.persist(Funcionario);
			} else {
				factory.merge(Funcionario);
			}
			factory.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();

		} finally {
			factory.close();
		}
	}

	public void deleteById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Funcionario Funcionario = new Funcionario();

		try {

			Funcionario = factory.find(Funcionario.class, id);
			factory.getTransaction().begin();
			factory.remove(Funcionario);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

}
