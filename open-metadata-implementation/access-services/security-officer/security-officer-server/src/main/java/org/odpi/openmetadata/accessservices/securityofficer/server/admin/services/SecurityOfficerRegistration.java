/*
 *  SPDX-License-Identifier: Apache-2.0
 *  Copyright Contributors to the ODPi Egeria project.
 */
package org.odpi.openmetadata.accessservices.securityofficer.server.admin.services;

import org.odpi.openmetadata.accessservices.securityofficer.server.admin.admin.SecurityOfficerAdmin;
import org.odpi.openmetadata.adminservices.OMAGAccessServiceRegistration;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceDescription;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceOperationalStatus;
import org.odpi.openmetadata.adminservices.configuration.registration.AccessServiceRegistration;

/**
 * SecurityOfficerRegistration registers the access service with the OMAG Server administration services.
 * This registration must be driven once at server start up.  The OMAG Server administration services
 * then use this registration information as confirmation that there is an implementation of this
 * access service in the server and it can be configured and used.
 */
public class SecurityOfficerRegistration {
    /**
     * Pass information about this access service to the OMAG Server administration services.
     */
    public static void registerAccessService() {
        AccessServiceDescription myDescription = AccessServiceDescription.SECURITY_OFFICER_OMAS;

        AccessServiceRegistration myRegistration = new AccessServiceRegistration(myDescription,
                AccessServiceOperationalStatus.ENABLED,
                SecurityOfficerAdmin.class.getName());
        OMAGAccessServiceRegistration.registerAccessService(myRegistration);
    }
}