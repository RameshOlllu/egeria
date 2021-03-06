/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.governanceengine.client;

import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.ClassificationNotFoundException;
import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.GuidNotFoundException;
import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.InvalidParameterException;
import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.MetadataServerException;
import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.TypeNotFoundException;
import org.odpi.openmetadata.accessservices.governanceengine.api.ffdc.exceptions.UserNotAuthorizedException;
import org.odpi.openmetadata.accessservices.governanceengine.api.objects.GovernedAsset;
import org.odpi.openmetadata.accessservices.governanceengine.api.objects.SoftwareServerCapability;

import java.util.List;

/**
 * The Governance Engine Open Metadata Access Service (OMAS) is used by enforcement engines to retrieve
 * asset and classification information in a suitable form for implementing policies
 * <p>
 * This OMAS is mostly concerned with:
 * - A Classification Definition - this tells us what the classification type is, what parms it may have - and can be useful
 * for authoring and validation
 * - An asset , or part (hence we call it an asset component) that has a classification
 * <p>
 * Furthermore in order to scope queries we restrict by
 * - root classification - the node in the classification tree of where we are interested (for example all governance classifications)
 * - root type           - the base type that we are interested in
 */
public interface GovernanceEngineInterface {
    /**
     * @param userId         - String - userId of user making request.
     * @param classification - String - name of base classification type (can be null)
     * @param type           - String - root type of asset (can be null)
     * @return AssetTagMap                          - map of classification
     * @throws InvalidParameterException       - one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException      - the requesting user is not authorized to issue this request.
     * @throws ClassificationNotFoundException - the classification to scope search is not found
     * @throws TypeNotFoundException           - the classification to scope search is not found
     * @throws MetadataServerException         - A failure occurred communicating with the metadata repository
     */
    List<GovernedAsset> getGovernedAssetList(String userId, String classification, String type)
            throws InvalidParameterException, UserNotAuthorizedException, ClassificationNotFoundException, MetadataServerException, TypeNotFoundException;

    /**
     * @param userId    - String - userId of user making request.
     * @param assetGuid - String - guid of asset component
     * @return AssetTagMap                  - map of classification
     * @throws InvalidParameterException  - one of the parameters is null or invalid.
     * @throws UserNotAuthorizedException - the requesting user is not authorized to issue this request.
     * @throws MetadataServerException    - A failure occurred communicating with the metadata repository
     * @throws GuidNotFoundException      - the guid is not found
     */
    GovernedAsset getGovernedAsset(String userId, String assetGuid)
            throws InvalidParameterException, UserNotAuthorizedException, MetadataServerException, GuidNotFoundException;


    SoftwareServerCapability createSoftwareServerCapability(String userId, SoftwareServerCapability softwareServerCapability) throws InvalidParameterException, MetadataServerException;

    SoftwareServerCapability getSoftwareServerCapabilityByGUID(String userId, String guid) throws InvalidParameterException;
}
