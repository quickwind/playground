class ConsoleProgressBar {
    String title = "Processing"
    int interval = 200
    String format = "%s: [%s]  %s %3d%%"
    int wedth = 100
    Closure percentageTeller
    private Thread thread
    List rollingBar = ['-', '\\', '|', '/']
    private rollingBarCount = 0
    int percentage = 0
    
    void start() {   
        if(percentageTeller) {
            thread = Thread.start {                
                while(printProgress()) {                    
                    sleep(150) {true}
                }
            }
        }
    }
    
    private boolean printProgress() {
        def tmp = percentageTeller.call()       
        if(tmp > 0) {
            percentage = tmp > 100 ? 100:tmp
        }
        printf "\r${format}", title, ('='* ((percentage*wedth)/100) ).padRight(wedth),rollingBar[rollingBarCount%rollingBar.size()],percentage
        if(percentage == 100) {
            printf "\r${format}", title, 100, ' ', '='* 100 
            return false
        }
        rollingBarCount++
        return true
    }
    
    void stop() {
        if(thread) thread.stop()
    }
    
    void done() {
        stop()
        printf "\r${format}", title, 100, ' ', '='* 100 
    }
    
    void join() {
        if(thread) thread.join()
    }
    
    void execute (Closure c) {
        println "Start"
        PipedInputStream pin = new PipedInputStream()
        PipedOutputStream pout = new PipedOutputStream()
        pin.connect(pout)
        
        def origOut = System.out
        //System.setOut(new PrintStream(pout, true)
        println "Start..."
        def daemon = Thread.startDaemon {
            pin.withReader { reader ->
                while(true) {
                    def line = reader.readLine()
                    origOut.println "[DEBUG]: $line"
                    sleep(interval)
                }
            }
        }
        
        c.call()
    }
}


ConsoleProgressBar bar = new ConsoleProgressBar()
println "Start"
bar.execute {
    println "Hello"
    println "World"
}
