package com.census;

import org.junit.jupiter.api.*;

public class StateCensusAnalyserTest {
    
    private String path = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    public void givenDataWhenLoadedShouldReturnNumberOfRecords() {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        int size = stateCensusAnalyser.loadData(path);
        Assertions.assertEquals(29, size);
    }
}