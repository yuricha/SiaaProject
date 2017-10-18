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

import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;
import pe.infounsa.siaa.dataaccess.TipoBasicoDao;
import pe.infounsa.siaa.domain.persistence.TipoBasico;
import pe.infounsa.siaa.repository.persistence.TipoBasicoRepository;

@Component
public class TipoBasicoDaoImpl implements TipoBasicoDao {

    @Autowired
    private TipoBasicoRepository tipoBasicoRepository;

    //private Paginador paginador = new Paginador();

    @Transactional
    @Override
    public TipoBasicoDTO saveTipoBasico(TipoBasicoDTO tipoBasicoDTO, String ip) {
        // TODO Auto-generated method stub

        TipoBasico tipoBasico = new TipoBasico();
        BeanUtils.copyProperties(tipoBasicoDTO, tipoBasico);

        //Fecha creacion
        tipoBasico.setDfechacreacion(new Date());

        //Usuario creaacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            tipoBasico.setVusuariocreacion(auth.getName());

        //Marcas
        tipoBasico.setBeliminado((boolean) false);

        //Ip
        tipoBasico.setVip(ip);

        tipoBasico = tipoBasicoRepository.save(tipoBasico);
        tipoBasicoDTO.setIid(tipoBasico.getIid());

        return tipoBasicoDTO;
    }

    @Transactional
    @Override
    public TipoBasicoDTO editTipoBasico(TipoBasicoDTO tipoBasicoDTO, String ip) {
        // TODO Auto-generated method stub

        TipoBasico tipoBasico = new TipoBasico();
        BeanUtils.copyProperties(tipoBasicoDTO, tipoBasico);

        //Datos anteriores
        TipoBasicoAdminDTO tipoBasicoAnteriorDTO = getTipoBasicoAdminMini(tipoBasicoDTO.getIid());
        tipoBasico.setDfechacreacion(tipoBasicoAnteriorDTO.getDfechacreacion());
        tipoBasico.setVusuariocreacion(tipoBasicoAnteriorDTO.getVusuariocreacion());

        //Fecha modificacion
        tipoBasico.setDfechamodificacion(new Date());

        //Usuario modificacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            tipoBasico.setVusuariomodificacion(auth.getName());

        //Marcas
        tipoBasico.setBeliminado((boolean) false);

        //Ip
        tipoBasico.setVip(ip);

        tipoBasicoRepository.save(tipoBasico);

        return tipoBasicoDTO;
    }

    @Override
    public TipoBasicoDTO getTipoBasico(Integer codTipoBasico) {

        TipoBasico tipoBasico = tipoBasicoRepository.getTipoBasico(codTipoBasico);
        if (tipoBasico == null)
            return null;

        TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
        BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

        return tipoBasicoDTO;
    }

    @Override
    public TipoBasicoAdminDTO getTipoBasicoAdminMini(Integer codTipoBasico) {

        TipoBasico tipoBasico = tipoBasicoRepository.getTipoBasico(codTipoBasico);
        if (tipoBasico == null)
            return null;

        TipoBasicoAdminDTO tipoBasicoAdminDTO = new TipoBasicoAdminDTO();
        BeanUtils.copyProperties(tipoBasico, tipoBasicoAdminDTO);

        return tipoBasicoAdminDTO;
    }

    @Transactional
    @Override
    public void deleteTipoBasico(Integer codTipoBasico, String ip) {
        // TODO Auto-generated method stub

        String codUsuario = null;

        //Usuario eliminacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            codUsuario = (auth.getName());

        tipoBasicoRepository.deleteTipoBasico(new Date(), codUsuario, ip, codTipoBasico);

    }

    @Override
    public List<TipoBasicoDTO> listTipoBasico() {
        // TODO Auto-generated method stub

        List<TipoBasico> listTipoBasico = tipoBasicoRepository.listTipoBasico();

        List<TipoBasicoDTO> listaTipoBasicoDto = new ArrayList<>();

        if (listTipoBasico == null || listTipoBasico.size() == 0)
            return listaTipoBasicoDto;

        for (TipoBasico tipoBasico : listTipoBasico) {

            TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
            BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

            listaTipoBasicoDto.add(tipoBasicoDTO);
        }

        return listaTipoBasicoDto;
    }

    @Override
    public List<TipoBasicoDTO> listTipoBasicoActivos() {
        // TODO Auto-generated method stub

        List<TipoBasico> listTipoBasico = tipoBasicoRepository.listTipoBasicoActivos();

        List<TipoBasicoDTO> listaTipoBasicoDTO = new ArrayList<>();

        if (listTipoBasico == null || listTipoBasico.size() == 0)
            return listaTipoBasicoDTO;

        for (TipoBasico tipoBasico : listTipoBasico) {

            TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
            BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

            listaTipoBasicoDTO.add(tipoBasicoDTO);
        }

        return listaTipoBasicoDTO;

    }

    @Override
    public TipoBasicoDTO getTipoBasicoByCodigo(String codigo, Integer codPadre) {
        // TODO Auto-generated method stub

        TipoBasico tipoBasico;
        if (codPadre == null) {
            tipoBasico = tipoBasicoRepository.getTipoBasicoByCodigo(codigo);
        } else
            tipoBasico = tipoBasicoRepository.getTipoBasicoByCodigo(codigo, codPadre);

        if (tipoBasico == null)
            return null;

        TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
        BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

        return tipoBasicoDTO;
    }

    @Override
    public TipoBasicoDTO getTipoBasicoByNombre(String nombre, Integer codPadre) {
        // TODO Auto-generated method stub

        TipoBasico tipoBasico;
        if (codPadre == null) {
            tipoBasico = tipoBasicoRepository.getTipoBasicoByNombre(nombre);
        } else
            tipoBasico = tipoBasicoRepository.getTipoBasicoByNombre(nombre, codPadre);

        if (tipoBasico == null)
            return null;

        TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
        BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

        return tipoBasicoDTO;
    }

    @Override
    public TipoBasicoDTO getTipoBasicoByAbreviatura(String abreviatura, Integer codPadre) {
        // TODO Auto-generated method stub

        TipoBasico tipoBasico;
        if (codPadre == null) {
            tipoBasico = tipoBasicoRepository.getTipoBasicoByAbreviatura(abreviatura);
        } else
            tipoBasico = tipoBasicoRepository.getTipoBasicoByAbreviatura(abreviatura, codPadre);

        if (tipoBasico == null)
            return null;

        TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
        BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

        return tipoBasicoDTO;
    }

    //---------------------------------------------------- PAGINADORES -------------------------------------------------
    @Override
    public List<TipoBasicoDTO> listTipoBasicoPaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<TipoBasico> listTipoBasico = tipoBasicoRepository.listTipoBasicoPaginado(page, limit);
        if (listTipoBasico == null || listTipoBasico.size() == 0)
            return null;

        List<TipoBasicoDTO> listaTipoBasicoDTO = new ArrayList<TipoBasicoDTO>();
        for (TipoBasico tipoBasico : listTipoBasico) {

            TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
            BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

            listaTipoBasicoDTO.add(tipoBasicoDTO);
        }

        return listaTipoBasicoDTO;
    }

    @Override
    public List<TipoBasicoDTO> listTipoBasicoActivosPaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<TipoBasico> listTipoBasico = tipoBasicoRepository.listTipoBasicoActivosPaginado(page, limit);
        //List<TipoBasico> listTipoBasico = null;
        if (listTipoBasico == null || listTipoBasico.size() == 0)
            return null;

        List<TipoBasicoDTO> listaTipoBasicoDto = new ArrayList<TipoBasicoDTO>();
        for (TipoBasico tipoBasico : listTipoBasico) {

            TipoBasicoDTO tipoBasicoDTO = new TipoBasicoDTO();
            BeanUtils.copyProperties(tipoBasico, tipoBasicoDTO);

            listaTipoBasicoDto.add(tipoBasicoDTO);
        }

        return listaTipoBasicoDto;

    }

}
