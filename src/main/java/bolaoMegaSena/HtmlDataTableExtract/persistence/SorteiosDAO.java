package bolaoMegaSena.HtmlDataTableExtract.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bolaoMegaSena.HtmlDataTableExtract.domain.Sorteio;

public class SorteiosDAO {
	
	public void salvar(Sorteio sorteio){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bolaomegaPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(sorteio);
		em.getTransaction().commit();
//		em.close();
	}
	
	
}
