package br.com.sfragata.dependencytreeexporter.transform;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.sfragata.dependencytreeexporter.dto.DependencyDTO;

@Deprecated
public class HtmlTemplateTransform
    implements TemplateTransform {

    private static final String TR_HTML = "<tr><td colspan=\"1\">{0}</td>"
        + "<td colspan=\"1\">{1}</td>"
        + "<td colspan=\"1\">{2}</td>"
        + "<td colspan=\"1\">{3}</td></tr>";

    public HtmlTemplateTransform() {

    }

    @SuppressWarnings("unused")
    @Override
    public void transform(
        final String rootName,
        final Map<DependencyDTO, List<DependencyDTO>> deps,
        final TransformOutputType outputType) {

        final StringBuilder builder = new StringBuilder();

        for (final Entry<DependencyDTO, List<DependencyDTO>> dep : deps.entrySet()) {
            for (final DependencyDTO child : dep.getValue()) {
                builder.append(MessageFormat.format(HtmlTemplateTransform.TR_HTML, child.getGroupIdArtifactId(), dep
                    .getKey().getGroupIdArtifactId(), child.getVersion(), child.getScope()));
            }
        }

        System.out.println(builder.toString());

    }
}
