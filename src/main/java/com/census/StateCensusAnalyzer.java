package com.census;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.io.IOException;

public class StateCensusAnalyzer {
    public int loadData(String path) throws CensusAnalyzerException{
        if (path.contains(".csv")) {
            int numberOfEntries = 0;
            try {
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).
                        withType(CSVStateCensus.class).
                        withIgnoreLeadingWhiteSpace(true).
                        build();
                Iterator<CSVStateCensus> CSVStateCensusIterator = csvToBean.iterator();
                Iterable<CSVStateCensus> iterator=() -> CSVStateCensusIterator;
                return (int) StreamSupport.stream(iterator.spliterator(),false).count();
            }
            catch (IOException e) {
                throw new CensusAnalyzerException("Invalid File path", CensusAnalyzerException.ExceptionType.WRONG_FILE);
            }
            catch (RuntimeException e) {
                throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.WRONG_FILE_DELIMITER);
            }
        }
        else {
            throw new CensusAnalyzerException("Invalid File Type", CensusAnalyzerException.ExceptionType.WRONG_FILE_TYPE);
        }
    }
}