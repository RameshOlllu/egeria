/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.assetowner.client;

import org.odpi.openmetadata.accessservices.assetowner.api.AssetOnboardingCSVFileInterface;
import org.odpi.openmetadata.accessservices.assetowner.rest.NewFileAssetRequestBody;
import org.odpi.openmetadata.commonservices.ffdc.InvalidParameterHandler;
import org.odpi.openmetadata.commonservices.ffdc.RESTExceptionHandler;
import org.odpi.openmetadata.commonservices.ffdc.rest.GUIDResponse;
import org.odpi.openmetadata.frameworks.connectors.ffdc.InvalidParameterException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.PropertyServerException;
import org.odpi.openmetadata.frameworks.connectors.ffdc.UserNotAuthorizedException;

import java.util.List;

/**
 * CSVFileAssetOwner provides specialist methods for working with CSV files.
 */
public class CSVFileAssetOwner implements AssetOnboardingCSVFileInterface
{
    private String               serverName;               /* Initialized in constructor */
    private String               omasServerURL;            /* Initialized in constructor */
    private AssetOwnerRESTClient restClient;               /* Initialized in constructor */

    private InvalidParameterHandler invalidParameterHandler = new InvalidParameterHandler();
    private RESTExceptionHandler    exceptionHandler        = new RESTExceptionHandler();


    /**
     * Create a new client with no authentication embedded in the HTTP request.
     *
     * @param serverName name of the server to connect to
     * @param omasServerURL the network address of the server running the OMAS REST servers
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public CSVFileAssetOwner(String     serverName,
                             String     omasServerURL) throws InvalidParameterException
    {
        final String methodName = "Constructor (no security)";

        invalidParameterHandler.validateOMAGServerPlatformURL(omasServerURL, serverName, methodName);

        this.serverName = serverName;
        this.omasServerURL = omasServerURL;
        this.restClient = new AssetOwnerRESTClient(serverName, omasServerURL);
    }


    /**
     * Create a new client that passes userId and password in each HTTP request.  This is the
     * userId/password of the calling server.  The end user's userId is sent on each request.
     *
     * @param serverName name of the server to connect to
     * @param omasServerURL the network address of the server running the OMAS REST servers
     * @param userId caller's userId embedded in all HTTP requests
     * @param password caller's userId embedded in all HTTP requests
     * @throws InvalidParameterException there is a problem creating the client-side components to issue any
     * REST API calls.
     */
    public CSVFileAssetOwner(String     serverName,
                             String     omasServerURL,
                             String     userId,
                             String     password) throws InvalidParameterException
    {
        final String methodName = "Constructor (with security)";

        invalidParameterHandler.validateOMAGServerPlatformURL(omasServerURL, serverName, methodName);

        this.serverName = serverName;
        this.omasServerURL = omasServerURL;
        this.restClient = new AssetOwnerRESTClient(serverName, omasServerURL, userId, password);
    }


    /**
     * Add a simple asset description linked to a connection object for a CSV file.
     *
     * @param userId calling user (assumed to be the owner)
     * @param displayName display name for the file in the catalog
     * @param description description of the file in the catalog
     * @param fullPath full path of the file - used to access the file through the connector
     *
     * @return unique identifier (guid) of the asset
     *
     * @throws InvalidParameterException full path or userId is null
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    public String  addCSVFileToCatalog(String    userId,
                                       String    displayName,
                                       String    description,
                                       String    fullPath) throws InvalidParameterException,
                                                                  UserNotAuthorizedException,
                                                                  PropertyServerException
    {
        return this.addCSVFileToCatalog(userId,
                                        displayName,
                                        description,
                                        fullPath,
                                        null,
                                        null,
                                        null);
    }


    /**
     * Add a simple asset description linked to a connection object for a CSV file.
     *
     * @param userId calling user (assumed to be the owner)
     * @param displayName display name for the file in the catalog
     * @param description description of the file in the catalog
     * @param fullPath full path of the file - used to access the file through the connector
     * @param columnHeaders does the first line of the file contain the column names. If not pass the list of column headers.
     * @param delimiterCharacter what is the delimiter character - null for default of comma
     * @param quoteCharacter what is the character to group a field that contains delimiter characters
     * @return unique identifier (guid) of the asset
     *
     * @throws InvalidParameterException full path or userId is null
     * @throws PropertyServerException problem accessing property server
     * @throws UserNotAuthorizedException security access problem
     */
    public String  addCSVFileToCatalog(String       userId,
                                       String       displayName,
                                       String       description,
                                       String       fullPath,
                                       List<String> columnHeaders,
                                       Character    delimiterCharacter,
                                       Character    quoteCharacter) throws InvalidParameterException,
                                                                           UserNotAuthorizedException,
                                                                           PropertyServerException
    {
        final String   methodName = "addCSVFileToCatalog";
        final String   pathParameter = "fullPath";
        final String   urlTemplate = "/servers/{0}/open-metadata/access-services/asset-owner/users/{1}/assets/csv-files";

        invalidParameterHandler.validateUserId(userId, methodName);
        invalidParameterHandler.validateName(fullPath, pathParameter, methodName);

        NewFileAssetRequestBody requestBody = new NewFileAssetRequestBody();
        requestBody.setDisplayName(displayName);
        requestBody.setDescription(description);
        requestBody.setFullPath(fullPath);
        requestBody.setColumnHeaders(columnHeaders);
        requestBody.setDelimiterCharacter(delimiterCharacter);
        requestBody.setQuoteCharacter(quoteCharacter);

        GUIDResponse restResult = restClient.callGUIDPostRESTCall(methodName,
                                                                  omasServerURL + urlTemplate,
                                                                  requestBody,
                                                                  serverName,
                                                                  userId);

        exceptionHandler.detectAndThrowInvalidParameterException(methodName, restResult);
        exceptionHandler.detectAndThrowUserNotAuthorizedException(methodName, restResult);
        exceptionHandler.detectAndThrowPropertyServerException(methodName, restResult);

        return restResult.getGUID();
    }
}
