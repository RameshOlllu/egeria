/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.accessservices.subjectarea.properties.classifications;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.odpi.openmetadata.accessservices.subjectarea.properties.enums.GovernanceClassificationStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

/**
 * Defines the level of confidentiality of related data items.
 */

@JsonAutoDetect(getterVisibility=PUBLIC_ONLY, setterVisibility=PUBLIC_ONLY, fieldVisibility=NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Confidentiality extends Classification {
    private static final Logger log = LoggerFactory.getLogger( Confidentiality.class);
    private static final String className =  Confidentiality.class.getName();
    private Map<String, String> extraAttributes;


 public static final String[] PROPERTY_NAMES_SET_VALUES = new String[] {
        "status",
        "confidence",
        "steward",
        "source",
        "notes",
        "level",

    // Terminate the list
        null
    };
    public static final String[] ATTRIBUTE_NAMES_SET_VALUES = new String[] {
        "confidence",
        "steward",
        "source",
        "notes",
        "level",
     // Terminate the list
        null
    };
    public static final String[] ENUM_NAMES_SET_VALUES = new String[] {
         "status",

         // Terminate the list
          null
    };
    public static final String[] MAP_NAMES_SET_VALUES = new String[] {

         // Terminate the list
         null
    };
    // note the below definitions needs to be fully qualified
    public static final java.util.Set<String> PROPERTY_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(PROPERTY_NAMES_SET_VALUES)));
    public static final java.util.Set<String> ATTRIBUTE_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(ATTRIBUTE_NAMES_SET_VALUES)));
    public static final java.util.Set<String> ENUM_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(ENUM_NAMES_SET_VALUES)));
    public static final java.util.Set<String> MAP_NAMES_SET = new HashSet(new HashSet<>(Arrays.asList(MAP_NAMES_SET_VALUES)));
    /**
     * Default constructor
     */
    public Confidentiality() {
            super.classificationName="Confidentiality";
    }

       private GovernanceClassificationStatus status;
       /**
        * {@literal Status of this classification. }
        * @return Status of this classification.
        */
       public GovernanceClassificationStatus getStatus() {
           return this.status;
       }
       public void setStatus(GovernanceClassificationStatus status)  {
           this.status = status;
       }


       private Integer confidence;
       /**
        * {@literal Level of confidence in the classification (0=none -> 100=excellent). }
        * @return Level of confidence in the classification
        */
       public Integer getConfidence() {
           return this.confidence;
       }
       public void setConfidence(Integer confidence)  {
           this.confidence = confidence;
       }


       private String steward;
       /**
        * {@literal Person responsible for maintaining this classification. }
        * @return Person responsible for maintaining this classification.
        */
       public String getSteward() {
           return this.steward;
       }
       public void setSteward(String steward)  {
           this.steward = steward;
       }


       private String source;
       /**
        * {@literal Source of the classification. }
        * @return Source of the classification.
        */
       public String getSource() {
           return this.source;
       }
       public void setSource(String source)  {
           this.source = source;
       }


       private String notes;
       /**
        * {@literal Information relating to the classification. }
        * @return Information relating to the classification.
        */
       public String getNotes() {
           return this.notes;
       }
       public void setNotes(String notes)  {
           this.notes = notes;
       }


       private Integer level;
       /**
        * {@literal Level of confidentiality. }
        * @return  Level of confidentiality.
        */
       public Integer getLevel() {
           return this.level;
       }
       public void setLevel(Integer level)  {
           this.level = level;
       }



    /**
      * Get the extra attributes - ones that are in addition to the standard types.
      * @return extra attributes
      */
    public Map<String, String> getAdditionalProperties() {
          return extraAttributes;
    }
    public void setAdditionalProperties(Map<String, String> additionalProperties) {
          this.extraAttributes = additionalProperties;
    }
}
