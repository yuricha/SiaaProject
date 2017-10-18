package pe.infounsa.siaa.rest.controller.response;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm
{
	private Integer ideUsu;
	private Integer nroDni;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fchNac;
	
	public Integer getIdeUsu()
	{
		return ideUsu;
	}
	public void setIdeUsu(Integer ideUsu)
	{
		this.ideUsu = ideUsu;
	}
	public Integer getNroDni()
	{
		return nroDni;
	}
	public void setNroDni(Integer nroDni)
	{
		this.nroDni = nroDni;
	}
	public Date getFchNac()
	{
		return fchNac;
	}
	public void setFchNac(Date fchNac)
	{
		this.fchNac = fchNac;
	}	
}