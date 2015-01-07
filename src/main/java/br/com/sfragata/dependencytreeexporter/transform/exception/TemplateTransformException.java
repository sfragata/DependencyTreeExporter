package br.com.sfragata.dependencytreeexporter.transform.exception;

/**
 * @author Silvio Fragata Silva
 *
 */
public class TemplateTransformException
    extends Exception {

    private static final long serialVersionUID = 9131176980573362378L;

    @SuppressWarnings("unused")
    private TemplateTransformException() {

    }

    /**
     * @param cause
     */
    public TemplateTransformException(final Throwable cause) {

        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public TemplateTransformException(final String message, final Throwable cause) {

        super(message, cause);
    }

}
