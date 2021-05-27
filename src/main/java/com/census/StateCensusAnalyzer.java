package com.census;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StateCensusAnalyzer {
    public int loadData(String path) throws CensusAnalyzerException{
        int numberOfEntries = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).
                    withType(CSVStateCensus.class).
                    withIgnoreLeadingWhiteSpace(true).
                    build();
            Iterator<CSVStateCensus> CSVStateCensusIterator = csvToBean.iterator();

            while(CSVStateCensusIterator.hasNext()){
                CSVStateCensus censusAnalyser = CSVStateCensusIterator.next();
                System.out.println("State : " + censusAnalyser.getState());
                System.out.println("Population : " + censusAnalyser.getPopulation());
                System.out.println("AreaInSqKm : " + censusAnalyser.getAreaInSqKm());
                System.out.println("DensityPerSqKm : " + censusAnalyser.getDensityPerSqKm());
                System.out.println("\n=====================\n");
                numberOfEntries++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfEntries;
    }
}