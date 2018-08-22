package ApiPersona.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import ApiPersona.model.DeleteRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JsonApiBodyRequestDelete
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-27T15:31:23.413Z")

public class JsonApiBodyRequestDelete   {
  @JsonProperty("persona")
  @Valid
  private List<DeleteRequest> persona = new ArrayList<DeleteRequest>();

  public JsonApiBodyRequestDelete persona(List<DeleteRequest> persona) {
    this.persona = persona;
    return this;
  }

  public JsonApiBodyRequestDelete addPersonaItem(DeleteRequest personaItem) {
    this.persona.add(personaItem);
    return this;
  }

  /**
   * Get persona
   * @return persona
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<DeleteRequest> getPersona() {
    return persona;
  }

  public void setPersona(List<DeleteRequest> persona) {
    this.persona = persona;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonApiBodyRequestDelete jsonApiBodyRequestDelete = (JsonApiBodyRequestDelete) o;
    return Objects.equals(this.persona, jsonApiBodyRequestDelete.persona);
  }

  @Override
  public int hashCode() {
    return Objects.hash(persona);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JsonApiBodyRequestDelete {\n");
    
    sb.append("    persona: ").append(toIndentedString(persona)).append("\n");
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

