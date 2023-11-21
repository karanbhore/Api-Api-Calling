package com.prowings.config;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.prowings.model.Weather;
import com.prowings.model.dto.Climate;

@Configuration
public class CommonConfigs {

	Weather weather=new Weather();
	
	@Value("${api.url}")
	String climateBaseUrl;

	@Bean
	public WebClient webClient() {

		WebClient webClient = WebClient.builder().baseUrl(climateBaseUrl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();

		return webClient;
	}

//	@Bean
//	public DozerBeanMapper mapper() {
//		DozerBeanMapper mapper = new DozerBeanMapper();
//		mapper.setMappingFiles(Arrays.asList("dozer_mapping2.xml"));
//		return mapper;
//	}

	@Bean
	@Qualifier
	public DozerBeanMapper mapper() {
//	    List<String> mappingFiles = Arrays.asList("dozer_mapping2.xml");
	    
//	    List<CustomConverter> converters = Arrays.asList(new CountryCodeConverter());

	    	    DozerBeanMapper dozerBean = new DozerBeanMapper();
//	    	    dozerBean.setMappingFiles(mappingFiles);
//	    	    dozerBean.setCustomConverters(converters);
	    	    dozerBean.map(weather, Climate.class);
	    	    
	    	    return dozerBean;
	}
}