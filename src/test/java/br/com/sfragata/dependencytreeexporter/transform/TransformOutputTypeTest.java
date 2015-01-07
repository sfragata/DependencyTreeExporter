/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.transform;

import org.junit.Test;

/**
 * @author Silvio Fragata Silva
 *
 */
public class TransformOutputTypeTest {

	public TransformOutputTypeTest() {

	}

	@Test
	public void testValidTransformOutputType() {

		TransformOutputType.getTransformOutputType("html");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTransformOutputType() {

		TransformOutputType.getTransformOutputType("csv");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullTransformOutputType() {

		TransformOutputType.getTransformOutputType(null);
	}

}
