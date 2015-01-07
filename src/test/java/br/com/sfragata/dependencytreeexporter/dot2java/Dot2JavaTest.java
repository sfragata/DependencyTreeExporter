/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.dot2java;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.sfragata.dependencytreeexporter.dot2java.exception.Dot2JavaParserException;
import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;

/**
 * @author ssilva
 *
 */
public class Dot2JavaTest {

    private final Dot2Java dot2Java = new Dot2Java();

    public Dot2JavaTest() {

    }

    @Test
    public void testParser()
        throws Dot2JavaParserException {

        final URL url = getClass().getClassLoader().getResource("dependency.dot");

        final Map<DependencyDTO, List<DependencyDTO>> deps = this.dot2Java.parse(new File(url.getFile()));
        assertEquals(3, deps.size());

        final DependencyDTO dependencyDTO = DependencyDTO.parse("org.apache.velocity:velocity:jar:1.7:compile");
        assertTrue(deps.containsKey(dependencyDTO));
        final List<DependencyDTO> list = deps.get(dependencyDTO);
        assertNotNull(list);
        assertEquals(1, list.size());

    }
}
