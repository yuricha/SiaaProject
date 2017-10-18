package pe.infounsa.siaa.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.infounsa.siaa.domain.persistence.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
//	//-------------------------------------- CRUD --------------------------------------		
//		@Query("FROM Persona p WHERE p.beliminado=false AND p.iid=?1")
//		public Persona getPersona(Integer codPersona);
//		
//		@Query("FROM Persona p WHERE p.beliminado=false")
//		public List<Persona> listPersona();
//		
//		@Query("FROM Persona p WHERE p.beliminado=false AND p.bhabilitado=true")
//		public List<Persona> listPersonaActivos();
//		
//		@Modifying
//		@Query("UPDATE Persona p Set p.beliminado=true, p.dfechaeliminacion=?1, p.vusuarioeliminacion=?2, p.vip=?3 WHERE p.iid=?4")
//		public void deletePersona(Date fechaElimina, String usuarioElimina, String ip,Integer codPersona);

}
