/* SPDX-License-Identifier: Apache-2.0 */
package org.odpi.openmetadata.accessservices.assetlineage.util;

public final class Constants {

    private Constants() {
    }

    public static final String GLOSSARY_TERM_TYPE_NAME = "GlossaryTerm";
    public static final String DERIVED_RELATIONAL_COLUMN = "DerivedRelationalColumn";
    public static final String DERIVED_SCHEMA_ATTRIBUTE = "DerivedSchemaAttribute";
    public static final String ASSET = "Asset";
    public static final String SCHEMA_ELEMENT = "SchemaElement";
    public static final String GLOSSARY_TERM = "GlossaryTerm";

    //Area 5 Types
    public static final String RELATIONAL_COLUMN = "RelationalColumn";
    public static final String RELATIONAL_TABLE = "RelationalTable";
    public static final String DEPLOYED_DB_SCHEMA_TYPE = "DeployedDatabaseSchema";
    public static final String DATA_STORE = "DataStore";

    //Relationships Type
    public static final String SCHEMA_ATTRIBUTE_TYPE = "SchemaAttributeType";
    public static final String SCHEMA_ATTRIBUTE = "SchemaAttribute";
    public static final String ATTRIBUTE_FOR_SCHEMA = "AttributeForSchema";
    public static final String COMPLEX_SCHEMA_TYPE = "ComplexSchemaType";
    public static final String ASSET_SCHEMA_TYPE = "AssetSchemaType";
    public static final String CONNECTION_TO_ASSET = "ConnectionToAsset";
    public static final String CONNECTION_CONNECTOR_TYPE = "ConnectionConnectorType";
    public static final String CONNECTION_ENDPOINT = "ConnectionEndpoint";
    public static final String DATA_CONTENT_FOR_DATA_SET = "DataContentForDataSet";
    public static final String SEMANTIC_ASSIGNMENT = "SemanticAssignment";
    public static final String TERM_CATEGORIZATION = "TermCategorization";

    //Instance Properties fields
    public static final String DISPLAY_NAME = "displayName";
    public static final String AUTHOR = "author";
    public static final String VERSION_NUMBER = "versionNumber";
    public static final String OWNER = "owner";
    public static final String ENCODING_STANDARD = "encodingStandard";
    public static final String USAGE = "usage";
    public static final String DESCRIPTION = "description";
    public static final String NETWORK_ADDRESS = "networkAddress";
    public static final String PROTOCOL = "protocol";
    public static final String ENCRYPTION_METHOD = "encryptionMethod";
    public static final String CONNECTOR_PROVIDER_CLASS_NAME = "connectorProviderClassName";
    public static final String SECURED_PROPERTIES = "securedProperties";
    public static final String ADDITIONAL_PROPERTIES = "additionalProperties";
    public static final String TYPE = "dataType";
    public static final String QUALIFIED_NAME = "qualifiedName";
    public static final String NAME = "name";
}