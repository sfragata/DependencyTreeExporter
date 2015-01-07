package br.com.sfragata.dependencytreeexporter.dot2java;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.sfragata.dependencytreeexporter.dot2java.exception.Dot2JavaParserException;
import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;

/**
 * @author Silvio Fragata Silva
 * To create a maven dot file use:
 * <pre>mvn dependency:tree -DoutputType=dot -DoutputFile=dependency.dot</pre>
 */
public class Dot2Java {

    public Dot2Java() {

    }

    public Map<DependencyDTO, List<DependencyDTO>> parse(
        final File dotFile)
        throws Dot2JavaParserException {

        final Map<DependencyDTO, List<DependencyDTO>> deps = new HashMap<DependencyDTO, List<DependencyDTO>>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(dotFile.toPath(), Charset.defaultCharset())) {

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (StringUtils.isNotBlank(line)) {
                    if (!line.trim().startsWith("digraph") && !line.trim().startsWith("}")) {
                        final String[] splitLine = line.split("->");

                        if (splitLine.length != 2) {
                            throw new IllegalArgumentException("The line must be : \"parent\" -> \"child\"");
                        }
                        final String parent = removeCharacters(splitLine[0]);
                        final String child = removeCharacters(splitLine[1]);

                        final DependencyDTO parentDependencyDTO = DependencyDTO.parse(parent);
                        final DependencyDTO dtoChild = DependencyDTO.parse(child);
                        if (deps.containsKey(parentDependencyDTO)) {
                            if (!deps.get(parentDependencyDTO).contains(dtoChild)) {
                                deps.get(parentDependencyDTO).add(dtoChild);
                            }
                        } else {
                            final List<DependencyDTO> list = new ArrayList<>();
                            list.add(dtoChild);
                            deps.put(parentDependencyDTO, list);
                        }
                    }
                }
            }

        } catch (final IOException e) {
            throw new Dot2JavaParserException(e);
        }

        return deps;
    }

    private String removeCharacters(
        final String string) {

        String replacedString = string.replaceAll("\"", "");
        replacedString = replacedString.replaceAll(";", "");
        return replacedString.trim();
    }
}
