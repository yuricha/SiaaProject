package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conferencia")
public class Conferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tipbas_iid;
	
	private String con_vcodigosecundario;
	private String con_vcodigoauto;
	private String con_vtema;
	private Integer con_icapacidad;
	private Integer con_isesion;
	private Date con_dfechainicio;
	private Date con_dfechafin;
	private Integer con_ncostocertificado;
	private String con_vhorario;
	private Integer sed_iid;
	private Integer loc_iid;
	private String doc_vruta;
	private Integer con_icantidadhora;
	private Integer con_ireservado;
	private Integer con_icupolibre;
	private String con_vtemario;
	private String con_vobservacion;
	private Boolean con_bestado;
	
	public Conferencia(){
		
	}

	public int getTipbas_iid() {
		return tipbas_iid;
	}

	public void setTipbas_iid(int tipbas_iid) {
		this.tipbas_iid = tipbas_iid;
	}

	public String getCon_vcodigosecundario() {
		return con_vcodigosecundario;
	}

	public void setCon_vcodigosecundario(String con_vcodigosecundario) {
		this.con_vcodigosecundario = con_vcodigosecundario;
	}

	public String getCon_vcodigoauto() {
		return con_vcodigoauto;
	}

	public void setCon_vcodigoauto(String con_vcodigoauto) {
		this.con_vcodigoauto = con_vcodigoauto;
	}

	public String getCon_vtema() {
		return con_vtema;
	}

	public void setCon_vtema(String con_vtema) {
		this.con_vtema = con_vtema;
	}

	public Integer getCon_icapacidad() {
		return con_icapacidad;
	}

	public void setCon_icapacidad(Integer con_icapacidad) {
		this.con_icapacidad = con_icapacidad;
	}

	public Integer getCon_isesion() {
		return con_isesion;
	}

	public void setCon_isesion(Integer con_isesion) {
		this.con_isesion = con_isesion;
	}

	public Date getCon_dfechainicio() {
		return con_dfechainicio;
	}

	public void setCon_dfechainicio(Date con_dfechainicio) {
		this.con_dfechainicio = con_dfechainicio;
	}

	public Date getCon_dfechafin() {
		return con_dfechafin;
	}

	public void setCon_dfechafin(Date con_dfechafin) {
		this.con_dfechafin = con_dfechafin;
	}

	public Integer getCon_ncostocertificado() {
		return con_ncostocertificado;
	}

	public void setCon_ncostocertificado(Integer con_ncostocertificado) {
		this.con_ncostocertificado = con_ncostocertificado;
	}

	public String getCon_vhorario() {
		return con_vhorario;
	}

	public void setCon_vhorario(String con_vhorario) {
		this.con_vhorario = con_vhorario;
	}

	public Integer getSed_iid() {
		return sed_iid;
	}

	public void setSed_iid(Integer sed_iid) {
		this.sed_iid = sed_iid;
	}

	public Integer getLoc_iid() {
		return loc_iid;
	}

	public void setLoc_iid(Integer loc_iid) {
		this.loc_iid = loc_iid;
	}

	public String getDoc_vruta() {
		return doc_vruta;
	}

	public void setDoc_vruta(String doc_vruta) {
		this.doc_vruta = doc_vruta;
	}

	public Integer getCon_icantidadhora() {
		return con_icantidadhora;
	}

	public void setCon_icantidadhora(Integer con_icantidadhora) {
		this.con_icantidadhora = con_icantidadhora;
	}

	public Integer getCon_ireservado() {
		return con_ireservado;
	}

	public void setCon_ireservado(Integer con_ireservado) {
		this.con_ireservado = con_ireservado;
	}

	public Integer getCon_icupolibre() {
		return con_icupolibre;
	}

	public void setCon_icupolibre(Integer con_icupolibre) {
		this.con_icupolibre = con_icupolibre;
	}

	public String getCon_vtemario() {
		return con_vtemario;
	}

	public void setCon_vtemario(String con_vtemario) {
		this.con_vtemario = con_vtemario;
	}

	public String getCon_vobservacion() {
		return con_vobservacion;
	}

	public void setCon_vobservacion(String con_vobservacion) {
		this.con_vobservacion = con_vobservacion;
	}

	public Boolean getCon_bestado() {
		return con_bestado;
	}

	public void setCon_bestado(Boolean con_bestado) {
		this.con_bestado = con_bestado;
	}	
	
}
