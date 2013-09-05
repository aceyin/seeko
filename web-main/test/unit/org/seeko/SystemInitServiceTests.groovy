package org.seeko

import grails.test.GrailsUnitTestCase
import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SystemInitService)
class SystemInitServiceTests {


    @Test
    void testIsSystemInitialized() {
        service.isSystemInitialized()
    }

}
