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

    public String getAddressByPostalCode(String postalCode) {
        // to implement error checking for api
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("www.onemap.gov.sg")
                        .path("/api/common/elastic/search")
                        .queryParam("searchVal", postalCode)
                        .queryParam("returnGeom", "N")
                        .queryParam("getAddrDetails", "Y")
                        .build()
                )
                .header("Authorization", "Bearer " + apiToken)
                .retrieve()
                .body(String.class);

        return result;
    }
}
