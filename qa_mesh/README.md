# Overview

This document describes accessing MeSH authority and working with results returned as linked data. 

## MeSH vocabulary

The Medical Subject Headings (MeSH) authority provides a hierarchically-organized terminology for indexing and cataloging of biomedical information such as MEDLINE/PUBmed and other NLM databases.

[More Information](https://www.nlm.nih.gov/mesh/)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4p/qa_server](https://github.com/ld4p/qa_server) to provide normalized access and data results.  See the [ld4p/linked_data_authorities documentation](https://github.com/ld4p/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* mesh_ld4l_cache.json - Provides a configuration for accessing the LD4L cache of the MeSH vocabulary.


## Reference

* [Files Available to Download](https://www.nlm.nih.gov/mesh/filelist.html)
* [Download](ftp://nlmpubs.nlm.nih.gov/online/mesh/rdf/)



