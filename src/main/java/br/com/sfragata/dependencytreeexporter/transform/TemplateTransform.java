/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.transform;

import java.util.List;
import java.util.Map;

import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;
import br.com.sfragata.dependencytreeexporter.transform.exception.TemplateTransformException;

/**
 * @author Silvio Fragata Silva 
 *
 */
public interface TemplateTransform {
    public void transform(
        String rootName,
        Map<DependencyDTO, List<DependencyDTO>> deps,
        TransformOutputType outputType)
        throws TemplateTransformException;
}
