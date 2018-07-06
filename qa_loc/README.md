# Overview

This document describes accessing Library of Congress (LoC) authorities and working with results returned as linked data. 

## locnames vocabulary

The Library of Congress Name Authority File (NAF) file provides authoritative data for names of persons, organizations, events, places, and titles. Its purpose is the identification of these entities and, through the use of such controlled vocabulary, to provide uniform access to bibliographic resources.

[More Information](http://id.loc.gov/authorities/names.html)

## locsubjects vocabulary

The Library of Congress Subject Headings (LCSH) has been actively maintained since 1898 to catalog materials held at the Library of Congress. By virtue of cooperative cataloging other libraries around the United States also use LCSH to provide subject access to their collections.

[More Information](http://id.loc.gov/authorities/subjects.html)

## locgenres vocabulary

The Library of Congress Genre/Form Terms for Library and Archival Materials (LCGFT) is a thesaurus that describes what a work is versus what it is about.

[More Information](http://id.loc.gov/authorities/genreForms.html)


# Usage

The configurations in `config/authorities/linked_data` directory are designed to work with [ld4l-labs/qa_server](https://github.com/ld4l-labs/qa_server) to provide normalized access and data results.  See the [ld4l-labs/linked_data_authorities documentation](https://github.com/ld4l-labs/linked_data_authorities/blob/master/README.md) for more information on setting up a qa_server.

## Supported Configurations

* loc_direct.json - Provides a configuration for directly accessing the Library of Congress' vocabularies as provided by Library of Congress. (search not supported - see note below)
* locnames_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Library of Congress Name Authority File (NAF) vocabulary.
* locsubjects_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Library of Congress Subject Headings (LCSH) vocabulary.
* locgenres_ld4l_cache.json - Provides a configuration for accessing the LD4L-Labs cache of the Library of Congress Genre/Form Terms for Library and Archival Materials (LCGFT) vocabulary.

NOTE: At this writing, Library of Congress does not support a query API of id.loc.gov which returns a serialization of linked data.  As such, the direct configuration only supports fetching an individual term.  The cache configurations support both term fetch and search query.

## Reference

* [Technical Documentation](http://id.loc.gov/techcenter/)
* [Download](http://id.loc.gov/download/) (n-triples or rdf-xml)
