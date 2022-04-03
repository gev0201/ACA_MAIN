package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {

    private static final Logger log = LogManager.getLogger(CustomLogger.class.getName());

    public static void main(String[] args) {
        log.debug("Debug message log");
        log.error("Error message log");
    }

}
