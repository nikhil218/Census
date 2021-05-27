package com.census;

import org.junit.jupiter.api.*;

public class StateCensusAnalyserTest {

    private String rightPath = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private String wrongPath = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensus.csv";

    @Test
    public void givenDataWhenLoadedShouldReturnNumberOfRecords() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        int size = stateCensusAnalyser.loadData(rightPath);
        Assertions.assertEquals(29, size);
    }

    @Test
    public void whenGivenDataFromWrongPathShouldFalse() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        try{
            stateCensusAnalyser.loadData(wrongPath);
        }
        catch(CensusAnalyzerException e){
            throw new CensusAnalyzerException("Wrong File Path");
        }
    }
}