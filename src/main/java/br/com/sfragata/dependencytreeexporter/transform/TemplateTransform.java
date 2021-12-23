/**
 *
 */
package br.com.sfragata.dependencytreeexporter.transform;

import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;
import br.com.sfragata.dependencytreeexporter.transform.exception.TemplateTransformException;

import java.util.List;
import java.util.Map;

/**
 * @author Silvio Fragata Silva 
 *
 */
public interface TemplateTransform {
    void transform(
            String rootName,
            Map<DependencyDTO, List<DependencyDTO>> deps,
            TransformOutputType outputType)
            throws TemplateTransformException;
}
