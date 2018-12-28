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
 * POJO for the 'host' asset type in IGC, displayed as 'Host' in the IGC UI.
 * <br><br>
 * (this code has been generated based on out-of-the-box IGC metadata types;
 *  if modifications are needed, eg. to handle custom attributes,
 *  extending from this class in your own custom class is the best approach.)
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Host extends Reference {

    public static String getIgcTypeId() { return "host"; }
    public static String getIgcTypeDisplayName() { return "Host"; }

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
     * The 'databases' property, displayed as 'Databases' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link Database} objects.
     */
    protected ReferenceList databases;

    /**
     * The 'data_files' property, displayed as 'Data Files' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link DataFile} objects.
     */
    protected ReferenceList data_files;

    /**
     * The 'idoc_types' property, displayed as 'IDoc Types' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link IdocType} objects.
     */
    protected ReferenceList idoc_types;

    /**
     * The 'transformation_projects' property, displayed as 'Transformation Projects' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link TransformationProject} objects.
     */
    protected ReferenceList transformation_projects;

    /**
     * The 'data_connections' property, displayed as 'Data Connections' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link Connector} objects.
     */
    protected ReferenceList data_connections;

    /**
     * The 'amazon_s3_buckets' property, displayed as 'Amazon S3 Buckets' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link AmazonS3Bucket} objects.
     */
    protected ReferenceList amazon_s3_buckets;

    /**
     * The 'data_file_folders' property, displayed as 'Data File Folders' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link DataFileFolder} objects.
     */
    protected ReferenceList data_file_folders;

    /**
     * The 'location' property, displayed as 'Location' in the IGC UI.
     */
    protected String location;

    /**
     * The 'network_node' property, displayed as 'Network Node' in the IGC UI.
     */
    protected String network_node;

    /**
     * The 'imported_from' property, displayed as 'Imported From' in the IGC UI.
     */
    protected String imported_from;

    /**
     * The 'blueprint_elements' property, displayed as 'Blueprint Elements' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link BlueprintElementLink} objects.
     */
    protected ReferenceList blueprint_elements;

    /**
     * The 'in_collections' property, displayed as 'In Collections' in the IGC UI.
     * <br><br>
     * Will be a {@link ReferenceList} of {@link Collection} objects.
     */
    protected ReferenceList in_collections;

    /**
     * The 'created_by' property, displayed as 'Created By' in the IGC UI.
     */
    protected String created_by;

    /**
     * The 'created_on' property, displayed as 'Created On' in the IGC UI.
     */
    protected Date created_on;

    /**
     * The 'modified_by' property, displayed as 'Modified By' in the IGC UI.
     */
    protected String modified_by;

    /**
     * The 'modified_on' property, displayed as 'Modified On' in the IGC UI.
     */
    protected Date modified_on;


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

    /** @see #databases */ @JsonProperty("databases")  public ReferenceList getDatabases() { return this.databases; }
    /** @see #databases */ @JsonProperty("databases")  public void setDatabases(ReferenceList databases) { this.databases = databases; }

    /** @see #data_files */ @JsonProperty("data_files")  public ReferenceList getDataFiles() { return this.data_files; }
    /** @see #data_files */ @JsonProperty("data_files")  public void setDataFiles(ReferenceList data_files) { this.data_files = data_files; }

    /** @see #idoc_types */ @JsonProperty("idoc_types")  public ReferenceList getIdocTypes() { return this.idoc_types; }
    /** @see #idoc_types */ @JsonProperty("idoc_types")  public void setIdocTypes(ReferenceList idoc_types) { this.idoc_types = idoc_types; }

    /** @see #transformation_projects */ @JsonProperty("transformation_projects")  public ReferenceList getTransformationProjects() { return this.transformation_projects; }
    /** @see #transformation_projects */ @JsonProperty("transformation_projects")  public void setTransformationProjects(ReferenceList transformation_projects) { this.transformation_projects = transformation_projects; }

    /** @see #data_connections */ @JsonProperty("data_connections")  public ReferenceList getDataConnections() { return this.data_connections; }
    /** @see #data_connections */ @JsonProperty("data_connections")  public void setDataConnections(ReferenceList data_connections) { this.data_connections = data_connections; }

    /** @see #amazon_s3_buckets */ @JsonProperty("amazon_s3_buckets")  public ReferenceList getAmazonS3Buckets() { return this.amazon_s3_buckets; }
    /** @see #amazon_s3_buckets */ @JsonProperty("amazon_s3_buckets")  public void setAmazonS3Buckets(ReferenceList amazon_s3_buckets) { this.amazon_s3_buckets = amazon_s3_buckets; }

    /** @see #data_file_folders */ @JsonProperty("data_file_folders")  public ReferenceList getDataFileFolders() { return this.data_file_folders; }
    /** @see #data_file_folders */ @JsonProperty("data_file_folders")  public void setDataFileFolders(ReferenceList data_file_folders) { this.data_file_folders = data_file_folders; }

    /** @see #location */ @JsonProperty("location")  public String getLocation() { return this.location; }
    /** @see #location */ @JsonProperty("location")  public void setLocation(String location) { this.location = location; }

    /** @see #network_node */ @JsonProperty("network_node")  public String getNetworkNode() { return this.network_node; }
    /** @see #network_node */ @JsonProperty("network_node")  public void setNetworkNode(String network_node) { this.network_node = network_node; }

    /** @see #imported_from */ @JsonProperty("imported_from")  public String getImportedFrom() { return this.imported_from; }
    /** @see #imported_from */ @JsonProperty("imported_from")  public void setImportedFrom(String imported_from) { this.imported_from = imported_from; }

    /** @see #blueprint_elements */ @JsonProperty("blueprint_elements")  public ReferenceList getBlueprintElements() { return this.blueprint_elements; }
    /** @see #blueprint_elements */ @JsonProperty("blueprint_elements")  public void setBlueprintElements(ReferenceList blueprint_elements) { this.blueprint_elements = blueprint_elements; }

    /** @see #in_collections */ @JsonProperty("in_collections")  public ReferenceList getInCollections() { return this.in_collections; }
    /** @see #in_collections */ @JsonProperty("in_collections")  public void setInCollections(ReferenceList in_collections) { this.in_collections = in_collections; }

    /** @see #created_by */ @JsonProperty("created_by")  public String getCreatedBy() { return this.created_by; }
    /** @see #created_by */ @JsonProperty("created_by")  public void setCreatedBy(String created_by) { this.created_by = created_by; }

    /** @see #created_on */ @JsonProperty("created_on")  public Date getCreatedOn() { return this.created_on; }
    /** @see #created_on */ @JsonProperty("created_on")  public void setCreatedOn(Date created_on) { this.created_on = created_on; }

    /** @see #modified_by */ @JsonProperty("modified_by")  public String getModifiedBy() { return this.modified_by; }
    /** @see #modified_by */ @JsonProperty("modified_by")  public void setModifiedBy(String modified_by) { this.modified_by = modified_by; }

    /** @see #modified_on */ @JsonProperty("modified_on")  public Date getModifiedOn() { return this.modified_on; }
    /** @see #modified_on */ @JsonProperty("modified_on")  public void setModifiedOn(Date modified_on) { this.modified_on = modified_on; }

    public static final Boolean canBeCreated() { return false; }
    public static final Boolean includesModificationDetails() { return true; }
    public static final ArrayList<String> NON_RELATIONAL_PROPERTIES = new ArrayList<String>() {{
        add("name");
        add("short_description");
        add("long_description");
        add("location");
        add("network_node");
        add("imported_from");
        add("created_by");
        add("created_on");
        add("modified_by");
        add("modified_on");
    }};
    public static final ArrayList<String> PAGED_RELATIONAL_PROPERTIES = new ArrayList<String>() {{
        add("labels");
        add("stewards");
        add("assigned_to_terms");
        add("implements_rules");
        add("governed_by_rules");
        add("databases");
        add("data_files");
        add("idoc_types");
        add("transformation_projects");
        add("data_connections");
        add("amazon_s3_buckets");
        add("data_file_folders");
        add("blueprint_elements");
        add("in_collections");
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
        add("databases");
        add("data_files");
        add("idoc_types");
        add("transformation_projects");
        add("data_connections");
        add("amazon_s3_buckets");
        add("data_file_folders");
        add("location");
        add("network_node");
        add("imported_from");
        add("blueprint_elements");
        add("in_collections");
        add("created_by");
        add("created_on");
        add("modified_by");
        add("modified_on");
    }};
    public static final List<String> getNonRelationshipProperties() { return NON_RELATIONAL_PROPERTIES; }
    public static final List<String> getPagedRelationshipProperties() { return PAGED_RELATIONAL_PROPERTIES; }
    public static final List<String> getAllProperties() { return ALL_PROPERTIES; }
    public static final Boolean isHost(Object obj) { return (obj.getClass() == Host.class); }

}
