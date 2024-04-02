package fr.polytech.sim.log;

public abstract class LoggerDecorator implements Logger {
    final protected Logger logger;

    protected LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public abstract void log(String format, Object... args);
    
}
