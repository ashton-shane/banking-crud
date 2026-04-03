package com.fdm.SpringAssessment.controllers;

import com.fdm.SpringAssessment.service.OneMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class OneMapController {
    private final OneMapService oneMapService;

    public List<Map<String, Object>> callOneMapAPI(@RequestParam String postalCode) {
        return oneMapService.getAddressByPostalCode(postalCode);
    }
}
