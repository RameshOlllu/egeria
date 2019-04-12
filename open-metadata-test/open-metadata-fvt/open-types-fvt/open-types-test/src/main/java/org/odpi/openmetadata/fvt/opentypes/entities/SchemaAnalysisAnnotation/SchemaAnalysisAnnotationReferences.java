/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

// This is a generated file - do not edit - changes should be made to the templates amd/or generator to generate this file with changes.

package org.odpi.openmetadata.fvt.opentypes.entities.SchemaAnalysisAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;

import  org.odpi.openmetadata.fvt.opentypes.references.SchemaAnalysisAnnotationToDataField.DiscoveredDataFieldsReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.DiscoveredDataField.DiscoveredDataField;
import org.odpi.openmetadata.fvt.opentypes.relationships.DiscoveredDataField.DiscoveredDataFieldMapper;
import  org.odpi.openmetadata.fvt.opentypes.references.SchemaAnalysisAnnotationToSchemaType.SchemaTypeDefinitionReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.SchemaTypeDefinition.SchemaTypeDefinition;
import org.odpi.openmetadata.fvt.opentypes.relationships.SchemaTypeDefinition.SchemaTypeDefinitionMapper;
import  org.odpi.openmetadata.fvt.opentypes.references.AnnotationToAnnotation.ExtendedAnnotationsReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationExtension.AnnotationExtension;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationExtension.AnnotationExtensionMapper;
import  org.odpi.openmetadata.fvt.opentypes.references.AnnotationToAnnotationReview.AnnotationReviewsReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationReviewLink.AnnotationReviewLink;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationReviewLink.AnnotationReviewLinkMapper;
import  org.odpi.openmetadata.fvt.opentypes.references.AnnotationToAnnotation.AnnotationExtensionsReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationExtension.AnnotationExtension;
import org.odpi.openmetadata.fvt.opentypes.relationships.AnnotationExtension.AnnotationExtensionMapper;
import  org.odpi.openmetadata.fvt.opentypes.references.AnnotationToOpenDiscoveryAnalysisReport.FromAnalysisReportReference;
import org.odpi.openmetadata.fvt.opentypes.relationships.DiscoveredAnnotation.DiscoveredAnnotation;
import org.odpi.openmetadata.fvt.opentypes.relationships.DiscoveredAnnotation.DiscoveredAnnotationMapper;

import java.io.Serializable;
import java.util.*;
import org.odpi.openmetadata.fvt.opentypes.common.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * References for entity  SchemaAnalysisAnnotation. References are relationships represented as an attribute. Exposing relationships information
 * as references can make the relationships information more digestable.
 */
@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class SchemaAnalysisAnnotationReferences implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SchemaAnalysisAnnotationReferences.class);
    private static final String className = SchemaAnalysisAnnotationReferences.class.getName();

    public static final String[] REFERENCE_NAMES_SET_VALUES = new String[] {
             "discoveredDataFields",
             "schemaTypeDefinition",
             "extendedAnnotations",
             "annotationReviews",
             "annotationExtensions",
             "fromAnalysisReport",
             // Terminate the list
             null
    };

     public static final String[] RELATIONSHIP_NAMES_SET_VALUES = new String[] {
             "DiscoveredDataField",
             "SchemaTypeDefinition",
             "AnnotationExtension",
             "AnnotationReviewLink",
             "AnnotationExtension",
             "DiscoveredAnnotation",
              // Terminate the list
              null
     };
     /**
       * We are passed a set of omrs relationships that are associated with a entity SchemaAnalysisAnnotation
       * Each of these relationships should map to a reference (a uniquely named attribute in SchemaAnalysisAnnotation).
       *
       * Relationships have cardinality. There are 2 sorts of cardinality relevant here, whether the relationships can be related to one or many
       * entities.
       *
       * @param lines the relationships lines.
       * @param entityGuid The GUID of the entity.
       */
     public SchemaAnalysisAnnotationReferences(String entityGuid, Set<Line> lines)  {

        if (lines !=null) {
         for (Line relationships: lines) {
            for (int i=0;i< RELATIONSHIP_NAMES_SET_VALUES.length; i++) {
               if (relationships.getName().equals(RELATIONSHIP_NAMES_SET_VALUES[i])) {
                    String referenceName = REFERENCE_NAMES_SET_VALUES[i];

                    if ("discoveredDataFields".equals(referenceName)) {
                         DiscoveredDataField discoveredDataField_relationship = (DiscoveredDataField)relationships;
                         DiscoveredDataFieldsReference discoveredDataFieldsReference = new DiscoveredDataFieldsReference(entityGuid,discoveredDataField_relationship);
                         if ( discoveredDataFields== null ) {
                              discoveredDataFields = new HashSet();
                         }
                          discoveredDataFields.add(discoveredDataFieldsReference);
                    }
                    if ("extendedAnnotations".equals(referenceName)) {
                         AnnotationExtension annotationExtension_relationship = (AnnotationExtension)relationships;
                         ExtendedAnnotationsReference extendedAnnotationsReference = new ExtendedAnnotationsReference(entityGuid,annotationExtension_relationship);
                         if ( extendedAnnotations== null ) {
                              extendedAnnotations = new HashSet();
                         }
                          extendedAnnotations.add(extendedAnnotationsReference);
                    }
                    if ("annotationReviews".equals(referenceName)) {
                         AnnotationReviewLink annotationReviewLink_relationship = (AnnotationReviewLink)relationships;
                         AnnotationReviewsReference annotationReviewsReference = new AnnotationReviewsReference(entityGuid,annotationReviewLink_relationship);
                         if ( annotationReviews== null ) {
                              annotationReviews = new HashSet();
                         }
                          annotationReviews.add(annotationReviewsReference);
                    }
                    if ("annotationExtensions".equals(referenceName)) {
                         AnnotationExtension annotationExtension_relationship = (AnnotationExtension)relationships;
                         AnnotationExtensionsReference annotationExtensionsReference = new AnnotationExtensionsReference(entityGuid,annotationExtension_relationship);
                         if ( annotationExtensions== null ) {
                              annotationExtensions = new HashSet();
                         }
                          annotationExtensions.add(annotationExtensionsReference);
                    }

                    if ("schemaTypeDefinition".equals(referenceName)) {
                         SchemaTypeDefinition schemaTypeDefinition_relationship = (SchemaTypeDefinition)relationships;
                         schemaTypeDefinition = new SchemaTypeDefinitionReference(entityGuid, schemaTypeDefinition_relationship);
                    }
                    if ("fromAnalysisReport".equals(referenceName)) {
                         DiscoveredAnnotation discoveredAnnotation_relationship = (DiscoveredAnnotation)relationships;
                         fromAnalysisReport = new FromAnalysisReportReference(entityGuid, discoveredAnnotation_relationship);
                    }
                 }
             }
         }
        }
     }

    public static final Set<String> REFERENCE_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(REFERENCE_NAMES_SET_VALUES)));
    // there may be duplicate strings in RELATIONSHIP_NAMES_SET_VALUES, the following line deduplicates the Strings into a Set.
    public static final Set<String> RELATIONSHIP_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(RELATIONSHIP_NAMES_SET_VALUES)));
// Singular properties
    private SchemaTypeDefinitionReference schemaTypeDefinition;
    private FromAnalysisReportReference fromAnalysisReport;
// Set properties

    private Set<DiscoveredDataFieldsReference> discoveredDataFields;
    private Set<ExtendedAnnotationsReference> extendedAnnotations;
    private Set<AnnotationReviewsReference> annotationReviews;
    private Set<AnnotationExtensionsReference> annotationExtensions;

// List properties

    // setters and setters
    public SchemaTypeDefinitionReference getSchemaTypeDefinitionReference() {
        return schemaTypeDefinition;   }

    public void setSchemaTypeDefinitionReference(SchemaTypeDefinitionReference schemaTypeDefinition) {
        this.schemaTypeDefinition = schemaTypeDefinition; }
    public FromAnalysisReportReference getFromAnalysisReportReference() {
        return fromAnalysisReport;   }

    public void setFromAnalysisReportReference(FromAnalysisReportReference fromAnalysisReport) {
        this.fromAnalysisReport = fromAnalysisReport; }

// Sets
    public Set<DiscoveredDataFieldsReference> getDiscoveredDataFieldsReferences() {
        return discoveredDataFields;
    }

    public void setDiscoveredDataFieldsReferences(Set<DiscoveredDataFieldsReference> discoveredDataFields) {
        this.discoveredDataFields =discoveredDataFields;
    }
    public Set<ExtendedAnnotationsReference> getExtendedAnnotationsReferences() {
        return extendedAnnotations;
    }

    public void setExtendedAnnotationsReferences(Set<ExtendedAnnotationsReference> extendedAnnotations) {
        this.extendedAnnotations =extendedAnnotations;
    }
    public Set<AnnotationReviewsReference> getAnnotationReviewsReferences() {
        return annotationReviews;
    }

    public void setAnnotationReviewsReferences(Set<AnnotationReviewsReference> annotationReviews) {
        this.annotationReviews =annotationReviews;
    }
    public Set<AnnotationExtensionsReference> getAnnotationExtensionsReferences() {
        return annotationExtensions;
    }

    public void setAnnotationExtensionsReferences(Set<AnnotationExtensionsReference> annotationExtensions) {
        this.annotationExtensions =annotationExtensions;
    }

// Lists

 public StringBuilder toString(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder();
        }

        sb.append("SchemaAnalysisAnnotationReferences{");
        sb.append("discoveredDataFieldsReference='").append(discoveredDataFields.toString());
        sb.append("extendedAnnotationsReference='").append(extendedAnnotations.toString());
        sb.append("annotationReviewsReference='").append(annotationReviews.toString());
        sb.append("annotationExtensionsReference='").append(annotationExtensions.toString());
        sb.append("schemaTypeDefinitionReference='").append(schemaTypeDefinition.toString());
        sb.append("fromAnalysisReportReference='").append(fromAnalysisReport.toString());

        sb.append('}');

        return sb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        if (!super.equals(o)) { return false; }
         SchemaAnalysisAnnotationReferences typedThat = (SchemaAnalysisAnnotationReferences) o;
      // compare single cardinality attributes
         if (this.discoveredDataFields != null && !Objects.equals(this.discoveredDataFields,typedThat.discoveredDataFields)) {
                            return false;
                 }
         if (this.schemaTypeDefinition != null && !Objects.equals(this.schemaTypeDefinition,typedThat.schemaTypeDefinition)) {
                            return false;
                 }
         if (this.extendedAnnotations != null && !Objects.equals(this.extendedAnnotations,typedThat.extendedAnnotations)) {
                            return false;
                 }
         if (this.annotationReviews != null && !Objects.equals(this.annotationReviews,typedThat.annotationReviews)) {
                            return false;
                 }
         if (this.annotationExtensions != null && !Objects.equals(this.annotationExtensions,typedThat.annotationExtensions)) {
                            return false;
                 }
         if (this.fromAnalysisReport != null && !Objects.equals(this.fromAnalysisReport,typedThat.fromAnalysisReport)) {
                            return false;
                 }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode()
    ,this.discoveredDataFields
    ,this.schemaTypeDefinition
    ,this.extendedAnnotations
    ,this.annotationReviews
    ,this.annotationExtensions
    ,this.fromAnalysisReport
       );
    }

    @Override
    public String toString() {
        return toString(new StringBuilder()).toString();
    }
}
