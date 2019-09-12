package com.example.bootapitest.jdktest.twooom;


/**
 * -Xss2M
 * // 不要启动该段代码
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            dontStop();
                        }
                    }
            );
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
