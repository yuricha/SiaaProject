package pe.infounsa.siaa.business.mantenimiento.dto;

public class TipoBasicoDTO {

    private int iid;
    private String vcodigo;
    private String vtipo;
    private String vnombre;
    private String vabreviatura;
    private String vobservacion;
    private Boolean bhabilitado;
    private Integer iidpadre;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getVcodigo() {
        return vcodigo;
    }

    public void setVcodigo(String vcodigo) {
        this.vcodigo = vcodigo;
    }

    public String getVtipo() {
        return vtipo;
    }

    public void setVtipo(String vtipo) {
        this.vtipo = vtipo;
    }

    public String getVnombre() {
        return vnombre;
    }

    public void setVnombre(String vnombre) {
        this.vnombre = vnombre;
    }

    public String getVabreviatura() {
        return vabreviatura;
    }

    public void setVabreviatura(String vabreviatura) {
        this.vabreviatura = vabreviatura;
    }

    public String getVobservacion() {
        return vobservacion;
    }

    public void setVobservacion(String vobservacion) {
        this.vobservacion = vobservacion;
    }

    public Boolean getBhabilitado() {
        return bhabilitado;
    }

    public void setBhabilitado(Boolean bhabilitado) {
        this.bhabilitado = bhabilitado;
    }

    public Integer getIidpadre() {
        return iidpadre;
    }

    public void setIidpadre(Integer iidpadre) {
        this.iidpadre = iidpadre;
    }

}
