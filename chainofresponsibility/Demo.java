public class Demo {
    public static void main(String[] args) {
        Logger loggerChain = LoggerChain.getChainOfLoggers();
        System.out.println("Logging an INFO level message:");
        loggerChain.logMessage(Logger.INFO, "This is an informational message.");
        System.out.println("\nLogging a DEBUG level message:");
        loggerChain.logMessage(Logger.DEBUG, "This is a debug message.");
        System.out.println("\nLogging an ERROR level message:");
        loggerChain.logMessage(Logger.ERROR, "This is an error message.");
    }
}
