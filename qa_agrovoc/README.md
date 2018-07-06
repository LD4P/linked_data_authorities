# Overview

This document describes accessing AGROVOC authority and working with results returned as linked data. 

## AGROVOC vocabulary

AGROVOC is a controlled vocabulary covering all areas of interest of the Food and Agriculture Organization (FAO) of the United Nations, including food, nutrition, agriculture, fisheries, forestry, environment etc. It is published by FAO and edited by a community of experts.  

[More Information](http://aims.fao.org/vest-registry/vocabularies/agrovoc-multilingual-agricultural-thesaurus)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4l-labs/qa_server](https://github.com/ld4l-labs/qa_server) to provide normalized access and data results.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* agrovoc_direct.json - Provides a configuration for directly accessing the AGROVOC vocabulary as provided by FAO.
* agrovoc_ld4l_cache.json - Provides a configuration for accessing the LD4L cache of the AGROVOC vocabulary.

## Reference

* [Technical Documentation](http://aims.fao.org/vest-registry/vocabularies/agrovoc-multilingual-agricultural-thesaurus)
* [Swagger Config](https://github.com/NatLibFi/Skosmos/blob/master/swagger.json)
* [Download](https://aims-fao.atlassian.net/wiki/spaces/AGV/pages/2949126/Releases) (n-triples or rdf-xml)

## Creating a local cache of NALT authority data

You can create a local cache of AGROVOC authority data by [downloading](https://aims-fao.atlassian.net/wiki/spaces/AGV/pages/2949126/Releases) (n-triples or rdf-xml) it into a local triplestore.  There are a number of triplestores that you can use for this purpose.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a local cache server. 

You may want to consider using [SKOSMOS](http://skosmos.org/) to hold AGROVOC data.  It is optimized for [SKOS ontology](https://www.w3.org/TR/2008/WD-skos-reference-20080829/skos.html) based linked data.
