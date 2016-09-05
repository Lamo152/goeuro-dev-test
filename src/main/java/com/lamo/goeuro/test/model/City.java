package com.lamo.goeuro.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "_id", "name", "type", "latitude", "longitude" })
public class City {

  @JsonProperty("_id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private String type;

  @JsonUnwrapped
  @JsonProperty("geo_position")
  private GeoLocation location;

  @JsonCreator
  public City(@JsonProperty("_id") Integer id,
              @JsonProperty("name") String name,
              @JsonProperty("type") String type,
              @JsonProperty("geo_position") GeoLocation location) {
      this.id = id;
      this.name = name;
      this.type = type;
      this.location = location;
}
  
  @JsonGetter("_id")
  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }
  
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      City location = (City) o;

      if (id != null ? !id.equals(location.id) : location.id != null) return false;
      if (name != null ? !name.equals(location.name) : location.name != null) return false;
      if (type != null ? !type.equals(location.type) : location.type != null) return false;
      return location != null ? location.equals(location.location) : location.location == null;

  }

  @Override
  public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (type != null ? type.hashCode() : 0);
      result = 31 * result + (location != null ? location.hashCode() : 0);
      return result;
  }

  /**
   * Returns comma separated values representation of an instance of {@code City}
   * in the following format: "_id,name,type,latitude,longitude".
   */
  @Override
  public String toString() {
      return "City{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", type='" + type + '\'' +
              ", location=" + location +
              '}';
}
}
