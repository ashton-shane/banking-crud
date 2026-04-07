package com.fdm.SpringAssessment.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OneMapService {
    private final String apiToken;

    // allow Dotenv to be null-injected or missing; use a safe fallback
    public OneMapService(Dotenv dotenv) {
        String token = null;
        try {
            if (dotenv != null) token = dotenv.get("API_TOKEN");
        } catch (Exception ignored) {
        }
        this.apiToken = token;
    }

    public List<Map<String, Object>> getAddressByPostalCode(String postalCode) {
        List<Map<String, Object>> addresses = new ArrayList<>();

        try {
            RestTemplate rest = new RestTemplate();
            String url = UriComponentsBuilder.fromUriString("https://www.onemap.gov.sg/api/common/elastic/search")
                    .queryParam("searchVal", postalCode)
                    .queryParam("returnGeom", "N")
                    .queryParam("getAddrDetails", "Y")
                    .toUriString();

            ResponseEntity<Map> resp = rest.getForEntity(url, Map.class);
            if (!resp.getStatusCode().is2xxSuccessful()) return addresses;

            Map body = resp.getBody();
            if (body == null) return addresses;

            Object resultsObj = body.get("results");
            if (!(resultsObj instanceof List)) return addresses;

            List results = (List) resultsObj;
            int idIndex = 0;
            for (Object r : results) {
                if (!(r instanceof Map)) continue;
                Map m = (Map) r;
                Map<String, Object> item = new HashMap<>();
                item.put("id", idIndex);
                item.put("blkNo", m.getOrDefault("BLK_NO", ""));
                item.put("roadName", m.getOrDefault("ROAD_NAME", ""));
                item.put("building", m.getOrDefault("BUILDING", ""));
                item.put("address", m.getOrDefault("ADDRESS", ""));
                item.put("postalCode", m.getOrDefault("POSTAL", ""));
                addresses.add(item);
                idIndex++;
            }
        } catch (Exception e) {
            // ignore - return empty list on failure
        }

        return addresses;
    }
}
