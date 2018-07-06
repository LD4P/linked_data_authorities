# Overview

This document describes accessing NALT authority and working with results returned as linked data. 

## NALT vocabulary

The NAL Agricultural Thesaurus (NALT) was originally prepared by staff of the National Agricultural Library to meet the needs of the United States Department of Agriculture (USDA), Agricultural Research Service (ARS).

[More Information](https://agclass.nal.usda.gov/background.shtml)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4l-labs/qa_server](https://github.com/ld4l-labs/qa_server) to provide normalized access and data results.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* nalt_direct.json - Provides a configuration for directly accessing the NALT vocabulary. (search not supported - see note below)
* nalt_ld4l_cache.json - Provides a configuration for accessing the LD4L cache of the NALT vocabulary.
* nalt_local.json - Provides a generalized configuration that can be used as a starting point for setting up a configuration to a local cache server.

NOTE: At this writing, NALT does not support a query API which returns a serialization of linked data.  As such, the direct configuration only supports fetching an individual term.  The ld4l_cache and local configurations provide examples of how to setup support for both term fetch and search query.

## Reference

* [Download](https://agclass.nal.usda.gov/download.shtml) (rdf-xml)

## Creating a local cache of NALT authority data

You can create a local cache of NALT authority data by [downloading]() it into a local triplestore.  There are a number of triplestores that you can use for this purpose.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a local cache server. 

You may want to consider using [SKOSMOS](http://skosmos.org/) to hold NALT data.  It is optimized for [SKOS ontology](https://www.w3.org/TR/2008/WD-skos-reference-20080829/skos.html) based linked data.


