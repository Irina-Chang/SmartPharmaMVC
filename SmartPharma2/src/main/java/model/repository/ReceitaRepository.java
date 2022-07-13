package model.repository;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Receita;

public class ReceitaRepository extends Repository<Receita> {
	
	public Receita recuperarReceitaPorID(int id)
		{
			Receita resultado = null;
			
			try
			{
				resultado =
					PersistenceConfig.getEntityManager()
						.find(Receita.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar receita! " +
					e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Receita>
			recuperarReceitas()
		{
			Collection<Receita> resultado = null;
			
			try
			{
				// HQL: "FROM Receita"
				resultado =
					PersistenceConfig.getEntityManager()
						.createQuery(
							"FROM " +
							Receita.class.getName())
						.getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar as receitas cadastradas! " +
						e.getMessage());
			}
			
			return resultado;
		}
		
		public static boolean excluirReceita(Receita receita)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				receita = PersistenceConfig.getEntityManager().find(Receita.class, receita.getId());
				PersistenceConfig.getEntityManager().remove(receita);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir receita! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
		
		public static boolean atualizarReceita(Receita receita)
		{
			boolean resultado = true;
			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				PersistenceConfig.getEntityManager().merge(receita);
				transaction.commit();
				
				System.out.println("Receita atualizada com sucesso!");
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar atualizar os dados da receita! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}