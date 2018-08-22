package ApiPersona.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RegistrarRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-27T15:31:23.413Z")

@DynamoDBTable(tableName="persona")
public class RegistrarRequest   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("apellidos")
  private String apellidos = null;

  @JsonProperty("correo")
  private String correo = null;

  @JsonProperty("contrasena")
  private String contrasena = null;

  @JsonProperty("telefono")
  private String telefono = null;

  @JsonProperty("genero")
  private String genero = null;

  @JsonProperty("rol")
  private String rol = null;

  @JsonProperty("estado")
  private String estado = null;

  @JsonProperty("token")
  private String token = null;

  public RegistrarRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBHashKey
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RegistrarRequest nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public RegistrarRequest apellidos(String apellidos) {
    this.apellidos = apellidos;
    return this;
  }

  /**
   * Get apellidos
   * @return apellidos
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public RegistrarRequest correo(String correo) {
    this.correo = correo;
    return this;
  }

  /**
   * Get correo
   * @return correo
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public RegistrarRequest contrasena(String contrasena) {
    this.contrasena = contrasena;
    return this;
  }

  /**
   * Get contrasena
   * @return contrasena
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  public RegistrarRequest telefono(String telefono) {
    this.telefono = telefono;
    return this;
  }

  /**
   * Get telefono
   * @return telefono
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public RegistrarRequest genero(String genero) {
    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public RegistrarRequest rol(String rol) {
    this.rol = rol;
    return this;
  }

  /**
   * Get rol
   * @return rol
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

  public RegistrarRequest estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public RegistrarRequest token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @DynamoDBAttribute
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrarRequest registrarRequest = (RegistrarRequest) o;
    return Objects.equals(this.id, registrarRequest.id) &&
        Objects.equals(this.nombre, registrarRequest.nombre) &&
        Objects.equals(this.apellidos, registrarRequest.apellidos) &&
        Objects.equals(this.correo, registrarRequest.correo) &&
        Objects.equals(this.contrasena, registrarRequest.contrasena) &&
        Objects.equals(this.telefono, registrarRequest.telefono) &&
        Objects.equals(this.genero, registrarRequest.genero) &&
        Objects.equals(this.rol, registrarRequest.rol) &&
        Objects.equals(this.estado, registrarRequest.estado) &&
        Objects.equals(this.token, registrarRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellidos, correo, contrasena, telefono, genero, rol, estado, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrarRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
    sb.append("    correo: ").append(toIndentedString(correo)).append("\n");
    sb.append("    contrasena: ").append(toIndentedString(contrasena)).append("\n");
    sb.append("    telefono: ").append(toIndentedString(telefono)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    rol: ").append(toIndentedString(rol)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

