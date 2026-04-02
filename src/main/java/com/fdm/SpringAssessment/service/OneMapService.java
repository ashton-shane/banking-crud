package com.fdm.SpringAssessment.service;

import com.fdm.SpringAssessment.models.Address;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OneMapService {
    private final String apiToken;

    public OneMapService(Dotenv dotenv) {
        this.apiToken = dotenv.get("API_TOKEN");
    }

    public Address getAddressByPostalCode(String postalCode) {
        // to implement error checking for api
        RestClient restClient = RestClient.create();
        String baseUrl = "https://www.onemap.gov.sg/api/common/elastic/search";

        String result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(baseUrl)
                        .queryParam("searchVal", postalCode)
                        .queryParam("returnGeom", "N")
                        .queryParam("getAddrDetails", "Y")
                        .build()
                )
                .header("Authorization", "Bearer " + apiToken)
                .retrieve()
                .body(String.class);

        System.out.println(result);
    }
}
