package chrysler.fingrado.proyecto.importante;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import chrysler.fingrado.proyecto.HibernateUtil;
import chrysler.fingrado.proyecto.bases.Pedido;
import chrysler.fingrado.proyecto.bases.Plato;

public class Modelo {
	 public int []numeros ;
	public Modelo() {
		conectar();
	}
	
	@Override
	public void finalize() {
		desconectar();
		
	}
	
	public void conectar() {
		HibernateUtil.buildSessionFactory();
	}
	
	public void desconectar() {
		HibernateUtil.closeSessionFactory();
	}
	public List<Pedido>getPedidosAPreparar(){
		boolean hecho =false;
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM Pedido p WHERE p.preparado= :hecho");
		query.setParameter("hecho", hecho);
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>) query.getResultList();
		return pedidos;
	}

	public void pedidoPreparado(Pedido pedido) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(pedido);
		session.getTransaction().commit();
		session.close();
	}
}
