package org.sonatype.mavenbook.weather;

import java.io.InputStream;

import org.sonatype.mavenbook.weather.model.Weather;

public class WeatherService {

	private YahooRetriever yahooRetriever;
	private YahooParser yahooParser;

	public Weather retrieveForecast(String zip) throws Exception {
		InputStream dataIn = yahooRetriever.retrive(zip);
		Weather weather = yahooParser.parse(zip, dataIn);
		return weather;
	}
	
	public YahooRetriever getYahooRetriever() {
		return yahooRetriever;
	}
	
	public void setYahooRetriever(YahooRetriever yahooRetriever) {
		this.yahooRetriever = yahooRetriever;
	}
	
	public YahooParser getYahooParser() {
		return yahooParser;
	}
	
	public void setYahooParser(YahooParser yahooParser) {
		this.yahooParser = yahooParser;
	}
	
}
