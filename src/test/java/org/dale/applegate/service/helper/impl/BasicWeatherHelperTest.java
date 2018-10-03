package org.dale.applegate.service.helper.impl;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class BasicWeatherHelperTest {

	//TODO: Move wind directions to enums
	private static final String UNKNOWN_DIRECTION = "UNKNOWN";
	BasicWeatherHelper basicWeatherHelper = new BasicWeatherHelper();
	
	@Test
	public void testConvertWindDegreeToDirection() {
		
		assertEquals("N", basicWeatherHelper.convertWindDegreeToDirection(0.00));
		assertEquals("NNE", basicWeatherHelper.convertWindDegreeToDirection(20.00));
		assertEquals("NE", basicWeatherHelper.convertWindDegreeToDirection(50.00));
		assertEquals("ENE", basicWeatherHelper.convertWindDegreeToDirection(70.00));
		assertEquals("E", basicWeatherHelper.convertWindDegreeToDirection(100.00));
		assertEquals("ESE", basicWeatherHelper.convertWindDegreeToDirection(120.00));
		assertEquals("SE", basicWeatherHelper.convertWindDegreeToDirection(140.00));
		assertEquals("SSE", basicWeatherHelper.convertWindDegreeToDirection(150.00));
		assertEquals("S", basicWeatherHelper.convertWindDegreeToDirection(170.00));
		assertEquals("SSW", basicWeatherHelper.convertWindDegreeToDirection(200.00));
		assertEquals("SW", basicWeatherHelper.convertWindDegreeToDirection(220.00));
		assertEquals("WSW", basicWeatherHelper.convertWindDegreeToDirection(240.00));
		assertEquals("W", basicWeatherHelper.convertWindDegreeToDirection(260.00));
		assertEquals("WNW", basicWeatherHelper.convertWindDegreeToDirection(290.00));
		assertEquals("NW", basicWeatherHelper.convertWindDegreeToDirection(320.00));
		assertEquals("NNW", basicWeatherHelper.convertWindDegreeToDirection(330.00));
		
	}
	
	@Test
	public void testConvertWindDegreeToDirectionEveryDegree() {
		
		for (int i = 0; i < (360 * 100) +1; i++) {//looping through every hundreth of a degree  360 * 100
			assertNotNull("valid wind degree not mapped", basicWeatherHelper.convertWindDegreeToDirection(i/100));//converting i to degrees
			
		}
	}
	
	@Test
	public void testConvertWindDegreeToDirectionNegative() {
		assertEquals(UNKNOWN_DIRECTION, basicWeatherHelper.convertWindDegreeToDirection(-2));
	}
	
	@Test
	public void testConvertWindDegreeToDirectionTooBig() {
		assertEquals(UNKNOWN_DIRECTION, basicWeatherHelper.convertWindDegreeToDirection(361));
	}

}
