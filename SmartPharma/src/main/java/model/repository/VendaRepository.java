package model.repository;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Venda;

public class VendaRepository extends Repository<Venda> {
	
	public Venda recuperarVendaPorID(int id)
		{
			Venda resultado = null;
			
			try
			{
				resultado = PersistenceConfig.getEntityManager().find(Venda.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar venda! " + e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Venda> recuperarVendas()
		{
			Collection<Venda> resultado = null;
			try
			{
				// HQL: "FROM Venda"
				resultado = PersistenceConfig.getEntityManager().createQuery(
							"FROM " + Venda.class.getName()).getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar as vendas realizadas! " + e.getMessage());
			}
			
			return resultado;
		}
		public static boolean excluirVenda(Venda venda)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				venda = PersistenceConfig.getEntityManager().find(Venda.class, venda.getId());
				PersistenceConfig.getEntityManager().remove(venda);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir registro de venda! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
		public static boolean atualizarVenda(Venda venda)
		{
			boolean resultado = true;
			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				PersistenceConfig.getEntityManager().merge(venda);
				transaction.commit();
				
				System.out.println("Venda atualizada com sucesso!");
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar atualizar dados de venda! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}