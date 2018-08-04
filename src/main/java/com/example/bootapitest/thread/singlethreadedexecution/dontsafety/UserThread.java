package com.example.bootapitest.thread.singlethreadedexecution.dontsafety;

public class UserThread extends Thread {
//    private final Gate gate;
    private final GateSyn gateSyn;
    private final String myname;
    private final String myaddress;
//    public UserThread(Gate gate, String myname, String myaddress) {
//        this.gate = gate;
//        this.myname = myname;
//        this.myaddress = myaddress;
//    }

    public UserThread(GateSyn gateSyn, String myname, String myaddress) {
        this.gateSyn = gateSyn;
        this.myname = myname;
        this.myaddress = myaddress;
    }
    public void run(){
        System.out.println(myname + "BEGIN");
        while (true){
            gateSyn.pass(myname,myaddress);
        }
    }
}
