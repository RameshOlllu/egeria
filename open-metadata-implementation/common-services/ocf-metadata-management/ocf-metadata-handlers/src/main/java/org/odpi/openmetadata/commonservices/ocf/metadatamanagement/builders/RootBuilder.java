/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.commonservices.ocf.metadatamanagement.builders;

import org.odpi.openmetadata.commonservices.ocf.metadatamanagement.ffdc.OMAGOCFErrorCode;
import org.odpi.openmetadata.commonservices.repositoryhandler.RepositoryErrorHandler;
import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.properties.beans.Classification;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.InstanceProperties;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * RootBuilder provides the super class for builders.
 * Builders create Open Metadata Repository Services (OMRS) objects based on the
 * bean properties supplied in the constructor.
 */
public class RootBuilder
{
    protected RepositoryErrorHandler errorHandler;
    protected OMRSRepositoryHelper   repositoryHelper;
    protected String                 serviceName;
    protected String                 serverName;
    protected List<Classification>   classifications = null;


    /**
     * Constructor.
     *
     * @param repositoryHelper helper methods
     * @param serviceName name of this OMAS
     * @param serverName name of local server
     */
    protected RootBuilder(OMRSRepositoryHelper repositoryHelper,
                          String               serviceName,
                          String               serverName)
    {
        this.repositoryHelper = repositoryHelper;
        this.serviceName = serviceName;
        this.serverName = serverName;

        this.errorHandler = new RepositoryErrorHandler(serviceName, serverName);
    }


    /**
     * Set up the classifications associated with the entity.
     *
     * @param classifications list of classification objects
     */
    public void setClassifications(List<Classification> classifications)
    {
        this.classifications = classifications;
    }


    /**
     * Return a list of entity classifications that can be stored in the metadata
     * repository.
     *
     * @param methodName calling method
     * @return list of entity classification objects
     * @throws InvalidParameterException the properties of the classification are flawed
     */
    public List<org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification> getEntityClassifications(String   methodName) throws InvalidParameterException
    {
        if (classifications == null)
        {
            return null;
        }
        else if (classifications.isEmpty())
        {
            return null;
        }

        List<org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification> entityClassifications = new ArrayList<>();

        for (Classification  classification : classifications)
        {
            if (classification != null)
            {
                org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification entityClassification = new org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Classification();

                if (classification.getClassificationName() == null)
                {
                    OMAGOCFErrorCode errorCode = OMAGOCFErrorCode.NULL_CLASSIFICATION_NAME;
                    String           errorMessage = errorCode.getErrorMessageId()
                                                  + errorCode.getFormattedErrorMessage(serviceName, methodName);

                    throw new InvalidParameterException(errorCode.getHTTPErrorCode(),
                                                        this.getClass().getName(),
                                                        methodName,
                                                        errorMessage,
                                                        errorCode.getSystemAction(),
                                                        errorCode.getUserAction(),
                                                        "Classification name");
                }

                entityClassification.setName(classification.getClassificationName());

                try
                {
                    entityClassification.setProperties(repositoryHelper.addPropertyMapToInstance(serviceName,
                                                                                                 null,
                                                                                                 classification.getClassificationProperties(),
                                                                                                 methodName));
                }
                catch (org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidParameterException error)
                {
                    OMAGOCFErrorCode errorCode = OMAGOCFErrorCode.BAD_CLASSIFICATION_PROPERTIES;
                    String           errorMessage = errorCode.getErrorMessageId()
                                                  + errorCode.getFormattedErrorMessage(serviceName,
                                                                                       classification.getClassificationName(),
                                                                                       error.getMessage());

                    throw new InvalidParameterException(errorCode.getHTTPErrorCode(),
                                                        this.getClass().getName(),
                                                        methodName,
                                                        errorMessage,
                                                        errorCode.getSystemAction(),
                                                        errorCode.getUserAction(),
                                                        error,
                                                        "Properties for classification " + classification.getClassificationName());
                }

            }
        }

        return entityClassifications;
    }


    /**
     * Return the supplied bean properties in an InstanceProperties object.
     *
     * @param methodName name of the calling method
     * @return InstanceProperties object
     * @throws InvalidParameterException there is a problem with the properties
     */
    protected InstanceProperties getInstanceProperties(String  methodName) throws InvalidParameterException
    {
        return null;
    }
}
