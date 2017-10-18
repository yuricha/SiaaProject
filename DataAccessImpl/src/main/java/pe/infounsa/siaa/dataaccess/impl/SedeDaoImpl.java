package pe.infounsa.siaa.dataaccess.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.infounsa.siaa.business.mantenimiento.dto.SedeAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;
import pe.infounsa.siaa.dataaccess.SedeDao;
import pe.infounsa.siaa.domain.persistence.Sede;
import pe.infounsa.siaa.repository.persistence.SedeRepository;

@Component
public class SedeDaoImpl implements SedeDao {

    @Autowired
    private SedeRepository sedeRepository;

    @Transactional
    @Override
    public SedeDTO saveSede(SedeDTO sedeDTO, String ip) {
        // TODO Auto-generated method stub

        Sede sede = new Sede();
        BeanUtils.copyProperties(sedeDTO, sede);

        //Fecha creacion
        sede.setDfechacreacion(new Date());

        //Usuario creaacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            sede.setVusuariocreacion(auth.getName());

        //Marcas
        sede.setBeliminado((boolean) false);

        //Ip
        sede.setVip(ip);

        sede = sedeRepository.save(sede);
        sedeDTO.setIid(sede.getIid());

        return sedeDTO;
    }

    @Transactional
    @Override
    public SedeDTO editSede(SedeDTO sedeDTO, String ip) {
        // TODO Auto-generated method stub

        Sede sede = new Sede();
        BeanUtils.copyProperties(sedeDTO, sede);

        //Datos anteriores
        SedeAdminDTO sedeAnteriorDTO = getSedeAdminMini(sedeDTO.getIid());
        sede.setDfechacreacion(sedeAnteriorDTO.getDfechacreacion());
        sede.setVusuariocreacion(sedeAnteriorDTO.getVusuariocreacion());

        //Fecha modificacion
        sede.setDfechamodificacion(new Date());

        //Usuario modificacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            sede.setVusuariomodificacion(auth.getName());

        //Marcas
        sede.setBeliminado((boolean) false);

        //Ip
        sede.setVip(ip);

        sedeRepository.save(sede);

        return sedeDTO;
    }

    @Override
    public SedeDTO getSede(Integer codSede) {
        // TODO Auto-generated method stub

        Sede sede = sedeRepository.getSede(codSede);
        if (sede == null)
            return null;

        SedeDTO sedeDTO = new SedeDTO();
        BeanUtils.copyProperties(sede, sedeDTO);

        return sedeDTO;
    }

    @Override
    public SedeAdminDTO getSedeAdminMini(Integer codSede) {
        // TODO Auto-generated method stub

        Sede sede = sedeRepository.getSede(codSede);
        if (sede == null)
            return null;

        SedeAdminDTO sedeAdminDTO = new SedeAdminDTO();
        BeanUtils.copyProperties(sede, sedeAdminDTO);

        return sedeAdminDTO;
    }

    @Transactional
    @Override
    public void deleteSede(Integer codSede, String ip) {
        // TODO Auto-generated method stub

        String codUsuario = null;

        //Usuario eliminacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            codUsuario = (auth.getName());

        sedeRepository.deleteSede(new Date(), codUsuario, ip, codSede);
    }

    @Override
    public List<SedeDTO> listSede() {
        // TODO Auto-generated method stub

        List<Sede> listSede = sedeRepository.listSede();

        List<SedeDTO> listaSedeDTO = new ArrayList<>();
        if (listSede == null || listSede.size() == 0)
            return listaSedeDTO;

        for (Sede sede : listSede) {
            SedeDTO sedeDTO = new SedeDTO();
            BeanUtils.copyProperties(sede, sedeDTO);

            listaSedeDTO.add(sedeDTO);
        }

        return listaSedeDTO;
    }

    @Override
    public List<SedeDTO> listSedeActivos() {

        List<Sede> listSede = sedeRepository.listSedeActivos();

        List<SedeDTO> listaSedeDTO = new ArrayList<>();

        if (listSede == null || listSede.size() == 0)
            return listaSedeDTO;

        for (Sede sede : listSede) {
            SedeDTO sedeDTO = new SedeDTO();
            BeanUtils.copyProperties(sede, sedeDTO);

            listaSedeDTO.add(sedeDTO);
        }

        return listaSedeDTO;
    }

    @Override
    public SedeDTO getSedeByNombre(String nombre) {
        // TODO Auto-generated method stub

        Sede sede = sedeRepository.getSedeByNombre(nombre);
        if (sede == null)
            return null;

        SedeDTO sedeDTO = new SedeDTO();
        BeanUtils.copyProperties(sede, sedeDTO);

        return sedeDTO;
    }

    //---------------------------------------------------- PAGINADORES -------------------------------------------------
    @Override
    public List<SedeDTO> listSedePaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<Sede> listSede = sedeRepository.listSedePaginado(page, limit);
        if (listSede == null || listSede.size() == 0)
            return null;

        List<SedeDTO> listaSedeDTO = new ArrayList<SedeDTO>();
        for (Sede sede : listSede) {

            SedeDTO sedeDTO = new SedeDTO();
            BeanUtils.copyProperties(sede, sedeDTO);

            listaSedeDTO.add(sedeDTO);
        }

        return listaSedeDTO;
    }

    @Override
    public List<SedeDTO> listSedeActivosPaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<Sede> listSede = sedeRepository.listSedeActivosPaginado(page, limit);
        //List<TipoBasico> listTipoBasico = null;
        if (listSede == null || listSede.size() == 0)
            return null;

        List<SedeDTO> listaSedeDto = new ArrayList<SedeDTO>();
        for (Sede sede : listSede) {

            SedeDTO sedeDTO = new SedeDTO();
            BeanUtils.copyProperties(sede, sedeDTO);

            listaSedeDto.add(sedeDTO);
        }

        return listaSedeDto;

    }

}
