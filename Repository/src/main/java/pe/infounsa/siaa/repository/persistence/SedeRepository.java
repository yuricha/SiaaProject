package pe.infounsa.siaa.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.infounsa.siaa.domain.persistence.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer>{
	
	//-------------------------------------- CRUD --------------------------------------	
	@Query("FROM Sede s WHERE s.beliminado=false AND s.iid=?1")
	public Sede getSede(Integer codSede);
	
	@Query("FROM Sede s WHERE s.beliminado=false")
	public List<Sede> listSede();
	
	@Query("FROM Sede s WHERE s.beliminado=false AND s.bhabilitado=true")
	public List<Sede> listSedeActivos();
	
	@Modifying
	@Query("UPDATE Sede s Set s.beliminado=true, s.dfechaeliminacion=?1, s.vusuarioeliminacion=?2, s.vip=?3 WHERE s.iid=?4")
	public void deleteSede(Date fechaElimina, String usuarioElimina, String ip,Integer codTipoBasico);
	
		@Query("FROM Sede s WHERE s.beliminado=false AND s.vnombre=?1")
		public Sede getSedeByNombre(String nombre);
	
	//--------------------------------------------------------------- PAGINADORES --------------------------------------------------------------------
	@Query(value="SELECT s.* FROM sede s WHERE s.sed_beliminado=false ORDER BY s.sed_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<Sede> listSedePaginado(Integer desde, Integer cantidadLimite);
	
	@Query(value="SELECT s.* FROM sede s WHERE s.sed_beliminado=false AND s.sed_bhabilitado=true ORDER BY s.sed_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<Sede> listSedeActivosPaginado(Integer desde, Integer cantidadLimite);

}
