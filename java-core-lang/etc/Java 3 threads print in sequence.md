# Java 3 threads print in sequence
This is an interview question, the content of the question is like this.
```
There are three strings are "abc" "def" "ghi". Use three threads to print out the following string

adgbehcfi
```

The key point of this topic is how to let threads know their order. You can use `volatile`
or `AtomicInteger` to let other thread know the current state. The code is like following.
```
public class ThreadThreadPrintClient {
    public static void main(String[] args) {
        PrintFlag flag = new PrintFlag();
        Worker abcWorker = new Worker("abc",flag,0);
        Worker defWorker = new Worker("def",flag,1);
        Worker ghiWorker = new Worker("ghi",flag,2);
        abcWorker.start();
        defWorker.start();
        ghiWorker.start();
    }
}

public class Worker extends Thread {
    private String value;
    private PrintFlag printFlag;
    private int index;

    public Worker(String value, PrintFlag flag, int index) {
        this.value = value;
        this.printFlag = flag;
        this.index = index;
    }

    public void run() {
        int i = 0;
        do {
            if (i > value.length() - 1) {
                break;
            }
            if (printFlag.getIndex() % 3 == index) {
                System.out.println(value.charAt(i++));
                printFlag.addIndex();
            }
        } while (true);
    }
}

public class PrintFlag {
    private volatile int index = 0 ;

    public int getIndex(){
        return index;
    }

    public void addIndex(){
        index++;
    }
}
```

Enjoy.

EOF