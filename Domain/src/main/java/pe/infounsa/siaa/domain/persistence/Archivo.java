package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="archivo")
public class Archivo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int arc_iid;
	
	private String arc_vruta;
	private String arc_vnombre;
	private String arc_vnombresistema;
	private String arc_vextension;
	
	public Archivo(){
		
	}

	public int getArc_iid() {
		return arc_iid;
	}

	public void setArc_iid(int arc_iid) {
		this.arc_iid = arc_iid;
	}

	public String getArc_vruta() {
		return arc_vruta;
	}

	public void setArc_vruta(String arc_vruta) {
		this.arc_vruta = arc_vruta;
	}

	public String getArc_vnombre() {
		return arc_vnombre;
	}

	public void setArc_vnombre(String arc_vnombre) {
		this.arc_vnombre = arc_vnombre;
	}

	public String getArc_vnombresistema() {
		return arc_vnombresistema;
	}

	public void setArc_vnombresistema(String arc_vnombresistema) {
		this.arc_vnombresistema = arc_vnombresistema;
	}

	public String getArc_vextension() {
		return arc_vextension;
	}

	public void setArc_vextension(String arc_vextension) {
		this.arc_vextension = arc_vextension;
	}

}
