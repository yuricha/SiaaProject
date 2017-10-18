package pe.infounsa.siaa.rest.controller.response;

import org.springframework.stereotype.Component;

/**
 * Created by Yuri on 12/10/2017.
 */
@Component
public class DTOResponse<T> extends Response {
	
    private T dataDto;
    
    public T getDataDto() {
        return dataDto;
    }

    public void setDataDto(T dataDto) {
        this.dataDto = dataDto;
    }
    
}
