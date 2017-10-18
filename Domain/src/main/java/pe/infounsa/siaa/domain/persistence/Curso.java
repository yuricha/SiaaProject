package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoPK id;//Primary key
	
	private String cur_vnombre;
	private String loc_iid;
	private String sed_iid;
	private String cur_vdescripcion;
	private String cur_bestado;
	private String tipcur_iid;//Foreign key
	
	public Curso(){
		
	}
	
	public CursoPK getId() {
		return id;
	}

	public void setId(CursoPK id) {
		this.id = id;
	}

	public String getCur_vnombre() {
		return cur_vnombre;
	}

	public void setCur_vnombre(String cur_vnombre) {
		this.cur_vnombre = cur_vnombre;
	}

	public String getLoc_iid() {
		return loc_iid;
	}

	public void setLoc_iid(String loc_iid) {
		this.loc_iid = loc_iid;
	}

	public String getSed_iid() {
		return sed_iid;
	}

	public void setSed_iid(String sed_iid) {
		this.sed_iid = sed_iid;
	}

	public String getCur_vdescripcion() {
		return cur_vdescripcion;
	}

	public void setCur_vdescripcion(String cur_vdescripcion) {
		this.cur_vdescripcion = cur_vdescripcion;
	}

	public String getCur_bestado() {
		return cur_bestado;
	}

	public void setCur_bestado(String cur_bestado) {
		this.cur_bestado = cur_bestado;
	}

	public String getTipcur_iid() {
		return tipcur_iid;
	}

	public void setTipcur_iid(String tipcur_iid) {
		this.tipcur_iid = tipcur_iid;
	}
	
}
