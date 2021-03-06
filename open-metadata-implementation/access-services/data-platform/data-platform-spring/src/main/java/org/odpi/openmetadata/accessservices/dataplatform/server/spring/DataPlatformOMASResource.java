/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.accessservices.dataplatform.server.spring;

import org.odpi.openmetadata.accessservices.dataplatform.responses.RegistrationRequestBody;
import org.odpi.openmetadata.accessservices.dataplatform.server.DataPlatformRestServices;
import org.odpi.openmetadata.commonservices.ffdc.rest.GUIDResponse;
import org.springframework.web.bind.annotation.*;

/**
 * The type Data platform omas resource.
 */
@RestController
@RequestMapping("/servers/{serverName}/open-metadata/access-services/data-platform/users/{userId}")
public class DataPlatformOMASResource {

    private DataPlatformRestServices restAPI = new DataPlatformRestServices();

    /**
     * Instantiates a new Data Platform omas resource.
     */
    public DataPlatformOMASResource() {
    }

    /**
     * Create a software server capability entity
     *
     * @param serverName  name of server instance to call
     * @param userId      the name of the calling user
     * @param requestBody properties of the entity
     * @return unique identifier of the created process
     */
    @PostMapping(path = "/software-server-capabilities")
    public GUIDResponse createSoftwareServerCapability(@PathVariable("serverName") String serverName,
                                                       @PathVariable("userId") String userId,
                                                       @RequestBody RegistrationRequestBody requestBody) {
        return restAPI.createSoftwareServer(serverName, userId, requestBody);
    }

    /**
     * Return the software server capability by qualified name.
     *
     * @param serverName    the server name
     * @param userId        the user id
     * @param qualifiedName the qualified name
     * @return the software server capability by qualified name
     */
    @GetMapping(path = "/software-server-capabilities/{qualifiedName}")
    public RegistrationRequestBody getSoftwareServerCapabilityByQualifiedName(@PathVariable String serverName,
                                                                              @PathVariable String userId,
                                                                              @PathVariable String qualifiedName) {
        return restAPI.getSoftwareServerCapabilityByQualifiedName(serverName, userId, qualifiedName);
    }

}