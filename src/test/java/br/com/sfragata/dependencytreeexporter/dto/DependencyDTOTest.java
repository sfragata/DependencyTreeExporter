/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.dto;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Silvio Fragata Silva
 *
 */
public class DependencyDTOTest {

    public DependencyDTOTest() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValue() {

        final String line = "a:v:d";

        DependencyDTO.parse(line);
    }

    @Test
    public void testValid4Arguments() {

        final String line = "a:b:c:d";

        final DependencyDTO dep = DependencyDTO.parse(line);
        assertNotNull(dep);

        assertEquals("a", dep.getGroupId());
        assertEquals("b", dep.getArtifactId());
        assertEquals("c", dep.getPackageType());
        assertEquals("d", dep.getVersion());
        assertNull(dep.getScope());
    }

    @Test
    public void testValid5Arguments() {

        final String line = "a:b:c:d:e";

        final DependencyDTO dep = DependencyDTO.parse(line);
        assertNotNull(dep);

        assertEquals("a", dep.getGroupId());
        assertEquals("b", dep.getArtifactId());
        assertEquals("c", dep.getPackageType());
        assertEquals("d", dep.getVersion());
        assertEquals("e", dep.getScope());
    }

}
