package com.fdm.SpringAssessment.service;

import com.fdm.SpringAssessment.models.Address;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OneMapService {
    private final String apiToken;

    public OneMapService(Dotenv dotenv) {
        this.apiToken = dotenv.get("API_TOKEN");
    }

    public List<Map<String, Object>> getAddressByPostalCode(String postalCode) {

        // build API call params
        RestClient restClient = RestClient.create();
        JsonNode response = restClient.get()
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
                .body(JsonNode.class);

        // make results into list + error checking
        List<Map<String, Object>> addresses = new ArrayList<>();
        JsonNode results = response.get("results");
        if (results != null || !results.isArray()) {
            return addresses;
        }

        int idIndex = 0;
        for (JsonNode result : results) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", idIndex);
            item.put("blkNo", result.path("BLK_NO").asText());
            item.put("roadName", result.path("ROAD_NAME").asText());
            item.put("building", result.path("BUILDING").asText());
            item.put("address", result.path("ADDRESS").asText());
            item.put("postalCode", result.path("POSTAL").asText());

            addresses.add(item);
            idIndex++;
        }

        return addresses;

    }
}
