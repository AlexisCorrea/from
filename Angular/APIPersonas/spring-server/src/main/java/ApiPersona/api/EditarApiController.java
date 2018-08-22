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
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-27T15:31:23.413Z")

@Controller
public class EditarApiController implements EditarApi {

	private static final Logger log = LoggerFactory.getLogger(EditarApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
	JsonApiBodyResponseSuccess exito = new JsonApiBodyResponseSuccess();
	
	List<RegistrarRequest> persona;

	@Autowired
	PersonaRepository personaRepository;

	@org.springframework.beans.factory.annotation.Autowired
	public EditarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<?> editarPut(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				if (body.getPersona().get(0).getId().equals("00")) {
					error.setCodigo("009");
					error.setDetalle("No se logro editar a la persona");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
				}
				if (body.getPersona().get(0).getToken().isEmpty()) {
					error.setCodigo("005");
					error.setDetalle("el token no corresponde que ningun persona");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
				}
				persona = personaRepository.findByToken(body.getPersona().get(0).getToken());
				
				if (persona.equals(null)||persona.isEmpty()) {
					error.setCodigo("005");
					error.setDetalle("el token no corresponde que ningun persona");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
				}
				if (persona.get(0).getId().equals("00")) {
					RegistrarRequest RegistrarRequest = personaRepository.save(body.getPersona().get(0));
					exito.setId(body.getPersona().get(0).getId());
					exito.setNombre(body.getPersona().get(0).getNombre());
					exito.setEstado("fue editado con exito");
					return new ResponseEntity<JsonApiBodyResponseSuccess>(exito,HttpStatus.OK);
				}
				if (!persona.get(0).getCorreo().equals(body.getPersona().get(0).getCorreo())) {
					error.setCodigo("011");
					error.setDetalle("No se puede cambiar el correo");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
				}
				if (persona.get(0).getId().equals(body.getPersona().get(0).getId())) {
					RegistrarRequest RegistrarRequest = personaRepository.save(body.getPersona().get(0));
					exito.setId(body.getPersona().get(0).getId());
					exito.setNombre(body.getPersona().get(0).getNombre());
					exito.setEstado("fue editado con exito");
					return new ResponseEntity<JsonApiBodyResponseSuccess>(exito,HttpStatus.OK);
				}
				//personaRepository.save(body.getPersona().get(0));
				
				

			} catch (Exception e) {
				error.setCodigo("006");
				error.setDetalle("se produjo un erro al momento de editar");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		error.setCodigo("004");
		error.setDetalle("organizar las cabezeras");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}

}
