/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.conformance.beans;

import org.odpi.openmetadata.conformance.ffdc.exception.AssertionFailureException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OpenMetadataTestCase is the superclass for an open metadata conformance test.  It manages the
 * test environment and reporting.
 */
public abstract class OpenMetadataTestCase
{
    private static final String  documentationRootURL = "https://egeria.odpi.org/open-metadata-conformance-suite/docs/";

    protected String  testCaseId = "<Unknown>";
    protected String  testCaseName = "<Unknown>";
    protected String  testCaseDescriptionURL = "<Unknown>";

    protected Integer defaultProfileId = null;
    protected Integer defaultRequirementId = null;

    protected OpenMetadataConformanceWorkbenchWorkPad  workPad = null;

    protected List<String>        successfulAssertions   = new ArrayList<>();
    protected List<String>        unsuccessfulAssertions = new ArrayList<>();
    protected List<String>        notSupportedAssertions = new ArrayList<>();
    protected Map<String, Object> discoveredProperties   = new HashMap<>();

    protected ExceptionBean       exceptionBean          = null;
    protected String              successMessage         = null;



    /**
     * Default constructor
     */
    public OpenMetadataTestCase()
    {
    }


    /**
     * Typical constructor used when the test case Id is fixed.
     *
     * @param workPad location for workbench results
     * @param testCaseId identifier of test case
     * @param testCaseName name of test case
     * @param defaultProfileId identifier of default profile (for unexpected exceptions)
     * @param defaultRequirementId identifier of default required (for unexpected exceptions)
     */
    public OpenMetadataTestCase(OpenMetadataConformanceWorkbenchWorkPad workPad,
                                String                                  testCaseId,
                                String                                  testCaseName,
                                Integer                                 defaultProfileId,
                                Integer                                 defaultRequirementId)
    {
        final String methodName = "OpenMetadataTestCase";

        this.testCaseId = testCaseId;
        this.testCaseName = testCaseName;
        this.testCaseDescriptionURL = documentationRootURL + workPad.getWorkbenchId() + "/test-cases/" + testCaseId + "-test-case.md";
        this.defaultProfileId = defaultProfileId;
        this.defaultRequirementId = defaultRequirementId;
        this.workPad = workPad;

        workPad.registerTestCase(this);
    }


    /**
     * Typical constructor used when the test case Id needs to be constructed by the test case code.
     *
     * @param workPad location for workbench results
     * @param defaultProfileId identifier of default profile (for unexpected exceptions)
     * @param defaultRequirementId identifier of default required (for unexpected exceptions)
     */
    public OpenMetadataTestCase(OpenMetadataConformanceWorkbenchWorkPad workPad,
                                Integer                                 defaultProfileId,
                                Integer                                 defaultRequirementId)
    {
        this.defaultProfileId = defaultProfileId;
        this.defaultRequirementId = defaultRequirementId;
        this.workPad = workPad;
    }


    /**
     * Update the test case Id, name and documentation URL if not already supplied in the constructor.
     *
     * @param testCaseRootId common identifier of test case
     * @param testCaseId unique identifier of test case
     * @param testCaseName name of test case
     */
    protected  void updateTestId(String                                  testCaseRootId,
                                 String                                  testCaseId,
                                 String                                  testCaseName)
    {
        this.testCaseId = testCaseId;
        this.testCaseName = testCaseName;
        this.testCaseDescriptionURL = documentationRootURL + workPad.getWorkbenchId() + "/test-cases/" + testCaseRootId + "-test-case.md";

        workPad.registerTestCase(this);
    }


    /**
     * Log that the test case is starting.
     *
     * @param methodName calling method name
     */
    protected abstract void logTestStart(String methodName);


    /**
     * Log that the test case is ending.
     *
     * @param methodName calling method name
     */
    protected abstract void logTestEnd(String methodName);


    /**
     * Return the unique identifier of the test case.
     *
     * @return string id
     */
    public String getTestCaseId()
    {
        return testCaseId;
    }


    /**
     * Return the display name of the test case.
     *
     * @return string name
     */
    public String getTestCaseName()
    {
        return testCaseName;
    }


    /**
     * Return the URL of the description of the test case.
     *
     * @return string url
     */
    public String getTestCaseDescriptionURL()
    {
        return testCaseDescriptionURL;
    }


    /**
     * Has the test case been ran yet?
     *
     * @return boolean flag
     */
    public boolean isTestRan()
    {
        return ((! successfulAssertions.isEmpty()) || (! unsuccessfulAssertions.isEmpty()));
    }


    /**
     * Has the test case passed? If it has not run then false is returned.
     *
     * @return boolean flag
     */
    public boolean isTestPassed()
    {
        return (this.isTestRan() && (unsuccessfulAssertions.isEmpty()));
    }


    /**
     * Return the result object for this test case.  It will be null if the test case has not run.
     *
     * @return result bean (or null if the test has not yet been run).
     */
    public OpenMetadataTestCaseResult getResult()
    {
        OpenMetadataTestCaseResult result = null;

        if (isTestRan())
        {
            result = new OpenMetadataTestCaseResult(this);

            result.setConformanceException(exceptionBean);

            result.setSuccessfulAssertions(successfulAssertions);
            result.setUnsuccessfulAssertions(unsuccessfulAssertions);
            result.setNotSupportedAssertions(notSupportedAssertions);

            if (!discoveredProperties.isEmpty())
            {
                result.setDiscoveredProperties(discoveredProperties);
            }

            if (isTestPassed())
            {
                result.setSuccessMessage(successMessage);
            }
        }

        return result;
    }


    /**
     * Return a summary bean for this test case.
     *
     * @return summary bean
     */
    public OpenMetadataTestCaseSummary getSummary()
    {
        return new OpenMetadataTestCaseSummary(this);
    }


    /**
     * Throw an exception if the condition is not true; else return
     *
     * @param condition condition to test
     * @param assertionId identifier for the assertion
     * @param assertionMessage descriptive message of the assertion
     * @param profileId identifier of profile for this assertion
     * @param requirementId identifier of requirement for this assertion
     * @throws AssertionFailureException condition was false
     */
    protected void assertCondition(boolean   condition,
                                   String    assertionId,
                                   String    assertionMessage,
                                   Integer   profileId,
                                   Integer   requirementId) throws AssertionFailureException
    {
        if (condition)
        {
            successfulAssertions.add(assertionId + ": " +assertionMessage);
            workPad.addSuccessfulCondition(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage);
            return;
        }

        unsuccessfulAssertions.add(assertionId + ": " + assertionMessage);
        workPad.addUnsuccessfulCondition(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage);
        throw new AssertionFailureException(assertionId, assertionMessage);
    }


    /**
     * Log if the condition is not true; else return
     *
     * @param condition condition to test
     * @param assertionId identifier for the assertion
     * @param assertionMessage descriptive message of the assertion
     * @param profileId identifier of profile for this assertion
     * @param requirementId identifier of requirement for this assertion
     */
    protected void verifyCondition(boolean   condition,
                                   String    assertionId,
                                   String    assertionMessage,
                                   Integer   profileId,
                                   Integer   requirementId)
    {
        if (condition)
        {
            successfulAssertions.add(assertionMessage);
            workPad.addSuccessfulCondition(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage);
            return;
        }

        unsuccessfulAssertions.add(assertionId + ": " + assertionMessage);
        workPad.addUnsuccessfulCondition(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage);
    }


    /**
     * Log the correct response to an unsupported function.
     *
     * @param assertionId identifier for the assertion
     * @param assertionMessage descriptive message of the assertion
     * @param profileId identifier of profile for this assertion
     * @param requirementId identifier of requirement for this assertion
     */
    protected void addNotSupportedAssertion(String    assertionId,
                                            String    assertionMessage,
                                            Integer   profileId,
                                            Integer   requirementId)
    {
        notSupportedAssertions.add(assertionId + ": " + assertionMessage);
        workPad.addNotSupportedCondition(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage);
    }


    /**
     * Add the name and value of a discovered property that is relevant to a specific requirement within a profile.
     *
     * @param propertyName name of the property
     * @param propertyValue value of the property as object
     * @param profileId identifier of profile
     * @param requirementId identifier of requirement within the profile
     */
    protected void addDiscoveredProperty(String    propertyName,
                                         Object    propertyValue,
                                         Integer   profileId,
                                         Integer   requirementId)
    {
        discoveredProperties.put(propertyName, propertyValue);
        workPad.addDiscoveredProperty(profileId, requirementId, testCaseId, testCaseName, testCaseDescriptionURL, propertyName, propertyValue);
    }


    /**
     * Set up the success message.
     *
     * @param message text of message
     */
    protected void setSuccessMessage(String  message)
    {
        successMessage = message;
    }


    /**
     * Request from the workbench to log the start of an asynchronous test.
     */
    public void startAsynchronousTest()
    {
        final String methodName = "startAsynchronousTest";

        this.logTestStart(methodName);
    }


    /**
     * Request from the workbench to log the start of an asynchronous test.
     */
    public void endAsynchronousTest()
    {
        final String methodName = "endAsynchronousTest";

        this.logTestEnd(methodName);
    }


    /**
     * Request from the workbench to execute this test and generate a result object.  This method is used for
     * synchronous test cases.
     */
    public void executeTest()
    {
        final String methodName = "executeTest";

        this.logTestStart(methodName);

        try
        {
            /*
             * Delegate to subclass
             */
            this.run();
        }
        catch (AssertionFailureException   exception)
        {
        }
        catch (Throwable   exception)
        {
            String   assertionMessage = "test-case-base-01: Unexpected Exception " + exception.getClass().getSimpleName();

            this.unsuccessfulAssertions.add(assertionMessage);

            exceptionBean = new ExceptionBean();

            exceptionBean.setErrorMessage(exception.getMessage());
            exceptionBean.setExceptionClassName(exception.getClass().getName());

            workPad.addUnexpectedException(defaultProfileId, defaultRequirementId, testCaseId, testCaseName, testCaseDescriptionURL, assertionMessage, exceptionBean);
        }

        this.logTestEnd(methodName);
    }


    /**
     * Method implemented by the actual test case.
     *
     * @throws Exception something went wrong with the test.
     */
    protected abstract void run() throws Exception;


    /**
     * toString() JSON-style
     *
     * @return string description
     */
    @Override
    public String toString()
    {
        return "OpenMetadataTestCase{" +
                "testCaseId='" + testCaseId + '\'' +
                ", testCaseName='" + testCaseName + '\'' +
                ", testCaseDescriptionURL='" + testCaseDescriptionURL + '\'' +
                ", defaultProfileId=" + defaultProfileId +
                ", defaultRequirementId=" + defaultRequirementId +
                ", successfulAssertions=" + successfulAssertions +
                ", unsuccessfulAssertions=" + unsuccessfulAssertions +
                ", notSupportedAssertions=" + notSupportedAssertions +
                ", discoveredProperties=" + discoveredProperties +
                ", exceptionBean=" + exceptionBean +
                ", successMessage='" + successMessage + '\'' +
                ", testRan=" + isTestRan() +
                ", testPassed=" + isTestPassed() +
                ", result=" + getResult() +
                ", summary=" + getSummary() +
                '}';
    }
}
