class LoggerChain {
    public static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);

        return debugLogger; // ✅ return root of the chain
    }
}
