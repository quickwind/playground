package gtunes

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(StoreController)
class StoreControllerSpec {

    def setup() {
    }

    def cleanup() {
    }

    void testSomething() {
        controller.index()
        assert 'Welcome to the gTunes store!' == response.text
    }
}
