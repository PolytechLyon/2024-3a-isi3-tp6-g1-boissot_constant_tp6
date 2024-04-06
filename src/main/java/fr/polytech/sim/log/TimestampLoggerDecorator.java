package fr.polytech.sim.log;

import java.util.Date;

public class TimestampLoggerDecorator extends LoggerDecorator{

    protected TimestampLoggerDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String format, Object... args) {
        String message = Long.toString(new Date().getTime()) ; 
        this.logger.log(message);
    }


    
}
