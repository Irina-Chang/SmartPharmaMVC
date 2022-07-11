package model.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceConfig
{
	private static EntityManager entityManager;
	
	
	public static EntityManager getEntityManager()
	{
		if(entityManager == null)
		{
			try
			{
				EntityManagerFactory factory= Persistence.createEntityManagerFactory("SmartPharmaDatabase");
				entityManager = factory.createEntityManager();
				System.out.println("Gerenciador de Entidades instanciado com sucesso!");
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar instanciar um Gerenciador de Entidades! " +
						e.getMessage());
			}
		}
		
		return entityManager;
	}
	
	public static void closeEntityManager()
	{
		try
		{
			if(entityManager != null)
			{
				entityManager.close();
				entityManager = null;
				System.out.println("Gerenciador de Entidades fechado com sucesso!");
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar fechar o Gerenciador de Entidades! " + e.getMessage());
		}
	}
}