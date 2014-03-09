import static org.junit.Assert.*
import org.junit.Test

class GroovyGreetingTest {
    def greeting = new Greeting()
    
    @Test
    void testGetGreeting() {
        assert 'Hello, World!' == greeting.getMessage()
    }
    
    @Test
    void testSetGreeting() {
        greeting.setMessage("What's up?")
        assert "What's up?" == greeting.getMessage()
    }
}