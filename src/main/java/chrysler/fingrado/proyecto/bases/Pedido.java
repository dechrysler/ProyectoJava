package chrysler.fingrado.proyecto.bases;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="precio_total")
	private double precioTotal;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="preparado")
	private boolean preparado;
	 @ManyToMany(cascade = CascadeType.DETACH) 
	  @JoinTable(name="pedido_plato", 
	    joinColumns={@JoinColumn(name="id_pedido")}, 
	    inverseJoinColumns={@JoinColumn(name="id_plato")})
	 public List<Plato>platos;
	 
	 
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPreparado() {
		return preparado;
	}
	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}
	@Override
	public String toString() {
		return "Pedido: "+id;
	}
	
}
