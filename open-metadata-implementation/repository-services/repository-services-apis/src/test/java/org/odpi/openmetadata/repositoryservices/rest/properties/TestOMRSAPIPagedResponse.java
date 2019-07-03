/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */

package org.odpi.openmetadata.repositoryservices.rest.properties;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Test the overridden methods of TestOMRSAPIPagedResponse
 */
public class TestOMRSAPIPagedResponse
{
    @Test public void TestToString()
    {
        assertTrue(new MockAPIPagedResponse().toString().contains("OMRSRESTAPIPagedResponse"));
    }
}
