package com.romanconversion.conversion.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { conversionimpl.class })
class conversionimplTest {

    @InjectMocks
    conversionimpl conversionimpltest;

    @BeforeEach
    void setUp() {
        conversionimpltest = new conversionimpl();
    }

    @Test
    void romanToDigit() {
        int conversionnumber = conversionimpltest.romanToDigit("MCMIV");
        assertEquals(1904, conversionnumber);
    }

    @Test
    void digitToRoman() {
        String convertedromannumber = conversionimpltest.digitToRoman(1904);
        assertEquals("MCMIV", convertedromannumber);
    }

}