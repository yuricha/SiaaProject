package pe.infounsa.siaa.rest.controller.response;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Yuri on 12/10/2017.
 */
@Component
public class ListDTOResponse<T> extends Response {
	
    List<T> dataDto;

    public List<T> getDataDto() {
        return dataDto;
    }

    public void setDataDto(List<T> dataDto) {
        this.dataDto = dataDto;
    }
}
