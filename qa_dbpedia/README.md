# Overview

This document describes accessing dbPedia authority and working with results returned as linked data. 

## dbPedia vocabulary

dbPedia is a crowd-sourced community effort to extract structured information from Wikipedia and make this information available on the Web. dbPedia allows you to ask sophisticated queries against Wikipedia, and to link the different data sets on the Web to Wikipedia data.  

[More Information](http://wiki.dbpedia.org/about)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4p/qa_server](https://github.com/ld4p/qa_server) to provide normalized access and data results.  See the [ld4p/linked_data_authorities documentation](https://github.com/ld4p/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* dbpedia_direct.json - Provides a configuration for accessing a single term directly from dbPedia as provided by dbPedia.  At this time, dbPedia does not provide a query URL that returns linked data.  Use dbpedia_ld4l_cache.json to search dbPedia
* dbpedia_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the dbPedia vocabulary.

## Reference

* [Technical Documentation](http://wiki.dbpedia.org/OnlineAccess#1.2%20Public%20Faceted%20Web%20Service%20Interface)
* [Download](http://wiki.dbpedia.org/downloads-2016-04) Seems like there should be a newer one, but I wasn't able to find it.  Please let me know if you have a more recent dbPedia download.
