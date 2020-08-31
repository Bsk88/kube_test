package app.service.requerst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceRequest {

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    Logger logger = LoggerFactory.getLogger(RestServiceRequest.class);

    @Autowired
    private Environment env;

    private final RestTemplate restTemplate;

    public RestServiceRequest(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * @param tClass   тип класса
     */
    @SuppressWarnings("unchecked")
    public <T> T getName(Class tClass) {
        try {
            String url = env.getProperty(System.getenv("service.url"),env.getProperty("service.url") )+ "/get_name";
            logger.info("Получение данных из сервиса по url:"+url);
            return ((T)this.restTemplate.getForObject(url, tClass));
        } catch (HttpClientErrorException e) {

            throw new RuntimeException(e.getResponseBodyAsString());
        }
    }



}
