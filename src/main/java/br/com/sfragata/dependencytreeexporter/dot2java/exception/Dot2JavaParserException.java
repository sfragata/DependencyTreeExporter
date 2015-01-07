/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.dot2java.exception;

/**
 * @author Silvio Fragata Silva
 *
 */
public class Dot2JavaParserException
    extends Exception {

    private static final long serialVersionUID = 3649228788184171093L;

    @SuppressWarnings("unused")
    private Dot2JavaParserException() {

    }

    /**
     * @param cause
     */
    public Dot2JavaParserException(final Throwable cause) {

        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public Dot2JavaParserException(final String message, final Throwable cause) {

        super(message, cause);
    }

}
