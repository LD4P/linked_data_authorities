# Overview

This document describes how access DBpedia authority to work with linked data. 

## DBpedia vocabulary

DBpedia is a crowd-sourced community effort to extract structured information from Wikipedia and make this information available on the Web. DBpedia allows you to ask sophisticated queries against Wikipedia, and to link the different data sets on the Web to Wikipedia data.  

[More Information](http://wiki.dbpedia.org/about)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4l-labs/qa_server](https://github.com/ld4l-labs/qa_server) to provide normalized access and data results.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* dbpedia_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the DBpedia vocabulary.

## Reference

* [Technical Documentation](http://wiki.dbpedia.org/OnlineAccess#1.2%20Public%20Faceted%20Web%20Service%20Interface)
* [Download](http://wiki.dbpedia.org/downloads-2016-04) Seems like there should be a newer one, but I wasn't able to find it.
