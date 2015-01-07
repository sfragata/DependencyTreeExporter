/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.transform;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;
import br.com.sfragata.dependencytreeexporter.transform.exception.TemplateTransformException;

/**
 * @author sfragata
 *
 */
public class VelocityTemplateTransform
    implements TemplateTransform {

    private final VelocityEngine velocityEngine;

    private static final Properties VELOCITY_PROPERTIES = new Properties();

    static {

        final InputStream input =
            VelocityTemplateTransform.class.getClassLoader().getResourceAsStream("velocity.properties");
        try {
            VelocityTemplateTransform.VELOCITY_PROPERTIES.load(input);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Could not find velocity.properties...");
        }
    }

    public VelocityTemplateTransform() {

        this.velocityEngine = new VelocityEngine(VelocityTemplateTransform.VELOCITY_PROPERTIES);
        this.velocityEngine.init();
    }

    @Override
    public void transform(
        final String rootName,
        final Map<DependencyDTO, List<DependencyDTO>> deps,
        final TransformOutputType outputType)
        throws TemplateTransformException {

        final Map<DependencyDTO, List<DependencyDTO>> sortedMap = sortMap(deps);

        final VelocityContext context = new VelocityContext();
        context.put("root", rootName);
        context.put("dependencies", sortedMap);

        Template template = null;

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            template = this.velocityEngine.getTemplate(outputType.getFile());
            template.merge(context, writer);
        } catch (final ResourceNotFoundException rnfe) {
            throw new TemplateTransformException("Resource not found", rnfe);
        } catch (final ParseErrorException pee) {
            throw new TemplateTransformException("Error parsing template", pee);
        } catch (final IOException ioe) {
            throw new TemplateTransformException("Error", ioe);
        }

    }

    /**
     * Sorting the map and its elements (List)
     * @param deps
     * @return
     */
    private Map<DependencyDTO, List<DependencyDTO>> sortMap(
        final Map<DependencyDTO, List<DependencyDTO>> deps) {

        for (final List<DependencyDTO> values : deps.values()) {
            Collections.sort(values);
        }

        final Map<DependencyDTO, List<DependencyDTO>> sortedMap = new TreeMap<DependencyDTO, List<DependencyDTO>>(deps);
        return sortedMap;
    }
}
