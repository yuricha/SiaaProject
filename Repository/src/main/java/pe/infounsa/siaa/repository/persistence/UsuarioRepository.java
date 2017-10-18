package pe.infounsa.siaa.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.infounsa.siaa.domain.persistence.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Modifying
	@Query("update Usuario u set u.activo = ?2 where u.codigo = ?1")
	public void changeStateUser(Integer codigo,Integer estado);
	
	@Query("from Usuario u where u.usuario = ?1")
	public Usuario getUsuariobyUser(String user);
	
	
	@Query("FROM Usuario u WHERE u.codigo = ?1")
	public Usuario getUsuariobyCodigo(Integer codigoUsuario);
	
	
	@Modifying
	@Query("UPDATE Usuario u SET u.contrasena = ?2 where u.codigo = ?1")
	public void changePasswordUser(Integer codigoUsuario,String password);
	
//	@Modifying
//	@Query("UPDATE Usuario u SET u.permisosAccesoSistema.codigo = ?2 where u.codigo = ?1")
//	public Integer actualizaPermisosAccesoSistema(Integer codigoUsuario,Integer codigoPermisosAccesoSistema);
	
}
