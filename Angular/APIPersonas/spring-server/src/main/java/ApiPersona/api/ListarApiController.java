package ApiPersona.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import ApiPersona.model.JsonApiBodyRequest;
import ApiPersona.model.JsonApiBodyResponseErrors;
import ApiPersona.model.JsonApiBodyResponseSuccess;
import ApiPersona.model.RegistrarRequest;
import ApiPersona.repository.PersonaRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-27T15:31:23.413Z")

@Controller
public class ListarApiController implements ListarApi {

	private static final Logger log = LoggerFactory.getLogger(ListarApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
	JsonApiBodyResponseSuccess exito = new JsonApiBodyResponseSuccess();

	@Autowired
	PersonaRepository personaRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public ListarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<?> listarEstadoEstadoGet(
			@ApiParam(value = "se recibe el rol del usuario", required = true) @PathVariable("estado") String estado) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			
			List<RegistrarRequest> persona = personaRepository.findByEstado(estado);

			JsonApiBodyRequest body = new JsonApiBodyRequest();

			body.setPersona(persona);
			if (body.getPersona().isEmpty() || persona == null) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		}
		error.setCodigo("");
		error.setDetalle("");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<?> listarGet() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			List<RegistrarRequest> persona = (List<RegistrarRequest>) personaRepository.findAll();
			JsonApiBodyRequest body = new JsonApiBodyRequest();
			for (RegistrarRequest registrarRequest : persona) {
				registrarRequest.setContrasena("vacio<");
			}

			body.setPersona(persona);
			if (body.getPersona().isEmpty() || persona == null) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		}

		error.setCodigo("");
		error.setDetalle("");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<?> listarIdGet(
			@ApiParam(value = "ID of pet that needs to be fetched", required = true) @PathVariable("id") String id) {
		String accept = request.getHeader("Accept");
		//if (accept != null && accept.contains("application/json")) {
			RegistrarRequest persona = personaRepository.findOne(id);

			JsonApiBodyRequest body = new JsonApiBodyRequest();
			List<RegistrarRequest> lista = new ArrayList<RegistrarRequest>();
			lista.add(persona);
			body.setPersona(lista);
			if (body.getPersona().isEmpty() || persona == null) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		//}

//		error.setCodigo("");
//		error.setDetalle("");
//		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

	}
	public ResponseEntity<?> listarCorrreoGet(
			@ApiParam(value = "ID of pet that needs to be fetched", required = true) @PathVariable("id") String correo) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			List<RegistrarRequest> persona = personaRepository.findBycorreo(correo);
			if (persona.isEmpty() || persona.equals(null)) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
			}
			JsonApiBodyRequest body = new JsonApiBodyRequest();
			
			body.setPersona(persona);
			if (body.getPersona().isEmpty() || persona == null) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		}

		error.setCodigo("");
		error.setDetalle("");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<?> listarRolRolGet(
			@ApiParam(value = "se recibe el rol del usuario", required = true) @PathVariable("rol") String rol) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			List<RegistrarRequest> persona = personaRepository.findByRol(rol);
//             if (persona.get(0).equals("")|| persona.get(0).equals(null)) {
// 				System.out.println("error persona nula o  basio");
// 			}
			JsonApiBodyRequest body = new JsonApiBodyRequest();

			body.setPersona(persona);
			if (body.getPersona().isEmpty()) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		}

		error.setCodigo("");
		error.setDetalle("");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<?> listarCorreoGet(@ApiParam(value = "se recibe el rol del usuario", required = true) @PathVariable("correo") String correo) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			System.out.println(correo);
			List<RegistrarRequest> persona = personaRepository.findBycorreo(correo);
			System.out.println(persona.size());
             if (persona.isEmpty()) {
            	 error.setCodigo("");
         		error.setDetalle("basio");
         		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
 			}
			JsonApiBodyRequest body = new JsonApiBodyRequest();

			body.setPersona(persona);
			if (body.getPersona().isEmpty()) {
				error.setCodigo("");
				error.setDetalle("");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

			}
			return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
		}

		error.setCodigo("");
		error.setDetalle("");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}

	
	

}
