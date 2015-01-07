/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.transform;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.sfragata.dependencytreeexporter.dot2java.Dot2Java;
import br.com.sfragata.dependencytreeexporter.dot2java.exception.Dot2JavaParserException;
import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;
import br.com.sfragata.dependencytreeexporter.transform.exception.TemplateTransformException;

/**
 * @author Silvio Fragata Silva
 *
 */
public class TemplateTransformTest {

    private final TemplateTransform transform = new VelocityTemplateTransform();

    @SuppressWarnings("deprecation")
    private final TemplateTransform htmlTransform = new HtmlTemplateTransform();

    private static Map<DependencyDTO, List<DependencyDTO>> deps;

    public TemplateTransformTest() {

    }

    @BeforeClass
    public static void beforeClass() {

        final Dot2Java dot2Java = new Dot2Java();
        final URL url = TemplateTransformTest.class.getClassLoader().getResource("dependency.dot");
        try {
            TemplateTransformTest.deps = dot2Java.parse(new File(url.getFile()));
        } catch (final Dot2JavaParserException e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testVelocityHtmlTransform()
        throws TemplateTransformException {

        this.transform.transform("VelocityHtmlTransform", TemplateTransformTest.deps, TransformOutputType.HTML);
    }

    @Test
    public void testVelocityJsonTransform()
        throws TemplateTransformException {

        this.transform.transform("VelocityJsonTransform", TemplateTransformTest.deps, TransformOutputType.JSON);
    }

    @Test
    @Ignore
    public void testHtmlTransform()
        throws TemplateTransformException {

        this.htmlTransform.transform("HTML", TemplateTransformTest.deps, TransformOutputType.HTML);

    }
}
