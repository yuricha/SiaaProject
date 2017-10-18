package pe.infounsa.siaa.dataaccess;

import pe.infounsa.siaa.business.mantenimiento.dto.PersonaDTO;

public interface PersonaDao {
	
	public PersonaDTO savePersona(PersonaDTO personaDTO);
	public PersonaDTO editPersona(PersonaDTO personaDTO);
	public PersonaDTO getPersona(Integer codPersona);
	public void deletePersona(Integer codPersona);

}
