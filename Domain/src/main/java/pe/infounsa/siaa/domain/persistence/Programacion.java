package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programacion")
public class Programacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pro_iid;
	
	private Date pro_dfecha;
	private Boolean pro_bhabilitarmatricula;
	private Boolean pro_bhabilitarintercambio;
	private String pro_vobservacion;
	private Integer loc_iid;
	private Integer sed_iid;
	private String pro_vestado;
	private Boolean pro_bestado;
	private String pro_vcodigoantiguo;
	
	public Programacion(){
		
	}

	public int getPro_iid() {
		return pro_iid;
	}

	public void setPro_iid(int pro_iid) {
		this.pro_iid = pro_iid;
	}

	public Date getPro_dfecha() {
		return pro_dfecha;
	}

	public void setPro_dfecha(Date pro_dfecha) {
		this.pro_dfecha = pro_dfecha;
	}

	public Boolean getPro_bhabilitarmatricula() {
		return pro_bhabilitarmatricula;
	}

	public void setPro_bhabilitarmatricula(Boolean pro_bhabilitarmatricula) {
		this.pro_bhabilitarmatricula = pro_bhabilitarmatricula;
	}

	public Boolean getPro_bhabilitarintercambio() {
		return pro_bhabilitarintercambio;
	}

	public void setPro_bhabilitarintercambio(Boolean pro_bhabilitarintercambio) {
		this.pro_bhabilitarintercambio = pro_bhabilitarintercambio;
	}

	public String getPro_vobservacion() {
		return pro_vobservacion;
	}

	public void setPro_vobservacion(String pro_vobservacion) {
		this.pro_vobservacion = pro_vobservacion;
	}

	public Integer getLoc_iid() {
		return loc_iid;
	}

	public void setLoc_iid(Integer loc_iid) {
		this.loc_iid = loc_iid;
	}

	public Integer getSed_iid() {
		return sed_iid;
	}

	public void setSed_iid(Integer sed_iid) {
		this.sed_iid = sed_iid;
	}

	public String getPro_vestado() {
		return pro_vestado;
	}

	public void setPro_vestado(String pro_vestado) {
		this.pro_vestado = pro_vestado;
	}

	public Boolean getPro_bestado() {
		return pro_bestado;
	}

	public void setPro_bestado(Boolean pro_bestado) {
		this.pro_bestado = pro_bestado;
	}

	public String getPro_vcodigoantiguo() {
		return pro_vcodigoantiguo;
	}

	public void setPro_vcodigoantiguo(String pro_vcodigoantiguo) {
		this.pro_vcodigoantiguo = pro_vcodigoantiguo;
	}

}
