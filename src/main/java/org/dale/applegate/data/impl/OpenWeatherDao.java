package org.dale.applegate.data.impl;

import org.dale.applegate.WeatherserviceApplication;
import org.dale.applegate.data.WeatherDao;
import org.dale.applegate.exception.DaoException;
import org.dale.applegate.exception.ResourceNotFoundException;
import org.dale.applegate.model.Weather;
import org.dale.applegate.service.helper.WeatherHelper;
import org.dale.applegate.thirdparty.openweather.OpenWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository("openWeatherDao")
public class OpenWeatherDao extends SimpleCacheRestDao<OpenWeather> implements WeatherDao {

	Logger logger = LoggerFactory.getLogger(OpenWeatherDao.class);
	
	//TODO: Externalize these api key to the property file
	private static final String API_KEY = "20be12f473c5e794a681fa66f6a46f4b";
	private static final String ZIPCODE_US_QUERY = "https://api.openweathermap.org/data/2.5/weather?zip=%s,us&APPID=%s";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WeatherHelper weatherHelper;
	
	
	
	@Override
	@Cacheable(CACHE_ID)
	public Weather getWeatherByZip(String zipcode) {
		
		logger.debug(String.format(ZIPCODE_US_QUERY, zipcode, API_KEY));
		
		OpenWeather weather = null;
		
		try {
			
	//		weather = restTemplate.getForObject(String.format(ZIPCODE_US_QUERY, zipcode, API_KEY), OpenWeather.class);
			weather = get(String.format(ZIPCODE_US_QUERY, zipcode, API_KEY), OpenWeather.class);
		
		} catch (HttpClientErrorException e) {
			//TODO: Parse the response for resource not found versus other possible errors
			throw new ResourceNotFoundException(2L, e.getMessage());
		}catch (Exception e) {
			throw new DaoException(1L , e.getMessage());
		}
        
        String windDirection = weatherHelper.convertWindDegreeToDirection(weather.getWind().getDeg());
	    Double windSpeed = weather.getWind().getSpeed();
        
	    logger.debug("windDirection={},windSpeed={}",windDirection, windSpeed);
   
	    return new Weather(windDirection, windSpeed);
	}
	
	
}
