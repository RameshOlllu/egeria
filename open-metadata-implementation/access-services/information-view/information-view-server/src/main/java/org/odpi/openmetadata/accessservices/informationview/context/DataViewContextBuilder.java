/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.informationview.context;

import org.odpi.openmetadata.accessservices.informationview.contentmanager.OMEntityDao;
import org.odpi.openmetadata.accessservices.informationview.events.BusinessTerm;
import org.odpi.openmetadata.accessservices.informationview.events.DataView;
import org.odpi.openmetadata.accessservices.informationview.events.DataViewColumn;
import org.odpi.openmetadata.accessservices.informationview.events.DataViewElement;
import org.odpi.openmetadata.accessservices.informationview.events.DataViewSource;
import org.odpi.openmetadata.accessservices.informationview.events.DataViewModel;
import org.odpi.openmetadata.accessservices.informationview.events.Source;
import org.odpi.openmetadata.accessservices.informationview.ffdc.InformationViewErrorCode;
import org.odpi.openmetadata.accessservices.informationview.ffdc.exceptions.runtime.EntityNotFoundException;
import org.odpi.openmetadata.accessservices.informationview.lookup.DataViewLookup;
import org.odpi.openmetadata.accessservices.informationview.utils.Constants;
import org.odpi.openmetadata.repositoryservices.auditlog.OMRSAuditLog;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityDetail;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.EntityProxy;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.properties.instances.Relationship;
import org.odpi.openmetadata.repositoryservices.connectors.stores.metadatacollectionstore.repositoryconnector.OMRSRepositoryConnector;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.EntityNotKnownException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.FunctionNotSupportedException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.InvalidParameterException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PagingErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.PropertyErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.RepositoryErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.TypeErrorException;
import org.odpi.openmetadata.repositoryservices.ffdc.exception.UserNotAuthorizedException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.odpi.openmetadata.accessservices.informationview.ffdc.ExceptionHandler.throwRetrieveRelationshipException;

public class DataViewContextBuilder extends ContextBuilder<DataViewElement>{

    private DataViewLookup dataViewLookup;

    public DataViewContextBuilder(OMRSRepositoryConnector enterpriseConnector, OMEntityDao entityDao, OMRSAuditLog auditLog) {
        super(enterpriseConnector, entityDao, auditLog);
        this.dataViewLookup = new DataViewLookup(enterpriseConnector, entityDao,null, auditLog);
    }


    /**
     *
     * @param dataViewId - id of the data view to retrieve
     * @return bean describing full structure of data view
     */
    public DataView retrieveDataView(String dataViewId) {
        DataViewSource source = new DataViewSource();
        source.setId(dataViewId);
        EntityDetail dataViewEntity;
        try {
            dataViewEntity = dataViewLookup.lookupEntity(source);
        } catch (UserNotAuthorizedException | FunctionNotSupportedException | PagingErrorException | TypeErrorException | PropertyErrorException | RepositoryErrorException | InvalidParameterException e) {
            throw new EntityNotFoundException(InformationViewErrorCode.ENTITY_NOT_FOUND_EXCEPTION.getHttpErrorCode(),
                                            DataViewLookup.class.getName(),
                                            InformationViewErrorCode.ENTITY_NOT_FOUND_EXCEPTION.getFormattedErrorMessage("source", source.toString()),
                                            InformationViewErrorCode.ENTITY_NOT_FOUND_EXCEPTION.getSystemAction(),
                                            InformationViewErrorCode.ENTITY_NOT_FOUND_EXCEPTION.getUserAction(),
                                            null);
        }
        return buildDataView(dataViewEntity);
    }

    /**
     *
     * @param dataViewEntity - entity describing the top level properties of the view
     * @return
     */
    private DataView buildDataView(EntityDetail dataViewEntity) {
        DataView dataView = new DataView();
        dataView.setGuid(dataViewEntity.getGUID());
        dataView.setAuthor(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.AUTHOR, dataViewEntity.getProperties(), "retrieveDataView"));
        dataView.setLastModifier(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.LAST_MODIFIER, dataViewEntity.getProperties(), "retrieveDataView"));
        Date lastModifiedDate = enterpriseConnector.getRepositoryHelper().getDateProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.LAST_MODIFIED_TIME, dataViewEntity.getProperties(), "retrieveDataView");
        if(lastModifiedDate!=null) {
            dataView.setLastModifiedTime(lastModifiedDate.getTime());
        }
        Date createdTime = enterpriseConnector.getRepositoryHelper().getDateProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.CREATE_TIME, dataViewEntity.getProperties(), "retrieveDataView");
        if(createdTime!=null) {
            dataView.setCreatedTime(createdTime.getTime());
        }
        dataView.setId(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.ID, dataViewEntity.getProperties(), "retrieveDataView"));
        dataView.setNativeClass(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.NATIVE_CLASS, dataViewEntity.getProperties(), "retrieveDataView"));
        dataView.setEndpointAddress(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.NETWORK_ADDRESS, dataViewEntity.getProperties(), "retrieveDataView"));
        dataView.setName(enterpriseConnector.getRepositoryHelper().getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.NAME, dataViewEntity.getProperties(), "retrieveDataView"));

        addDataViewStructure(dataView, dataViewEntity);

        return dataView;
    }

    /**
     *
     * @param dataView bean representing the data view
     * @param dataViewEntity entity describing the top level entity
     */
    private void addDataViewStructure(DataView dataView, EntityDetail dataViewEntity) {
        String dataViewGuid = dataViewEntity.getGUID();
        List<Relationship> relationships = getAssetSchemaTypeRelationships(dataViewGuid);
        if(relationships == null || relationships.isEmpty())
            return;
        EntityProxy assetSchemaType = relationships.get(0).getEntityTwoProxy();
        dataView.setElements(getChildrenElements(assetSchemaType.getGUID()));
    }


    /**
     *
     * @param entityDetail entity describing the data view element
     * @return
     */
    DataViewElement buildElement(EntityDetail entityDetail) {

        String methodName = "buildElement";
        if (entityDetail.getType().getTypeDefName().equals(Constants.SCHEMA_ATTRIBUTE)) {
            DataViewModel dataViewElement = new DataViewModel();
            dataViewElement.setName(omrsRepositoryHelper.getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME,
                    Constants.NAME, entityDetail.getProperties(), methodName));
            try {
                List<Relationship> schemaType = entityDao.getRelationships(Constants.SCHEMA_ATTRIBUTE_TYPE,
                        entityDetail.getGUID());
                if (schemaType != null && !schemaType.isEmpty()) {
                    dataViewElement.setElements(getChildrenElements(schemaType.get(0).getEntityTwoProxy().getGUID()));
                }
            } catch (RepositoryErrorException | UserNotAuthorizedException | EntityNotKnownException | FunctionNotSupportedException | InvalidParameterException | PropertyErrorException | TypeErrorException | PagingErrorException e) {
                throwRetrieveRelationshipException(entityDetail.getGUID(), Constants.ASSET_SCHEMA_TYPE, e,
                        DataViewContextBuilder.class.getName());
            }
            return dataViewElement;
        } else {
            DataViewColumn dataViewElement = new DataViewColumn();
            dataViewElement.setName(omrsRepositoryHelper.getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME,
                    Constants.NAME, entityDetail.getProperties(), methodName));
            dataViewElement.setUsage(omrsRepositoryHelper.getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME,
                    Constants.USAGE, entityDetail.getProperties(), methodName));
            dataViewElement.setComment(omrsRepositoryHelper.getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME,
                    Constants.COMMENT, entityDetail.getProperties(), methodName));
            dataViewElement.setRegularAggregate(omrsRepositoryHelper.getStringProperty(Constants.INFORMATION_VIEW_OMAS_NAME, Constants.AGGREGATING_FUNCTION, entityDetail.getProperties(), methodName));
            List<BusinessTerm> businessTerms = getAssignedBusinessTerms(entityDetail.getGUID());
            if (businessTerms != null && !businessTerms.isEmpty()) {
                dataViewElement.setBusinessTerms(businessTerms);
            }
            dataViewElement.setSources(getSources(entityDetail.getGUID()));
            return dataViewElement;
        }
    }

    private List<Source> getSources(String guid) {
        return null;
    }


}
