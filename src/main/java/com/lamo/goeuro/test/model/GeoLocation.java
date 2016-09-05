package com.lamo.goeuro.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocation {
	
	@JsonProperty("longitude")
	private double longitude;
	
	@JsonProperty("latitude")
	private double latitude;

    @JsonCreator
    public GeoLocation(@JsonProperty("latitude") double latitude,
                       @JsonProperty("longitude") double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
}
    
	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
	
	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        GeoLocation that = (GeoLocation) o;

	        if (latitude != 0 ? latitude != that.latitude : that.latitude != 0) return false;
	        return longitude != 0 ? longitude == that.longitude : that.longitude == 0;
	    }

	    @Override
	    public int hashCode() {
	        int result = (int) (latitude != 0 ? latitude : 0);
	        result = (int) (31 * result + (longitude != 0 ? longitude : 0));
	        return result;
	    }

	    @Override
	    public String toString() {
	        return "GeoLocation{" +
	                "latitude='" + latitude + '\'' +
	                ", longitude='" + longitude + '\'' +
	                '}';
	}
}