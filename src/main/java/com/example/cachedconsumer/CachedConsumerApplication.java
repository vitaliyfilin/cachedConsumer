package com.example.cachedconsumer;

import com.example.cachedconsumer.model.CollectionUserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class CachedConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachedConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public HttpEntity parseHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setContentType(MediaType.APPLICATION_XML);
        //headers.add("Accept", "application/xml");

        return new HttpEntity<>(headers);
    }

    @Bean
    public DocumentBuilder documentBuilder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    @Bean
    public Transformer transformerFactory() throws TransformerConfigurationException {
        return TransformerFactory.newInstance().newTransformer();
    }

    @Bean
    public JAXBContext jaxbContext() throws JAXBException {
        return JAXBContext.newInstance(CollectionUserDto.class);
    }

    @Bean
    public Unmarshaller unmarshaller(JAXBContext jaxbContext) throws JAXBException {
        return jaxbContext.createUnmarshaller();
    }

}
