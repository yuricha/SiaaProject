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

import pe.infounsa.siaa.business.mantenimiento.dto.LocalAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;
import pe.infounsa.siaa.dataaccess.LocalDao;
import pe.infounsa.siaa.dataaccess.SedeDao;
import pe.infounsa.siaa.domain.persistence.Local;
import pe.infounsa.siaa.repository.persistence.LocalRepository;

@Component
public class LocalDaoImpl implements LocalDao {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private SedeDao sedeDao;

    @Transactional
    @Override
    public LocalDTO saveLocal(LocalDTO localDTO, String ip) {
        // TODO Auto-generated method stub

        Local local = new Local();
        BeanUtils.copyProperties(localDTO, local);

        if (localDTO.getSede() != null)
            local.setIidsede(localDTO.getSede().getIid());

        //Fecha creacion
        local.setDfechacreacion(new Date());

        //Usuario creaacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            local.setVusuariocreacion(auth.getName());

        //Marcas
        local.setBeliminado((boolean) false);

        //Ip
        local.setVip(ip);

        local = localRepository.save(local);
        localDTO.setIid(local.getIid());

        return localDTO;
    }

    @Transactional
    @Override
    public LocalDTO editLocal(LocalDTO localDTO, String ip) {
        // TODO Auto-generated method stub

        Local local = new Local();
        BeanUtils.copyProperties(localDTO, local);

        //Datos anteriores
        LocalAdminDTO localAnteriorDTO = getLocalAdminMini(localDTO.getIid());
        local.setDfechacreacion(localAnteriorDTO.getDfechacreacion());
        local.setVusuariocreacion(localAnteriorDTO.getVusuariocreacion());

        if (localDTO.getSede() != null)
            local.setIidsede(localDTO.getSede().getIid());

        //Fecha modificacion
        local.setDfechamodificacion(new Date());

        //Usuario modificacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            local.setVusuariomodificacion(auth.getName());

        //Marcas
        local.setBeliminado((boolean) false);

        //Ip
        local.setVip(ip);

        localRepository.save(local);

        return localDTO;

    }

    @Override
    public LocalDTO getLocal(Integer codLocal) {
        // TODO Auto-generated method stub
        Local local = localRepository.getLocal(codLocal);
        if (local == null)
            return null;

        LocalDTO localDTO = new LocalDTO();
        BeanUtils.copyProperties(local, localDTO);

        if (local.getIidsede() != null)
            localDTO.setSede(sedeDao.getSede(local.getIidsede()));

        return localDTO;
    }

    @Override
    public LocalAdminDTO getLocalAdminMini(Integer codLocal) {
        // TODO Auto-generated method stub

        Local local = localRepository.getLocal(codLocal);
        if (local == null)
            return null;

        LocalAdminDTO localAdminDTO = new LocalAdminDTO();
        BeanUtils.copyProperties(local, localAdminDTO);

        return localAdminDTO;

    }

    @Transactional
    @Override
    public void deleteLocal(Integer codLocal, String ip) {
        // TODO Auto-generated method stub

        String codUsuario = null;

        //Usuario eliminacion
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            codUsuario = (auth.getName());

        localRepository.deleteLocal(new Date(), codUsuario, ip, codLocal);
    }

    @Override
    public List<LocalDTO> listLocal() {
        // TODO Auto-generated method stub

        List<Local> listLocal = localRepository.listLocal();
        List<LocalDTO> listaLocalDTO = new ArrayList<>();
        if (listLocal == null || listLocal.size() == 0)
            return listaLocalDTO;

        for (Local local : listLocal) {

            LocalDTO localDTO = new LocalDTO();
            BeanUtils.copyProperties(local, localDTO);

            listaLocalDTO.add(localDTO);
        }

        return listaLocalDTO;
    }

    @Override
    public List<LocalDTO> listLocalActivos() {
        // TODO Auto-generated method stub

        List<Local> listLocal = localRepository.listLocalActivos();

        List<LocalDTO> listaLocalDTO = new ArrayList<>();

        if (listLocal == null || listLocal.size() == 0)
            return listaLocalDTO;

        for (Local local : listLocal) {

            LocalDTO localDTO = new LocalDTO();
            BeanUtils.copyProperties(local, localDTO);

            listaLocalDTO.add(localDTO);
        }

        return listaLocalDTO;
    }

    @Override
    public LocalDTO getLocalByNombre(String nombre) {
        // TODO Auto-generated method stub

        Local local = localRepository.getLocalByNombre(nombre);
        if (local == null)
            return null;

        LocalDTO localDTO = new LocalDTO();
        BeanUtils.copyProperties(local, localDTO);

        if (local.getIidsede() != null)
            localDTO.setSede(sedeDao.getSede(local.getIidsede()));

        return localDTO;
    }

    //---------------------------------------------------- PAGINADORES -------------------------------------------------
    @Override
    public List<LocalDTO> listLocalPaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<Local> listLocal = localRepository.listLocalPaginado(page, limit);
        if (listLocal == null || listLocal.size() == 0)
            return null;

        List<LocalDTO> listaLocalDTO = new ArrayList<LocalDTO>();
        for (Local local : listLocal) {

            LocalDTO localDTO = new LocalDTO();
            BeanUtils.copyProperties(local, localDTO);

            listaLocalDTO.add(localDTO);
        }

        return listaLocalDTO;
    }

    @Override
    public List<LocalDTO> listLocalActivosPaginado(Integer page, Integer limit) {
        // TODO Auto-generated method stub

        List<Local> listLocal = localRepository.listLocalActivosPaginado(page, limit);
        if (listLocal == null || listLocal.size() == 0)
            return null;

        List<LocalDTO> listaLocalDTO = new ArrayList<LocalDTO>();
        for (Local local : listLocal) {

            LocalDTO localDTO = new LocalDTO();
            BeanUtils.copyProperties(local, localDTO);

            listaLocalDTO.add(localDTO);
        }

        return listaLocalDTO;

    }

}
