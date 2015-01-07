package br.com.sfragata.dependencytreeexporter;

import java.io.File;

import br.com.sfragata.dependencytreeexporter.dot2java.Dot2Java;
import br.com.sfragata.dependencytreeexporter.dot2java.exception.Dot2JavaParserException;
import br.com.sfragata.dependencytreeexporter.transform.TransformOutputType;
import br.com.sfragata.dependencytreeexporter.transform.VelocityTemplateTransform;
import br.com.sfragata.dependencytreeexporter.transform.exception.TemplateTransformException;

public class Main {

    private final Dot2Java dot2Java = new Dot2Java();

    private final VelocityTemplateTransform transform = new VelocityTemplateTransform();

    public Main(final String rootName, final String file) {

        try {
            this.transform.transform(rootName, this.dot2Java.parse(new File(file)), TransformOutputType.HTML);
        } catch (final Dot2JavaParserException | TemplateTransformException e) {
            e.printStackTrace();
        }
    }

    public static void main(
        final String[] args) {

        if (args.length != 2) {
            showUsage();
            System.exit(0);
        }

        new Main(args[0], args[1]);
    }

    private static void showUsage() {

        final String usage = "Usage:\n\t" + "<rootName> <.dot file path>";

        System.out.println(usage);

    }

}
