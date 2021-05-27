package com.census;

public class CensusAnalyzerException extends Exception{
    public enum ExceptionType {
        WRONG_FILE,
        WRONG_FILE_TYPE,
        WRONG_FILE_DELIMITER,
        WRONG_HEADER;
    }

    public ExceptionType type;

    public CensusAnalyzerException(String s, ExceptionType type){
        super(s);
        this.type = type;
    }
}