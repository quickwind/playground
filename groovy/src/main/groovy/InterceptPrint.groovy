class Helper { 
    static void println(obj, String msg) {
        
        def printlnMethods = obj.metaClass.metaMethods.findAll { 
            it.name =='println' 
        }
        def printlnMethod
        printlnMethods.each {
            try {
                Class[] params = [java.lang.Object.class]
                it.checkParameters(params)
                printlnMethod = it
            } catch(IllegalArgumentException e) {
            }
        }
            
        //obj.metaClass.metaMethods.each { System.out.println it }
        //System.out.println obj.dump()
        //System.out.println printlnMethod
        if(printlnMethod) {
            printlnMethod.invoke obj, 'hello'
            printlnMethod.invoke obj, msg
            //printlnMethod[0].invoke(obj, 'hello')
            //printlnMethod[0].invoke(obj, msg)
        }
    }
    
    static void print(obj, String msg) {
        def printMethods = obj.metaClass.metaMethods.findAll { 
            it.name =='print' 
        }
        def printMethod
        printMethods.each {
            try {
                Class[] params = [java.lang.Object.class]
                it.checkParameters(params)
                printMethod = it
            } catch(IllegalArgumentException e) {
            }
        }
            
        //obj.metaClass.metaMethods.each { System.out.println it }
        //System.out.println obj.dump()
        //System.out.println printlnMethod
        if(printMethod) {
            printMethod.invoke obj, 'hello '
            printMethod.invoke obj, msg
            //printlnMethod[0].invoke(obj, 'hello')
            //printlnMethod[0].invoke(obj, msg)
        }
    }
}
class AGroovyObject {
    def name
    void method() {
        print "Name: $name"
        
    }
}
use(Helper) {
    AGroovyObject obj = new AGroovyObject(name: "Wallace")
    obj.method()
    println "World"
    
    println "Here"
}
        