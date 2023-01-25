package com.romanconversion.conversion.controller;

import com.romanconversion.conversion.service.conversions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
public class conversion {
    private conversions conversion;
    @Autowired
    public conversion(conversions conversioninterface) {
        this.conversion = conversioninterface;
    }

    @GetMapping(path = "/romantodigit/{romaninput}")
    public Integer convertNumericToAlphabet(@PathVariable("romaninput") String input) {
        return conversion.romanToDigit(input);
    }
    @GetMapping(path = "/digittoroman/{inputdigit}")
    public String alphabetToNumeric(@PathVariable("inputdigit") Integer input) {
        return conversion.digitToRoman(input);
    }
}
