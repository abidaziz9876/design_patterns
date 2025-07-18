class LoggerChain {
    public static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        return infoLogger;
    }
}