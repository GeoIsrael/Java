package telran.converter.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.converter.dto.RateDto;

public class CurrencyTestDtoAppl {

	public static void main(String[] args) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://data.fixer.io/api/latest"
				+ "?access_key=8c054e387fa9a278b92a5e65d6d1883d"; 
		RequestEntity<String> request = 
				new RequestEntity<>(HttpMethod.GET, new URI(url));
		ResponseEntity<Map<String, Object>> response = 
				restTemplate.exchange(request, new ParameterizedTypeReference<Map<String, Object>>() {
				});
		System.out.println(response.getBody().get("date"));

	}

}
