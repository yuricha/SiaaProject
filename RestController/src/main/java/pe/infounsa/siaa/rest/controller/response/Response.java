package pe.infounsa.siaa.rest.controller.response;

/**
 * Created by Yuri on 12/10/2017.
 */

public class Response{

    private String message;
    private int totalRegistros;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

}
