package org.seeko.command

import grails.validation.Validateable
/**
 * Created by eniayin on 13-9-24.
 */
@Validateable
class SettingsCommand {
    String HTTP_PORT
    String SEACHER_MEMORY
    String INDEXER_MEMORY
    String ES_MEMORY
    String FILE_TYPE_FILTERS
    String DIRECTORY_FILTERS
}
