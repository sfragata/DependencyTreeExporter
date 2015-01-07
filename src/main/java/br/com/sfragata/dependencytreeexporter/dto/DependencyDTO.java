/**
 * 
 */
package br.com.sfragata.dependencytreeexporter.dto;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

/**
 * @author Silvio Fragata Silva
 *
 */
public class DependencyDTO
    implements Serializable, Comparable<DependencyDTO> {

    private static final long serialVersionUID = -7649090320383201318L;

    private String groupId;

    private String artifactId;

    private String packageType;

    private String version;

    private String scope;

    private DependencyDTO() {

    }

    public String getGroupId() {

        return this.groupId;
    }

    public void setGroupId(
        final String groupId) {

        this.groupId = groupId;
    }

    public String getArtifactId() {

        return this.artifactId;
    }

    public void setArtifactId(
        final String artifactId) {

        this.artifactId = artifactId;
    }

    public String getPackageType() {

        return this.packageType;
    }

    public void setPackageType(
        final String packageType) {

        this.packageType = packageType;
    }

    public String getVersion() {

        return this.version;
    }

    public void setVersion(
        final String version) {

        this.version = version;
    }

    public String getScope() {

        return this.scope;
    }

    public void setScope(
        final String scope) {

        this.scope = scope;
    }

    public String getGroupIdArtifactId() {

        return String.format("%s:%s", this.groupId, this.artifactId);
    }

    public static DependencyDTO parse(
        final String line) {

        Validate.notEmpty(line);

        final String[] split = line.split(":");
        if (split.length < 4) {
            throw new IllegalArgumentException(
                "The line must be: <groupId>:<artifactId>:<packageType>:<version>[:<scope>]");
        }

        final DependencyDTO dependencyDTO = new DependencyDTO();

        dependencyDTO.setGroupId(split[0]);
        dependencyDTO.setArtifactId(split[1]);
        dependencyDTO.setPackageType(split[2]);
        dependencyDTO.setVersion(split[3]);

        if (split.length == 5) {
            dependencyDTO.setScope(split[4]);
        }

        return dependencyDTO;

    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (this.artifactId == null ? 0 : this.artifactId.hashCode());
        result = prime * result + (this.groupId == null ? 0 : this.groupId.hashCode());
        result = prime * result + (this.packageType == null ? 0 : this.packageType.hashCode());
        result = prime * result + (this.scope == null ? 0 : this.scope.hashCode());
        result = prime * result + (this.version == null ? 0 : this.version.hashCode());
        return result;
    }

    @Override
    public boolean equals(
        final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DependencyDTO other = (DependencyDTO) obj;
        if (this.artifactId == null) {
            if (other.artifactId != null) {
                return false;
            }
        } else if (!this.artifactId.equals(other.artifactId)) {
            return false;
        }
        if (this.groupId == null) {
            if (other.groupId != null) {
                return false;
            }
        } else if (!this.groupId.equals(other.groupId)) {
            return false;
        }
        if (this.packageType == null) {
            if (other.packageType != null) {
                return false;
            }
        } else if (!this.packageType.equals(other.packageType)) {
            return false;
        }
        if (this.scope == null) {
            if (other.scope != null) {
                return false;
            }
        } else if (!this.scope.equals(other.scope)) {
            return false;
        }
        if (this.version == null) {
            if (other.version != null) {
                return false;
            }
        } else if (!this.version.equals(other.version)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "DependencyDTO [groupId="
            + this.groupId
            + ", artifactId="
            + this.artifactId
            + ", packageType="
            + this.packageType
            + ", version="
            + this.version
            + ", scope="
            + this.scope
            + "]";
    }

    @Override
    public int compareTo(
        final DependencyDTO o) {

        return toString().compareTo(o.toString());
    }

}
