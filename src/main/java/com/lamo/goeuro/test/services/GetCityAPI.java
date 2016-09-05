package com.lamo.goeuro.test.services;

import static com.google.common.base.Preconditions.checkArgument;
import com.lamo.goeuro.test.model.City;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class GetCityAPI {
	  public static final String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	  private static RestTemplate restTemplate = new RestTemplate();
	  
	  /**
	   * Queries the City JSON API.
	   * @param city the query parameter.
	   * @return {@code List} of objects of type {@link City}
	   */
	  public List<City> querySuggestedCities(String city) {
	    checkArgument(city != null, "Query parameter must not be null");
	    checkArgument(!city.isEmpty(), "Empty query value");
	    City[] cities = restTemplate.getForObject(URL.concat("{city}"), City[].class, city);
	    return Arrays.asList(cities);
	  }
}
