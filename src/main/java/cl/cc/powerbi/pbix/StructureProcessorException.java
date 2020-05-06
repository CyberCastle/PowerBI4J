package cl.cc.powerbi.pbix;

/**
 * @author CyberCastle
 */
public class StructureProcessorException extends Exception {

    private static final long serialVersionUID = 1324311672110976990L;

    public StructureProcessorException() {
        super();
    }

    public StructureProcessorException(String message) {
        super(message);
    }

    public StructureProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public StructureProcessorException(Throwable cause) {
        super(cause);
    }

    protected StructureProcessorException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
