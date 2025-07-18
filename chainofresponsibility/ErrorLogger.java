class ErrorLogger extends Logger {
    public ErrorLogger(int logLevel) {
        this.logLevel = logLevel;
    }
    @Override
    protected void write(String message) {
        System.out.println("ERROR Logger: " + message);
    }
}