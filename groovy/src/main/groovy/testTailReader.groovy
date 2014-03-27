class TailReader {

  boolean stop = false

  public void stop () {
    stop = true
  }

  public void tail (File file, Closure c) {
    def runnable = {
     def reader

      try {
        reader = file.newReader()
        reader.skip(file.length())
        println reader.class

        def line

        while (!stop) {
          line = reader.readLine()
          if (line) {
            c.call(line)
          }
          else {
            Thread.currentThread().sleep(100)
          }
        }

      }
      finally {
        reader?.close()
      }
    } as Runnable

    def t = new Thread(runnable)
    t.start()
  }
}

def reader = new TailReader()
reader.tail(new File("E:\\web\\cxfjava2wsexample\\readme.txt")) { println it }

// Do something else, e.g. 
 Thread.currentThread().sleep(30 * 1000)

reader.stop()