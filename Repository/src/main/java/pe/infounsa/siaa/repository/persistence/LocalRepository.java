package pe.infounsa.siaa.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.infounsa.siaa.domain.persistence.Local;

public interface LocalRepository extends JpaRepository<Local, Integer>{
	
	//-------------------------------------- CRUD --------------------------------------	
	@Query("FROM Local l WHERE l.beliminado=false AND l.iid=?1")
	public Local getLocal(Integer codLocal);
	
	@Query("FROM Local l WHERE l.beliminado=false")
	public List<Local> listLocal();
	
	@Query("FROM Local l WHERE l.beliminado=false AND l.bhabilitado=true")
	public List<Local> listLocalActivos();
	
	@Modifying
	@Query("UPDATE Local l Set l.beliminado=true, l.dfechaeliminacion=?1, l.vusuarioeliminacion=?2, l.vip=?3 WHERE l.iid=?4")
	public void deleteLocal(Date fechaElimina, String usuarioElimina, String ip,Integer codTipoBasico);

		@Query("FROM Local l WHERE l.beliminado=false AND l.vnombre=?1")
		public Local getLocalByNombre(String nombre);
		
	//------------------------------------------ PAGINADORES -----------------------------------------------
	@Query(value="SELECT l.* FROM local l WHERE l.loc_beliminado=false ORDER BY l.loc_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<Local> listLocalPaginado(Integer desde, Integer cantidadLimite);
		
	@Query(value="SELECT l.* FROM local l WHERE l.loc_beliminado=false AND l.loc_bhabilitado=true ORDER BY l.loc_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<Local> listLocalActivosPaginado(Integer desde, Integer cantidadLimite);
	
}
