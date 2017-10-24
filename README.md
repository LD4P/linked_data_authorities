# Linked Data Authorities by LD4L-Labs

This document describes general information about how to use external authorities directly, access the LD4L-Labs cache server, and how to setup a local cache of an external authory's linked data for query and use in an end-user application. 

NOTE: All the work in this repository is experimental.  You are welcome to try out any and all of the work described here.  We recommend that you contact the development team before attempting to use this in a production system.

## Vocabularies

There are a number of authorities that have been tested with the system architecture described in this document.
  
  * [qa_agrovoc](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_agrovoc/README.md)
  * [qa_dbpedia](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_dbpedia/README.md)
  * [qa_geonames](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_geonames/README.md)
  * [qa_loc](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_loc/README.md) (names, subjects, and genres)
  * [qa_nalt](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_nalt/README.md)  
  * [qa_oclcfast](https://github.com/ld4l-labs/linked_data_authories/tree/master/qa_oclcfas/README.md)  

TODO: Also include oclc_fast, agrovoc
  
See each of the sub-directories of this project starting with `qa_`.  Each addresses a separate authority.  Each vocabulary has it's own README that addresses configuration and setup specific to that authority.  General information about setup is in this README.

## Architecture Overview

The system described here is designed to process linked data search results into a format that is easily digestable by end applications.  It allows user interfaces to be designed to handle searching and presentation of linked data in a consistent way.  

There are two servers that drive this system.

1. linked data authority server - This server can be controlled by the authority provider or you can use a locally cached version of the authority.  It must be querable via curl with the query passed as a parameter.  Additionally, it must return a serialization of linked data (e.g. rdf-xml, json-ld, n-triples, turtle, etc.)

2. questioning authority normalization server - This server is an installation of the [questioning authority (qa) gem](https://rubygems.org/gems/qa).  A configuration file specific for the desired vocabulary is installed in the `config/authorities/linked_data` directory of the QA server.  This tells QA how to extract information from the linked data search results in order to normalize the results that are passed to the application.

More information on setting up these servers follows in the Usage section.

More information on working with linked data through the QA gem is available in it's README in section [Linked Open Data (LOD) Authorities](https://github.com/samvera/questioning_authority#linked-open-data-lod-authorities)


# Usage

## Set up a local linked data authority server (optional if accessing external authority directly)

### Basic Steps

These are the basic steps to follow for each authority.  I provide a longer list of tasks under Our Workflow as an example of some of the practical considerations.

* Setup a new triplestore for each authority to hold the cached linked data.
* Download the triples to a local file.
* Load the triples into the triplestore.  If you are using multiple authorities, it is recommended that you load each linked data authority triples into a separate triplestore to avoid issues with scale and cross contamination. 
* It is recommended that you create an index that can be used for efficient queries.

#### Our Setup

For reference, here is the server setup that we are using.

Hardware
* 8-core, 64gb 3Ghz Mac Pro (late 2013), macOS Sierra (10.12.6)
* 32tb Pegasus-2 Thunderbolt RAID configured as RAID-5

Software
* Apache Jena Fuseki 2.4.0 provides SPARQL endpoint
* Apache Tomcat 9.0 runs custom web application(s)
* Apache Lucene 3.6 provides search interface

Customizations
* custom per-data-source JSP web application provides search/browse/download functionality
* custom (generic) SPARQL Tag Library provides API for web apps (available at https://github.com/eichmann/lod-utilities)
* custom (generic) Lucene Tag Library provides API for web apps (availability on github TBA; SOLR equivalent TBA)

We keep multiple triplestores on the same machine using the same RAID.  Fuseki is happy talking to multiple underlying triplestores and allows you to easily switch between them in their web search interface.

#### Our Workflow

For reference, this is the full workflow we follow when adding a new authority's data.

* download RDF
* if necessary, convert to n-triples (required for GeoNames data, for instance)
* use tdbloader2 to populate a new triplestore
* configure Fuseki server(s) with triplestore details
* create new JSP project in Eclipse
* write one or more indexer programs that populate Lucene indices and run indexer(s)
* write search/browse/download application logic using the SPARQL and Lucene tags
* package project as war
* deploy to Apache Tomcat server(s)
* add new service to Apache HTTPD virtual host specification


## Set up questioning authority normalization server

### One time process

For your convenience, [QA Server](https://github.com/ld4l-labs/qa_server) app was created that can be used as the questioning authority normalization server.  See [QA Server's README](https://github.com/ld4l-labs/qa_server/blob/master/README.md) for Installation Instructions.

### Per vocabulary process

* Add a configuration file for each vocabulary you want to use to `/config/authorities/linked_data` in the server app.  
  
See QA Server's [Supported Authorities](https://github.com/ld4l-labs/qa_server/blob/master/README.md#supported-authorities) documentation for more information.


## Debugging

Because there are a number of systems integrating with each other, you should test the generated links at each level.

### Test that the linked data authority server returns expected RDF serialization.

Copy the search:url:template substitute an appropriate value for each variable mapping (e.g. {?query}, {?lang}, etc.).  Paste this in a browser or use curl to access.  Verify that a linked data serialization is returned.  NOTE: You might not see any data if your query does not produce any results.  The first step in debugging is to confirm that the query is expected to return results.

Sample json-ld results...

```
{"@context":
  {"skos":"http:\/\/www.w3.org\/2004\/02\/skos\/core#",
   "isothes":"http:\/\/purl.org\/iso25964\/skos-thes#",
   "onki":"http:\/\/schema.onki.fi\/onki#",
   "uri":"@id",
   "type":"@type",
   "results":
     {"@id":"onki:results",
      "@container":"@list"
     },
   "prefLabel":"skos:prefLabel",
   "altLabel":"skos:altLabel",
   "hiddenLabel":"skos:hiddenLabel",
   "@language":"en"
  },
 "uri":"",
 "results":
   [{"uri":"http:\/\/lod.nal.usda.gov\/nalt\/1293",
     "type":["skos:Concept"],
     "localname":"nalt\/1293","prefLabel":"16SrXI (Rice yellow dwarf group)",
     "lang":"en",
     "vocab":"nalt"
    },
    {"uri":"http:\/\/lod.nal.usda.gov\/nalt\/1892",
     "type":["skos:Concept"],
     "localname":"nalt\/1892",
     "prefLabel":"Acacia holosericea",
     "lang":"en",
     "vocab":"nalt"
    },
    {"uri":"http:\/\/lod.nal.usda.gov\/nalt\/1892",
    "type":["skos:Concept"],
    "localname":"nalt\/1892",
    "prefLabel":"Acacia holosericea",
    "lang":"en",
    "altLabel":"Acacia holosericea A. Cunn.",
    "vocab":"nalt"
   }
  ]
}    
```

### Test that QA returns the expected normalized search results

With the QA server running on port 3002 on your local machine, this will be something like...

http://localhost:3002/qa/search/linked_data/_VOCAB_?q=test&maxRecords=3

Substitute the name of the configuration file you are testing for `_VOCAB_`.

Sample qa_server search results...

```
[
  {"uri":"http://lod.nal.usda.gov/nalt/5133",
   "id":"http://lod.nal.usda.gov/nalt/5133",
   "label":"agglutination tests"
  },
  {"uri":"http://lod.nal.usda.gov/nalt/7182",
   "id":"http://lod.nal.usda.gov/nalt/7182",
   "label":"animal use alternatives"
  },
  {"uri":"http://lod.nal.usda.gov/nalt/1841",
   "id":"http://lod.nal.usda.gov/nalt/1841",
   "label":"intestinal absorption"}]
```

### Test that QA generates the expected linked data authority server URL

If you don't see any results, you can check that the correct URL for the linked data server is generated.  In the QA server, search log/development.log for `QA Linked Data search url:`.  Then you can copy/paste that URL into a browser or use curl in the terminal to verify that the generated URL accessing the linked data authority server actually returns data as expected.

### Test that QA returns the expected normalized term fetch results for search query

With the QA server running on port 3002 on your local machine, this will be something like...

http://localhost:3002/qa/show/linked_data/_VOCAB_/_URI_OR_ID_

Substitute the name of the configuration file you are testing for `_VOCAB_`.

Sample qa_server term fetch results...

```
{"uri":"http://id.worldcat.org/fast/262937",
"id":"262937",
"label":["Clemens, Olivia Langdon, 1845-1904"],
"altlabel":["Twain, Mark, Mrs., 1845-1904","Clemens, Samuel L., Mrs., 1845-1904","Clemens, Livy, 1845-1904","Langdon, Olivia, 1845-1904","Langdon, Livy, 1845-1904"],
"narrower":[""],
"broader":[""],
"sameas":["http://id.loc.gov/authorities/names/n89103996","https://viaf.org/viaf/3272855"],
"predicates":
  {"http://schema.org/name":["Twain, Mark, Mrs., 1845-1904","Clemens, Samuel L., Mrs., 1845-1904","Clemens, Livy, 1845-1904","Langdon, Olivia, 1845-1904","Langdon, Livy, 1845-1904","Clemens, Olivia Langdon, 1845-1904"],
  "http://www.w3.org/1999/02/22-rdf-syntax-ns#type":["http://schema.org/Person"],
  "http://www.w3.org/2004/02/skos/core#inScheme":["http://id.worldcat.org/fast/ontology/1.0/#fast","http://id.worldcat.org/fast/ontology/1.0/#facet-Personal"],
  "http://www.w3.org/2004/02/skos/core#prefLabel":["Clemens, Olivia Langdon, 1845-1904"],
  "http://purl.org/dc/terms/identifier":["262937"],
  "http://xmlns.com/foaf/0.1/focus":["http://en.wikipedia.org/wiki/Olivia_Langdon_Clemens"],
  "http://www.w3.org/2004/02/skos/core#altLabel":["Twain, Mark, Mrs., 1845-1904","Clemens, Samuel L., Mrs., 1845-1904","Clemens, Livy, 1845-1904","Langdon, Olivia, 1845-1904","Langdon, Livy, 1845-1904"],
  "http://schema.org/sameAs":["http://id.loc.gov/authorities/names/n89103996","https://viaf.org/viaf/3272855"]}}
```

### Test that QA generates the expected linked data authority server URL for term fetch

If you don't see any results, you can check that the correct URL for the linked data server is generated.  In the QA server, search log/development.log for `QA Linked Data term url:`.  Then you can copy/paste that URL into a browser or use curl in the terminal to verify that the generated URL accessing the linked data authority server actually returns data as expected.

