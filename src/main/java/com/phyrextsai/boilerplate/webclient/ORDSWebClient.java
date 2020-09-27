package com.phyrextsai.boilerplate.webclient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import com.phyrextsai.boilerplate.entity.CollectionItem;

@Service
public class ORDSWebClient {

  private String ORDS_WEB_CLIENT_URL = "";

  private WebClient ordsClient = WebClient.create(ORDS_WEB_CLIENT_URL);

}
