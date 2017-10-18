package pe.infounsa.siaa.rest.controller.mantenimiento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;
import pe.infounsa.siaa.business.config.BusinessConfiguration;
import pe.infounsa.siaa.business.mantenimiento.GestionarTipoBasicoBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;
import pe.infounsa.siaa.dataaccess.config.DataAccessConfiguration;
import pe.infounsa.siaa.repository.config.RepositoryConfiguration;
import pe.infounsa.siaa.rest.controller.config.RestControllerConfiguration;
import pe.infounsa.siaa.rest.controller.config.RestServicesConfiguration;
import pe.infounsa.siaa.rest.controller.mantenimiento.validator.TipoBasicoValidator;
import pe.infounsa.siaa.rest.controller.response.DTOResponse;
import pe.infounsa.siaa.rest.controller.response.ListDTOResponse;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestServicesConfiguration.class,
        RestControllerConfiguration.class,
        BusinessConfiguration.class,
        DataAccessConfiguration.class,
        RepositoryConfiguration.class})
public class GestionarTipoBasicoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GestionarTipoBasicoBusiness gestionarTipoBasicoBusiness;

    @Mock
    private ListDTOResponse<TipoBasicoDTO> listDTOResponse;

    @Mock
    private DTOResponse<TipoBasicoDTO> dtoResponse;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private TipoBasicoValidator tipoBasicoValidator;

    @Mock
    private MessageSource messageSource;


    @InjectMocks
    private GestionarTipoBasicoController gestionarTipoBasicoController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(gestionarTipoBasicoController)
                .build();
    }


    @Test
    public void testGetTiposBasicosByIdSuccess() throws Exception {

        TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
        tipoBasicoDTO.setIid(1);
        tipoBasicoDTO.setVtipo("tipo");
        tipoBasicoDTO.setVcodigo("codigo");
        tipoBasicoDTO.setVobservacion("observacion");
        tipoBasicoDTO.setVnombre("nombre");
        tipoBasicoDTO.setVabreviatura("abreviatura");
        tipoBasicoDTO.setBhabilitado(true);

        when(gestionarTipoBasicoBusiness.obtenerTipoBasico(1)).thenReturn(tipoBasicoDTO);

        mockMvc.perform(get("/tipobasicos/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetTiposBasicosByIdFail404NotFound() throws Exception {

        when(gestionarTipoBasicoBusiness.obtenerTipoBasico(1)).thenReturn(null);

        mockMvc.perform(get("/users/{id}", 1))
                .andExpect(status().isNotFound());
    }


}