class InfoLogger extends Logger {
    public InfoLogger(int logLevel) {
        this.logLevel = logLevel;
    }
@Override
    protected void write(String message) {
        System.out.println("INFO Logger: " + message);
    }
}