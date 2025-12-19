package com.tp.tonep;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/")
@CrossOrigin
public class TonePolishController {
    @Autowired
    TonePolishService SL;

    @PostMapping("/refine")
    public ResponseEntity<Map<String, String>> refineText(@RequestBody String text) {
        String refined = SL.refineText(text);
        return ResponseEntity.ok(Map.of("polishedText", refined));
    }
}
