# Overview

This document describes accessing Getty authorities and working with results returned as linked data. 

## Getty vocabulary

The Getty vocabularies contain structured terminology for art and other material culture, archival materials, visual surrogates, and bibliographic materials.

[More Information](http://www.getty.edu/research/tools/vocabularies/index.html)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4l-labs/qa_server](https://github.com/ld4l-labs/qa_server) to provide normalized access and data results.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* getty_aat_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Getty Art & Architecture Thesaurus (AAT).
* getty_tgn_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Getty Thesaurus of Geographic Names (TGN).
* getty_ulan_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Getty Union List of Artist Names (ULAN).

NOTE: A direct connection to Getty authorities was not explored, but should be accessible through a configuration accessing the SPARQL endpoint.

## Reference

* [Getty Vocabularies as Linked Open Data](http://www.getty.edu/research/tools/vocabularies/lod/)
* [SPARQL endpoint & Downloads](http://vocab.getty.edu/)

