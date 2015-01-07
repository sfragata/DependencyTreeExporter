DependencyTreeExporter
======================

Create an user-friendly view for maven dependency:tree

First of all, we need create a dot file from maven [dependency:tree](http://maven.apache.org/plugins/maven-dependency-plugin/tree-mojo.html)

* mvn dependency:tree -DoutputType=dot -DoutputFile=dep.dot

After, we'll build the project to create a executable file

* mvn clean package appassembler:assemble

Go to **target/appassembler/bin/** folder an you'll see two files (*dependencyTreeExporter* and *dependencyTreeExporter.bat*)

Now, you just need run:

* dependencyTreeExporter[.bat] *title* *path-to-dot-file* *HTML|JSON**


\*Note: There are two templates to export, **HTML** and **JSON**.