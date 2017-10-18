package pe.infounsa.siaa.business.seguridad.dto;

public class GruposDto {
	 
	private int codigo;
	private String nombre;
	private String descripcion;
//	private boolean habilidato;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public boolean isHabilidato() {
//		return habilidato;
//	}
//	public void setHabilidato(boolean habilidato) {
//		this.habilidato = habilidato;
//	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
