/**
 * 
 */
package pe.infounsa.siaa.dataaccess.impl.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.dataaccess.seguridad.UsuarioDao;
import pe.infounsa.siaa.domain.persistence.Usuario;
import pe.infounsa.siaa.repository.persistence.UsuarioRepository;


/**
 * @author Siaa
 *
 */
@Component
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UsuarioAdminDto getUsuarioAdminByName(String username) {

//		List<PerfilDto> rolesUsuario = new ArrayList<PerfilDto>();
		
		Usuario usuario = usuarioRepository.getUsuariobyUser(username);
		
		if(usuario != null){
			
			if(usuario.getActivo() == 1){
				UsuarioAdminDto usuarioDto = new UsuarioAdminDto();
				BeanUtils.copyProperties(usuario, usuarioDto);
				
//				if(usuario.getPerfil() != null){
//					PerfilDto perfilDto = new PerfilDto();
//					BeanUtils.copyProperties(usuario.getPerfil(), perfilDto);
//					usuarioDto.setPerfil(perfilDto);
//				}
				
//				if(usuario.getTrabajador() != null){
//					TrabajadorDto trabajadorDto = new TrabajadorDto();
//					BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//					
//					if(usuario.getTrabajador().getSucursal() != null){
//						SucursalDto sucursalDto = new SucursalDto();
//						BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
//						
//						if(usuario.getTrabajador().getSucursal().getListaPrecio()!=null){
//							ListaPrecioDto listaPrecioDto = new ListaPrecioDto();
//							BeanUtils.copyProperties(usuario.getTrabajador().getSucursal().getListaPrecio(), listaPrecioDto);
//							sucursalDto.setListaPrecio(listaPrecioDto);
//						}
//						
//						trabajadorDto.setSucursal(sucursalDto);
//					}
//					
//					usuarioDto.setTrabajador(trabajadorDto);
//				}
				
				
				return usuarioDto;
				
			}else
				return null;
		}else
			return null;

	}
	
	
	@Transactional
	@Override
	public UsuarioDto saveUsuario(UsuarioAdminDto usuarioDto) {
		
		Usuario nuevoUsuario = new Usuario();
		
		Validate.notNull(usuarioDto);
		
		BeanUtils.copyProperties(usuarioDto, nuevoUsuario);
		nuevoUsuario.setContrasena(nuevoUsuario.getContrasena());
		
//		if(usuarioDto.getPerfil() != null){
//			Perfil perfil = new Perfil();
//			BeanUtils.copyProperties(usuarioDto.getPerfil(), perfil);
//			nuevoUsuario.setPerfil(perfil);
//		}
//		
//		if(usuarioDto.getTrabajador() != null){
//			Trabajador trabajador = new Trabajador();
//			BeanUtils.copyProperties(usuarioDto.getTrabajador(), trabajador);
//			nuevoUsuario.setTrabajador(trabajador);
//		}
		
		nuevoUsuario = usuarioRepository.save(nuevoUsuario);
		
		UsuarioDto usuarioReturn = new UsuarioDto();
		BeanUtils.copyProperties(nuevoUsuario,usuarioReturn);
		
//		if(nuevoUsuario.getPerfil() != null){
//			PerfilDto perfilDto = new PerfilDto();
//			BeanUtils.copyProperties(nuevoUsuario.getPerfil(), perfilDto);
//			usuarioReturn.setPerfil(perfilDto);
//		}
//		
//		if(nuevoUsuario.getTrabajador() != null){
//			TrabajadorDto trabajadorDto = new TrabajadorDto();
//			BeanUtils.copyProperties(nuevoUsuario.getTrabajador(), trabajadorDto);
//			usuarioReturn.setTrabajador(trabajadorDto);
//		}
		
		return usuarioReturn;
	}
	
	@Transactional(readOnly= true)
	@Override
	public List<UsuarioDto> getAllUsuario() {
		
		List<UsuarioDto> usuariosObject = new ArrayList<UsuarioDto>();
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		if(usuarios != null){
			
			for(Usuario usuario : usuarios){
				UsuarioDto usuarioDto = new UsuarioDto();
				BeanUtils.copyProperties(usuario, usuarioDto);
								
//				if(usuario.getPerfil() != null){
//					PerfilDto perfil = new PerfilDto();
//					BeanUtils.copyProperties(usuario.getPerfil(), perfil);
//					usuarioDto.setPerfil(perfil);
//				}
				
//				if(usuario.getTrabajador() != null){
//					TrabajadorDto trabajadorDto = new TrabajadorDto();
//					BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//					
////					if(usuario.getTrabajador().getSucursal() != null){
////						SucursalDto sucursalDto = new SucursalDto();
////						BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
////						trabajadorDto.setSucursal(sucursalDto);
////					}
//					usuarioDto.setTrabajador(trabajadorDto);
//				}
//				usuariosObject.add(usuarioDto);
			}
			
			return usuariosObject;
		}else
			return null;
		
	}

	@Transactional
	@Override
	public void changeEstadoUsuario(Integer codigoUsuario,Integer estado) {
		// TODO Auto-generated method stub
		usuarioRepository.changeStateUser(codigoUsuario, estado);
	}

	@Transactional
	@Override
	public UsuarioDto getUsuarioCodigo(Integer codigoUsuario) {
		
		UsuarioDto usuarioDto = new UsuarioDto();
		
		Usuario usuario = usuarioRepository.findOne(codigoUsuario);
		
		if(usuario != null){
			
			BeanUtils.copyProperties(usuario, usuarioDto);
			
//			if(usuario.getPerfil() != null){
//				PerfilDto perfil = new PerfilDto();
//				BeanUtils.copyProperties(usuario.getPerfil(), perfil);
//				usuarioDto.setPerfil(perfil);
//			}
			
//			if(usuario.getTrabajador() != null){
//				TrabajadorDto trabajadorDto = new TrabajadorDto();
//				BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//				
//				if(usuario.getTrabajador().getSucursal() != null){
//					SucursalDto sucursalDto = new SucursalDto();
//					BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
//					
//					if(usuario.getTrabajador().getSucursal().getTransportista() != null)
//					{
//						TransportistaDto transportistaDto = new TransportistaDto();
//						BeanUtils.copyProperties(usuario.getTrabajador().getSucursal().getTransportista(), transportistaDto);
//						sucursalDto.setTransportista(transportistaDto);
//					}
//					
//					if(usuario.getTrabajador().getSucursal().getListaPrecio()!=null){
//						ListaPrecioDto listaPrecioDto = new ListaPrecioDto();
//						BeanUtils.copyProperties(usuario.getTrabajador().getSucursal().getListaPrecio(), listaPrecioDto);
//						sucursalDto.setListaPrecio(listaPrecioDto);
//					}
//					
//					trabajadorDto.setSucursal(sucursalDto);
//				}
//				
//				usuarioDto.setTrabajador(trabajadorDto);
//			}
//			
//			if(usuario.getPermisosAccesoSistema() != null){
//				PermisosAccesoSistemaDto permisosaccesosistema = new PermisosAccesoSistemaDto();
//				BeanUtils.copyProperties(usuario.getPermisosAccesoSistema(), permisosaccesosistema);
//				usuarioDto.setPermisosAccesoSistema(permisosaccesosistema);
//			}

			
			return usuarioDto;
		}else
			return null;
	}

	@Transactional
	@Override
	public UsuarioDto getUsuariobyUsuario(String user) {
		// TODO Auto-generated method stub
				
		Usuario usuario = usuarioRepository.getUsuariobyUser(user);
		
		if(usuario != null){
			
			UsuarioDto usuarioDto = new UsuarioDto();
			BeanUtils.copyProperties(usuario, usuarioDto);
			
//			if(usuario.getUsuariosPerfil() != null){
//				UsuarioPerfilDto perfilDto = new UsuarioPerfilDto();
//				BeanUtils.copyProperties(usuario.getUsuariosPerfil(), perfilDto);
//				usuarioDto.setUsuariosPerfil(perfilDto);
//			}
			
//			if(usuario.getTrabajador() != null){
//				TrabajadorDto trabajadorDto = new TrabajadorDto();
//				BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//				
////				if(usuario.getTrabajador().getSucursal() != null){
////					SucursalDto sucursalDto = new SucursalDto();
////					BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
////					trabajadorDto.setSucursal(sucursalDto);
////				}
//				
//				usuarioDto.setTrabajador(trabajadorDto);
//			}
				
			return usuarioDto;
		}else
			return null;
		
	}
	@Transactional(readOnly = true)
	@Override
	public UsuarioAdminDto getUsuarioAdminByCodigo(Integer codigoUsuario) {
		Usuario usuario = usuarioRepository.getUsuariobyCodigo(codigoUsuario);
		
		if(usuario != null){
			
			if(usuario.getActivo() == 1){
				UsuarioAdminDto usuarioDto = new UsuarioAdminDto();
				BeanUtils.copyProperties(usuario, usuarioDto);
				
//				if(usuario.getPerfil() != null){
//					PerfilDto perfilDto = new PerfilDto();
//					BeanUtils.copyProperties(usuario.getPerfil(), perfilDto);
//					usuarioDto.setPerfil(perfilDto);
//				}
				
//				if(usuario.getTrabajador() != null){
//					TrabajadorDto trabajadorDto = new TrabajadorDto();
//					BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//					
////					if(usuario.getTrabajador().getSucursal() != null){
////						SucursalDto sucursalDto = new SucursalDto();
////						BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
////						trabajadorDto.setSucursal(sucursalDto);
////					}
//					
//					usuarioDto.setTrabajador(trabajadorDto);
//				}
				
				return usuarioDto;
				
			}else
				return null;
		}else
			return null;
	}

	@Transactional
	@Override
	public UsuarioDto cambiarUsuarioPasswrod(UsuarioAdminDto usuarioDto) {
		
		Validate.notNull(usuarioDto);
		
		//String newPassword = new StandardPasswordEncoder().encode(usuarioDto.getContrasena());
		String newPassword = usuarioDto.getContrasena();
		
		usuarioRepository.changePasswordUser(usuarioDto.getCodigo(),newPassword );
		
		Usuario usuario = usuarioRepository.findOne(usuarioDto.getCodigo());
		
		if(usuario != null){
			
			BeanUtils.copyProperties(usuario, usuarioDto);
			
//			if(usuario.getPerfil() != null){
//				PerfilDto perfil = new PerfilDto();
//				BeanUtils.copyProperties(usuario.getPerfil(), perfil);
//				usuarioDto.setPerfil(perfil);
//			}
//			
//			if(usuario.getTrabajador() != null){
//				TrabajadorDto trabajadorDto = new TrabajadorDto();
//				BeanUtils.copyProperties(usuario.getTrabajador(), trabajadorDto);
//				
////				if(usuario.getTrabajador().getSucursal() != null){
////					SucursalDto sucursalDto = new SucursalDto();
////					BeanUtils.copyProperties(usuario.getTrabajador().getSucursal(), sucursalDto);
////					trabajadorDto.setSucursal(sucursalDto);
////				}
//				
//				usuarioDto.setTrabajador(trabajadorDto);
//			}

			
			return usuarioDto;
		}else
			return null;
	}

	@Transactional
	@Override
	public void deleteUsuario(Integer codUsuario) {
		// TODO Auto-generated method stub
		usuarioRepository.delete(codUsuario);
		usuarioRepository.flush();
	}
	
	@Transactional
	@Override
	public UsuarioDto cambiarPermisosAccesoSistemaUsuario(UsuarioDto usuarioDto) {
		
		Validate.notNull(usuarioDto);
	
//		usuarioRepository.actualizaPermisosAccesoSistema(usuarioDto.getCodigo(), usuarioDto.getPermisosAccesoSistema().getCodigo());
			
		return usuarioDto;
	}

}
