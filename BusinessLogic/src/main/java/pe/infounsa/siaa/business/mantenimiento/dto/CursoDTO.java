package pe.infounsa.siaa.business.mantenimiento.dto;

public class CursoDTO {
	
	private String cur_vcodigo;//id
	private String cur_vnombre;	
	private String cur_vdescripcion;
	private String cur_bestado;
	
	private LocalDTO dtoLocal;
	private SedeDTO dtoSede;
	private TipoBasicoDTO dtoTipoBasico;//tipcur_iid
	
	public String getCur_vcodigo() {
		return cur_vcodigo;
	}
	public void setCur_vcodigo(String cur_vcodigo) {
		this.cur_vcodigo = cur_vcodigo;
	}
	public String getCur_vnombre() {
		return cur_vnombre;
	}
	public void setCur_vnombre(String cur_vnombre) {
		this.cur_vnombre = cur_vnombre;
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
	public LocalDTO getDtoLocal() {
		return dtoLocal;
	}
	public void setDtoLocal(LocalDTO dtoLocal) {
		this.dtoLocal = dtoLocal;
	}
	public SedeDTO getDtoSede() {
		return dtoSede;
	}
	public void setDtoSede(SedeDTO dtoSede) {
		this.dtoSede = dtoSede;
	}
	public TipoBasicoDTO getDtoTipoBasico() {
		return dtoTipoBasico;
	}
	public void setDtoTipoBasico(TipoBasicoDTO dtoTipoBasico) {
		this.dtoTipoBasico = dtoTipoBasico;
	}

}
