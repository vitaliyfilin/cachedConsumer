package com.example.cachedconsumer.schedule;

import com.example.cachedconsumer.model.CollectionUserDto;
import com.example.cachedconsumer.repository.UserDao;
import com.example.cachedconsumer.repository.UserRepository;
import com.example.cachedconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class ConsumerBalanceUserByHTTPClient {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DocumentBuilder documentBuilder;
    @Autowired
    Transformer transformer;
    @Autowired
    Unmarshaller unmarshaller;
    @Autowired
    UserService userDao;

    @Scheduled(fixedDelay = 5000L)
    public void getResponse() throws IOException, SAXException, TransformerException, JAXBException {

        DOMSource domSource = new DOMSource(documentBuilder.parse(new URL("http://localhost:8080/getUsers").openStream()));
        File tempXml = new File("temp.xml");
        StreamResult streamResult = new StreamResult(tempXml);
        transformer.transform(domSource, streamResult);
        CollectionUserDto collectionUserDto = (CollectionUserDto) unmarshaller.unmarshal(tempXml);

        collectionUserDto.getUserList().forEach(x -> userDao.saveUser(x));


    }


}
