
<!-- SPDX-License-Identifier: CC-BY-4.0 -->
<!-- Copyright Contributors to the ODPi Egeria project. -->

# Retrieve tables of a database

Retrieve list of tables belonging to a database using pagination

```

POST {{url-omas}}/servers/{{server-id-omas}}/open-metadata/access-services/information-view/users/{{user-id}}/databases/{{database-guid}}/tables?pageSize=10&startFrom=0

TableListResponse response with list of tables from database or
VoidResponse with error message in case of error

{
    "class": "TableListResponse",
    "relatedHTTPCode": 200,
    "tableList": [
        {
            "class": "TableSource",
            "@id": 1,
            "guid": "b1c497ce.54bd3a08.0v9mgsb2t.fae21gd.ehu9t3.egljqf3hf176clmuugvlc",
            "name": "EMPSALARYANALYSIS",
            "schemaName": "DB2INST1"
        }
    ]
}

```
----
License: [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/),
Copyright Contributors to the ODPi Egeria project.
