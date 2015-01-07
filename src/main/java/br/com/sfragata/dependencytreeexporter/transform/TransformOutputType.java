package br.com.sfragata.dependencytreeexporter.transform;

public enum TransformOutputType {
	HTML("templates/html.vm"), JSON("templates/json.vm");

	private String file;

	private TransformOutputType(final String file) {

		this.file = file;
	}

	public String getFile() {

		return this.file;
	}

	public static TransformOutputType getTransformOutputType(
			String transformOutputType) {
		if (transformOutputType == null) {
			throw new IllegalArgumentException(
					"the 'transformOutputType' is required");
		}
		return TransformOutputType.valueOf(transformOutputType.toUpperCase());
	}

}
