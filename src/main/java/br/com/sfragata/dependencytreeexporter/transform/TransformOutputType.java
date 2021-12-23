package br.com.sfragata.dependencytreeexporter.transform;

public enum TransformOutputType {
	HTML("templates/html.vm"), JSON("templates/json.vm");

	private final String file;

	TransformOutputType(final String pFile) {

		this.file = pFile;
	}

	public static TransformOutputType getTransformOutputType(
			String transformOutputType) {
		if (transformOutputType == null) {
			throw new IllegalArgumentException(
					"the 'transformOutputType' is required");
		}
		return TransformOutputType.valueOf(transformOutputType.toUpperCase());
	}

	public String getFile() {

		return this.file;
	}

}
