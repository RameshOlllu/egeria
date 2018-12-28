/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.adapters.repositoryservices.igc.clientlibrary.model.generated.v115;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.odpi.openmetadata.adapters.repositoryservices.igc.clientlibrary.model.common.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * POJO for the 'analysissummaryobject' asset type in IGC, displayed as 'AnalysisSummaryObject' in the IGC UI.
 * <br><br>
 * (this code has been generated based on out-of-the-box IGC metadata types;
 *  if modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Analysissummaryobject extends Reference {

    public static String getIgcTypeId() { return "analysissummaryobject"; }
    public static String getIgcTypeDisplayName() { return "AnalysisSummaryObject"; }

    /**
     * The 'name' property, displayed as 'Name' in the IGC UI.
     */
    protected String name;

    /**
     * The 'short_description' property, displayed as 'Short Description' in the IGC UI.
     */
    protected String short_description;

    /**
     * The 'long_description' property, displayed as 'Long Description' in the IGC UI.
     */
    protected String long_description;

    /**
     * The 'labels' property, displayed as 'Labels' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link Label} objects.
     */
    protected ReferenceList labels;

    /**
     * The 'stewards' property, displayed as 'Stewards' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link AsclSteward} objects.
     */
    protected ReferenceList stewards;

    /**
     * The 'assigned_to_terms' property, displayed as 'Assigned to Terms' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link Term} objects.
     */
    protected ReferenceList assigned_to_terms;

    /**
     * The 'implements_rules' property, displayed as 'Implements Rules' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link InformationGovernanceRule} objects.
     */
    protected ReferenceList implements_rules;

    /**
     * The 'governed_by_rules' property, displayed as 'Governed by Rules' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link InformationGovernanceRule} objects.
     */
    protected ReferenceList governed_by_rules;

    /**
     * The 'is_viewable' property, displayed as 'Is Viewable' in the IGC UI.
     */
    protected Boolean is_viewable;

    /**
     * The 'review_date' property, displayed as 'Review Date' in the IGC UI.
     */
    protected Date review_date;

    /**
     * The 'promoted_by_principal' property, displayed as 'Promoted By Principal' in the IGC UI.
     * <br><br>
     * Will be a single {@link Reference} to a {@link Steward} object.
     */
    protected Reference promoted_by_principal;

    /**
     * The 'project_name' property, displayed as 'Project Name' in the IGC UI.
     */
    protected String project_name;

    /**
     * The 'reviewed_by_principal' property, displayed as 'Reviewed By Principal' in the IGC UI.
     * <br><br>
     * Will be a single {@link Reference} to a {@link Steward} object.
     */
    protected Reference reviewed_by_principal;


    /** @see #name */ @JsonProperty("name")  public String getTheName() { return this.name; }
    /** @see #name */ @JsonProperty("name")  public void setTheName(String name) { this.name = name; }

    /** @see #short_description */ @JsonProperty("short_description")  public String getShortDescription() { return this.short_description; }
    /** @see #short_description */ @JsonProperty("short_description")  public void setShortDescription(String short_description) { this.short_description = short_description; }

    /** @see #long_description */ @JsonProperty("long_description")  public String getLongDescription() { return this.long_description; }
    /** @see #long_description */ @JsonProperty("long_description")  public void setLongDescription(String long_description) { this.long_description = long_description; }

    /** @see #labels */ @JsonProperty("labels")  public ReferenceList getLabels() { return this.labels; }
    /** @see #labels */ @JsonProperty("labels")  public void setLabels(ReferenceList labels) { this.labels = labels; }

    /** @see #stewards */ @JsonProperty("stewards")  public ReferenceList getStewards() { return this.stewards; }
    /** @see #stewards */ @JsonProperty("stewards")  public void setStewards(ReferenceList stewards) { this.stewards = stewards; }

    /** @see #assigned_to_terms */ @JsonProperty("assigned_to_terms")  public ReferenceList getAssignedToTerms() { return this.assigned_to_terms; }
    /** @see #assigned_to_terms */ @JsonProperty("assigned_to_terms")  public void setAssignedToTerms(ReferenceList assigned_to_terms) { this.assigned_to_terms = assigned_to_terms; }

    /** @see #implements_rules */ @JsonProperty("implements_rules")  public ReferenceList getImplementsRules() { return this.implements_rules; }
    /** @see #implements_rules */ @JsonProperty("implements_rules")  public void setImplementsRules(ReferenceList implements_rules) { this.implements_rules = implements_rules; }

    /** @see #governed_by_rules */ @JsonProperty("governed_by_rules")  public ReferenceList getGovernedByRules() { return this.governed_by_rules; }
    /** @see #governed_by_rules */ @JsonProperty("governed_by_rules")  public void setGovernedByRules(ReferenceList governed_by_rules) { this.governed_by_rules = governed_by_rules; }

    /** @see #is_viewable */ @JsonProperty("is_viewable")  public Boolean getIsViewable() { return this.is_viewable; }
    /** @see #is_viewable */ @JsonProperty("is_viewable")  public void setIsViewable(Boolean is_viewable) { this.is_viewable = is_viewable; }

    /** @see #review_date */ @JsonProperty("review_date")  public Date getReviewDate() { return this.review_date; }
    /** @see #review_date */ @JsonProperty("review_date")  public void setReviewDate(Date review_date) { this.review_date = review_date; }

    /** @see #promoted_by_principal */ @JsonProperty("promoted_by_principal")  public Reference getPromotedByPrincipal() { return this.promoted_by_principal; }
    /** @see #promoted_by_principal */ @JsonProperty("promoted_by_principal")  public void setPromotedByPrincipal(Reference promoted_by_principal) { this.promoted_by_principal = promoted_by_principal; }

    /** @see #project_name */ @JsonProperty("project_name")  public String getProjectName() { return this.project_name; }
    /** @see #project_name */ @JsonProperty("project_name")  public void setProjectName(String project_name) { this.project_name = project_name; }

    /** @see #reviewed_by_principal */ @JsonProperty("reviewed_by_principal")  public Reference getReviewedByPrincipal() { return this.reviewed_by_principal; }
    /** @see #reviewed_by_principal */ @JsonProperty("reviewed_by_principal")  public void setReviewedByPrincipal(Reference reviewed_by_principal) { this.reviewed_by_principal = reviewed_by_principal; }

    public static final Boolean canBeCreated() { return false; }
    public static final Boolean includesModificationDetails() { return false; }
    public static final ArrayList<String> NON_RELATIONAL_PROPERTIES = new ArrayList<String>() {{
        add("name");
        add("short_description");
        add("long_description");
        add("is_viewable");
        add("review_date");
        add("project_name");
    }};
    public static final ArrayList<String> PAGED_RELATIONAL_PROPERTIES = new ArrayList<String>() {{
        add("labels");
        add("stewards");
        add("assigned_to_terms");
        add("implements_rules");
        add("governed_by_rules");
    }};
    public static final ArrayList<String> ALL_PROPERTIES = new ArrayList<String>() {{
        add("name");
        add("short_description");
        add("long_description");
        add("labels");
        add("stewards");
        add("assigned_to_terms");
        add("implements_rules");
        add("governed_by_rules");
        add("is_viewable");
        add("review_date");
        add("promoted_by_principal");
        add("project_name");
        add("reviewed_by_principal");
    }};
    public static final List<String> getNonRelationshipProperties() { return NON_RELATIONAL_PROPERTIES; }
    public static final List<String> getPagedRelationshipProperties() { return PAGED_RELATIONAL_PROPERTIES; }
    public static final List<String> getAllProperties() { return ALL_PROPERTIES; }
    public static final Boolean isAnalysissummaryobject(Object obj) { return (obj.getClass() == Analysissummaryobject.class); }

}
