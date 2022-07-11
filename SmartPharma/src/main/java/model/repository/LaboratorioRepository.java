package model.repository;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.EntityTransaction;

import model.Laboratorio;

public class LaboratorioRepository extends Repository<Laboratorio> {
	
	
	public boolean criar(Laboratorio l)
	{
		boolean resultado = true;
		
		EntityTransaction transacao = 
				PersistenceConfig.getEntityManager().getTransaction();
		
		try
		{
			transacao.begin();
			PersistenceConfig.getEntityManager().persist(l);
			transacao.commit();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar persistir uma nova entidade! " +
					e.getMessage());
			transacao.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
 
	public Laboratorio recuperarLaboratorioPorID(int id)
		{
		Laboratorio resultado = null;
			
			try
			{
				resultado = PersistenceConfig.getEntityManager().find(Laboratorio.class, id);
			}
			catch (Exception e)
			{
				System.out.println(
					"Erro ao tentar recuperar laboratorio! " + e.getMessage());
			}
			return resultado;
		}
	
		@SuppressWarnings("unchecked")
		public Collection<Laboratorio> recuperarLaboratorios()
		{
			Collection<Laboratorio> resultado = null;
			try
			{
				// HQL: "FROM Laboratorio"
				resultado = PersistenceConfig.getEntityManager().createQuery(
							"FROM " + Laboratorio.class.getName()).getResultList();
							
			}
			catch (Exception e)
			{
				System.out.println("Erro ao tentar recuperar listas de laboratorios! " + e.getMessage());
			}
			
			return resultado;
		}
		
		
		public static boolean excluirLaboratorio(Laboratorio laboratorio)
		{
			boolean resultado = true;

			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				laboratorio = PersistenceConfig.getEntityManager().find(Laboratorio.class, laboratorio.getId());
				PersistenceConfig.getEntityManager().remove(laboratorio);
				transaction.commit();
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar excluir registro de laboratorio! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}
		public static boolean atualizarLaboratorio(Laboratorio laboratorio)
		{
			boolean resultado = true;
			EntityTransaction transaction = PersistenceConfig.getEntityManager().getTransaction();
			
			try
			{
				transaction.begin();
				PersistenceConfig.getEntityManager().merge(laboratorio);
				transaction.commit();
				
				System.out.println("Laboratorio atualizado com sucesso");
			} catch (Exception e)
			{
				System.out.println("Erro ao tentar atualizar dados de laboratorio! " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
		}

}