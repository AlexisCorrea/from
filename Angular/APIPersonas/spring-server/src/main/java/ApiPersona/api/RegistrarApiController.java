package ApiPersona.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import ApiPersona.model.DeleteRequest;
import ApiPersona.model.JsonApiBodyRequest;
import ApiPersona.model.JsonApiBodyRequestDelete;
import ApiPersona.model.JsonApiBodyResponseErrors;
import ApiPersona.model.JsonApiBodyResponseSuccess;
import ApiPersona.repository.PersonaRepository;
import ApiPersona.util.CopiAndWrite;
import ApiPersona.util.validaciones;
import ApiPersona.model.RegistrarRequest;
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
import javax.swing.text.html.parser.Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-27T15:31:23.413Z")

@Controller
public class RegistrarApiController implements RegistrarApi {

	private static final Logger log = LoggerFactory.getLogger(RegistrarApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private validaciones valid;

	List<RegistrarRequest> personas;

	JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();

	JsonApiBodyResponseSuccess exito = new JsonApiBodyResponseSuccess();

	@Autowired
	PersonaRepository persona_repository;

	@org.springframework.beans.factory.annotation.Autowired
	public RegistrarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public boolean validarExiste(String correo) {
		List<RegistrarRequest> personas = persona_repository.findBycorreo(correo);
		if (personas.size() > 0) {
			return true;

		} else {
			return false;
		}

	}

	public ResponseEntity<?> registrarPost(
			@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				if (validarExiste(body.getPersona().get(0).getCorreo())) {
					error.setCodigo("001");
					error.setDetalle("correo ya existente");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
				}
				if (!valid.validarCorreo(body.getPersona().get(0).getCorreo())) {
					error.setCodigo("002");
					error.setDetalle("el correo no cumple con los parametros");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
				}
				if (valid.validarContrasena(body.getPersona().get(0).getContrasena())) {
					error.setCodigo("003");
					error.setDetalle("la contraseña con cumple con los parametros");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);
				}
				if (body.getPersona().get(0).getRol().equals("super administrador")) {
					personas = persona_repository.findByToken(body.getPersona().get(0).getToken());
					if (personas.equals(null) || personas.isEmpty()) {
						error.setCodigo("005");
						error.setDetalle("el token no corresponde que ningun super administrador");
						return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
					}
					if (personas.get(0).getRol().equals("super administrador")) {
						// se setealos nuevos id y token para no guardar el token que me envien y el
						// token del administrador que hace la accion
						body.getPersona().get(0).setId(CopiAndWrite.leer());
						CopiAndWrite.escribir();
						body.getPersona().get(0).setToken(UUID.randomUUID().toString());
						RegistrarRequest RegistrarRequest = persona_repository.save(body.getPersona().get(0));

						exito.setId(body.getPersona().get(0).getId());
						exito.setNombre(body.getPersona().get(0).getNombre());
						exito.setEstado("Persona registrada exitosamente");
						return new ResponseEntity<JsonApiBodyResponseSuccess>(exito, HttpStatus.CREATED);
					}
					error.setCodigo("004");
					error.setDetalle("no tiene permisos para registrar personas");
					return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.UNAUTHORIZED);

				}
				// se setealos nuevos id y token para no guardar un token que deprono ingresen o
				// un id que no que no quiera
				body.getPersona().get(0).setId(CopiAndWrite.leer());
				CopiAndWrite.escribir();
				body.getPersona().get(0).setToken(UUID.randomUUID().toString());
				RegistrarRequest RegistrarRequest = persona_repository.save(body.getPersona().get(0));

				exito.setId(body.getPersona().get(0).getId());
				exito.setNombre(body.getPersona().get(0).getNombre());
				exito.setEstado("Persona registrada exitosamente");
				return new ResponseEntity<JsonApiBodyResponseSuccess>(exito, HttpStatus.CREATED);

			} catch (Exception e) {
				error.setCodigo("006");
				error.setDetalle("se produjo un erro al momento de guardar");
				return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
		error.setCodigo("004");
		error.setDetalle("organizar las cabezeras");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<?> obtenerPost(@ApiParam(value = "body", required = true) @Valid @RequestBody JsonApiBodyRequestDelete body) {
		personas = persona_repository.findByToken(body.getPersona().get(0).getToken());
		if (personas.equals(null) || personas.isEmpty()) {
			error.setCodigo("005");
			error.setDetalle("el token no corresponde que ningun super administrador");
			return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.FORBIDDEN);
		} else {
			if (personas.get(0).getId().equals(body.getPersona().get(0).getId())) {
				exito.setId(personas.get(0).getId());
				exito.setNombre(personas.get(0).getToken());
				exito.setEstado(personas.get(0).getNombre());
				return new ResponseEntity<JsonApiBodyResponseSuccess>(exito, HttpStatus.OK);
			}

		}
		error.setCodigo("010");
		error.setDetalle("se produjo un erro al momento de consultar");
		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
