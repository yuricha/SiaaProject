package pe.infounsa.siaa.dataaccess;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.InstructorDTO;

public interface InstructorDao {
	
	public InstructorDTO saveInstructor(InstructorDTO instructorDTO);
	public InstructorDTO editInstructor(InstructorDTO instructorDTO);
	public InstructorDTO getInstructor(Integer codInstructor);
	public void deleteInstructor(Integer codInstructor);
	public List<InstructorDTO> listInstructor();
	public List<InstructorDTO> listInstructorActivo();

}
