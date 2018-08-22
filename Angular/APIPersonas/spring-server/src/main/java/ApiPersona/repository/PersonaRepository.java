package ApiPersona.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import ApiPersona.model.RegistrarRequest;

@EnableScan
public interface PersonaRepository extends CrudRepository<RegistrarRequest, String>{
	public List<RegistrarRequest> findBycorreo(String correo);
	public List<RegistrarRequest> findByRol(String rol);
	public List<RegistrarRequest> findByEstado(String estado);
	public List<RegistrarRequest> findByToken(String token);
}

