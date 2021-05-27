package com.census;

import org.junit.jupiter.api.*;

public class StateCensusAnalyserTest {

    private String rightPath = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private String wrongPath = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensus.csv";
    private String wrongFiletype = "C:\\Users\\nikhi\\IdeaProjects\\State_Census_Problem\\src\\main\\resources\\IndiaStateCensusData.txt";

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
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CensusAnalyzerException.ExceptionType.WRONG_FILE);
        }
    }

    @Test
    public void givenWrongFileTypeShouldThrowCustomException() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        try{
            stateCensusAnalyser.loadData(wrongFiletype);
        }
        catch(CensusAnalyzerException e) {
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CensusAnalyzerException.ExceptionType.WRONG_FILE_TYPE);
        }
    }

    @Test
    public void givenWrongDelimiterShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        try{
            stateCensusAnalyser.loadData(rightPath);
        }
        catch(CensusAnalyzerException e) {
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CensusAnalyzerException.ExceptionType.WRONG_FILE_DELIMITER);
        }
    }

    @Test
    public void givenWrongHeaderShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyser = new StateCensusAnalyzer();
        try{
            stateCensusAnalyser.loadData(rightPath);
        }
        catch(CensusAnalyzerException e) {
            System.out.println(e.type);
            Assertions.assertEquals(e.type, CensusAnalyzerException.ExceptionType.WRONG_HEADER);
        }
    }


}