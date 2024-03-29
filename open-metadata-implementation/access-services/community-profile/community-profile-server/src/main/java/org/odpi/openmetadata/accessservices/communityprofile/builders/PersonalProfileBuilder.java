/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.communityprofile.builders;

import org.odpi.openmetadata.accessservices.communityprofile.mappers.PersonalProfileMapper;
import org.odpi.openmetadata.commonservices.ocf.metadatamanagement.builders.ReferenceableBuilder;
import org.odpi.openmetadata.commonservices.repositoryhandler.RepositoryErrorHandler;
import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * PersonalProfileBuilder creates repository entities and relationships from properties for a personal
 * profile.  Specifically, a single PersonalProfile is represented as a Person entity with an optional ContributionRecord
 * entity linked to the Person using a PersonalContribution relationship.  Each Person entity must be linked to
 * at least one UserIdentity via a ProfileIdentity relationship.  In addition, Person is optionally linked to
 * multiple ContactDetails entities via the ContactThrough relationship.
 */
public class PersonalProfileBuilder extends ReferenceableBuilder
{
    private static final Logger log = LoggerFactory.getLogger(PersonalProfileBuilder.class);

    /**
     * Simple constructor.
     *
     * @param qualifiedName unique name of this object
     * @param repositoryHelper helper class for formatting instances
     * @param serviceName name of this service
     * @param serverName name of this server
     */
    public PersonalProfileBuilder(String               qualifiedName,
                                  OMRSRepositoryHelper repositoryHelper,
                                  String               serviceName,
                                  String               serverName)
    {
        super(qualifiedName, repositoryHelper, serviceName, serverName);

        this.repositoryHelper = repositoryHelper;
        this.serviceName = serviceName;

        this.errorHandler = new RepositoryErrorHandler(serviceName, serverName);
    }


    /**
     * Create an instance properties object for a Person entity for an individual.
     *
     * @param fullName full name of the person.
     * @param name known name or nickname of the individual.
     * @param jobTitle job title of the individual.
     * @param description job description of the individual.
     * @param extendedProperties  properties about the individual for a new type that is the subclass of Person.
     * @param additionalProperties  additional properties about the individual.
     *
     * @return InstanceProperties object
     */
    public  InstanceProperties getPersonEntityProperties(String              name,
                                                         String              fullName,
                                                         String              jobTitle,
                                                         String              description,
                                                         Map<String, Object> extendedProperties,
                                                         Map<String, String> additionalProperties) throws InvalidParameterException
    {
        final String  methodName = "getPersonEntityProperties";

        InstanceProperties properties = super.getQualifiedNameInstanceProperties(methodName);

        if (fullName != null)
        {
            properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                      properties,
                                                                      PersonalProfileMapper.FULL_NAME_PROPERTY_NAME,
                                                                      fullName,
                                                                      methodName);
        }

        if (name != null)
        {
            properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                      properties,
                                                                      PersonalProfileMapper.NAME_PROPERTY_NAME,
                                                                      name,
                                                                      methodName);
        }

        if (jobTitle != null)
        {
            properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                      properties,
                                                                      PersonalProfileMapper.JOB_TITLE_PROPERTY_NAME,
                                                                      jobTitle,
                                                                      methodName);
        }


        if (description != null)
        {
            properties = repositoryHelper.addStringPropertyToInstance(serviceName,
                                                                      properties,
                                                                      PersonalProfileMapper.DESCRIPTION_PROPERTY_NAME,
                                                                      description,
                                                                      methodName);
        }


        if (extendedProperties != null)
        {
            try
            {
                properties = repositoryHelper.addPropertyMapToInstance(serviceName,
                                                                       null,
                                                                       extendedProperties,
                                                                       methodName);
            }
            catch (org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidParameterException error)
            {
                final String  propertyName = "extendedProperties";

                errorHandler.handleUnsupportedProperty(error, methodName, propertyName);
            }
        }


        if ((additionalProperties != null) && (! additionalProperties.isEmpty()))
        {
            properties = repositoryHelper.addStringMapPropertyToInstance(serviceName,
                                                                         properties,
                                                                         PersonalProfileMapper.ADDITIONAL_PROPERTIES_PROPERTY_NAME,
                                                                         additionalProperties,
                                                                         methodName);
        }

        log.debug("Instance properties: " + properties.toString());

        return properties;
    }
}

