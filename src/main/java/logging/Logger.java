package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String logFile;
    private static Logger instance;

    private Logger(String logFile) {
        this.logFile = logFile;
    }

    public static Logger getInstance(String logFile) {
        if (instance == null) {
            instance = new Logger(logFile);
        }
        return instance;
    }

    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile, true))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            out.println(now.format(formatter) + " - " + message);
        } catch (IOException e) {
            System.err.println("Error writing to the log file: " + e.getMessage());
        }
    }
}

