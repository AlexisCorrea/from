package ApiPersona.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import ApiPersona.model.JsonApiBodyRequestDelete;
import ApiPersona.model.JsonApiBodyResponseErrors;
import ApiPersona.model.JsonApiBodyResponseSuccess;
import ApiPersona.model.RegistrarRequest;
import ApiPersona.repository.PersonaRepository;
import ApiPersona.util.CopiAndWrite;
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
public class EliminarApiController implements EliminarApi {

	private static final Logger log = LoggerFactory.getLogger(EliminarApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	List<RegistrarRequest> personas;

	JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();

	JsonApiBodyResponseSuccess exito = new JsonApiBodyResponseSuccess();

	@Autowired
	PersonaRepository persona_repository;

	@org.springframework.beans.factory.annotation.Autowired
	public EliminarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<?> eliminarDelete(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequestDelete body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				
				if (body.getPersona().get(0).getId().equals("00")) {
					error.setCodigo("007");
					error.setDetalle("No se logro eliminar la persona");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
				}
				personas = persona_repository.findByToken(body.getPersona().get(0).getToken());
				if (personas.equals(null) || personas.isEmpty()) {
					error.setCodigo("005");
					error.setDetalle("el token no corresponde que ningun super administrador");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
				}
				if (personas.get(0).getId().equals("00")) {
					persona_repository.delete(body.getPersona().get(0).getId());
					exito.setId(body.getPersona().get(0).getId());
					exito.setNombre("persona");
					exito.setEstado("la persona fue eliminda exitosamente");
					return new ResponseEntity<JsonApiBodyResponseSuccess>(exito, HttpStatus.OK);
				}
				error.setCodigo("004");
				error.setDetalle("no tiene permisos para registrar personas");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.UNAUTHORIZED);
			} catch (Exception e) {
				error.setCodigo("006");
				error.setDetalle("se produjo un erro al momento de eliminar");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		error.setCodigo("004");
		error.setDetalle("organizar las cabezeras");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
	}

}
