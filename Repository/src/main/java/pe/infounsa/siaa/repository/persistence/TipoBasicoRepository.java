package pe.infounsa.siaa.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.infounsa.siaa.domain.persistence.TipoBasico;

public interface TipoBasicoRepository extends JpaRepository<TipoBasico, Integer>{
	
	//-------------------------------------- CRUD --------------------------------------
	@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.iid=?1")
	public TipoBasico getTipoBasico(Integer codTipoBasico);

	@Query("select tb FROM TipoBasico tb WHERE tb.beliminado=false")
	public List<TipoBasico> listTipoBasico();

	@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.bhabilitado=true")
	public List<TipoBasico> listTipoBasicoActivos();
	
	@Modifying
	@Query("UPDATE TipoBasico tb Set tb.beliminado=true, tb.dfechaeliminacion=?1, tb.vusuarioeliminacion=?2, tb.vip=?3 WHERE tb.iid=?4")
	public void deleteTipoBasico(Date fechaElimina, String usuarioElimina, String ip,Integer codTipoBasico);
	
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vcodigo=?1 AND tb.iidpadre=?2")
		public TipoBasico getTipoBasicoByCodigo(String codigo, Integer codPadre);
		
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vnombre=?1 AND tb.iidpadre=?2")
		public TipoBasico getTipoBasicoByNombre(String nombre, Integer codPadre);
		
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vabreviatura=?1 AND tb.iidpadre=?2")
		public TipoBasico getTipoBasicoByAbreviatura(String abreviatura, Integer codPadre);
		
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vcodigo=?1")
		public TipoBasico getTipoBasicoByCodigo(String codigo);
		
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vnombre=?1")
		public TipoBasico getTipoBasicoByNombre(String nombre);
		
		@Query("FROM TipoBasico tb WHERE tb.beliminado=false AND tb.vabreviatura=?1")
		public TipoBasico getTipoBasicoByAbreviatura(String abreviatura);
	
	//------------------------------------------ PAGINADORES -----------------------------------------------
	@Query(value="SELECT tb.* FROM tipo_basico tb WHERE tb.tipbas_beliminado=false ORDER BY tb.tipbas_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<TipoBasico> listTipoBasicoPaginado(Integer desde, Integer cantidadLimite);
		
	@Query(value="SELECT tb.* FROM tipo_basico tb WHERE tb.tipbas_beliminado=false AND tb.tipbas_bhabilitado=true ORDER BY t.tipbas_iid DESC LIMIT ?1 OFFSET ?2",nativeQuery=true)
	public List<TipoBasico> listTipoBasicoActivosPaginado(Integer desde, Integer cantidadLimite);

}
