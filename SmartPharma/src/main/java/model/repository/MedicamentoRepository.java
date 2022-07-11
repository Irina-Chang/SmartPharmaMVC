package model.repository;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import model.Medicamento;
public class MedicamentoRepository extends Repository<Medicamento> {
 
	
	public Medicamento recuperarMedicamentoPorID(int id)
		{
			Medicamento resultado = null;
			
			try
			{
				resultado = PersistenceConfig.getEntityManager().find(Medicamento.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar medicamento! " + e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Medicamento> recuperarMedicamentos()
		{
			Collection<Medicamento> resultado = null;
			try
			{
				// HQL: "FROM Medicamento"
				resultado = PersistenceConfig.getEntityManager().createQuery(
							"FROM " + Medicamento.class.getName()).getResultList();
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar as vendas realizadas! " + e.getMessage());
			}
			
			return resultado;
		}
		public static boolean excluirMedicamento(Medicamento medicamento)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				medicamento = PersistenceConfig.getEntityManager().find(Medicamento.class, medicamento.getId());
				PersistenceConfig.getEntityManager().remove(medicamento);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir registro de medicamento! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
		public static boolean atualizarMedicamento(Medicamento medicamento)
		{
			boolean resultado = true;
			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				PersistenceConfig.getEntityManager().merge(medicamento);
				transaction.commit();
				
				System.out.println("Medicamento atualizado com sucesso");
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar atualizar dados de medicamento! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}
