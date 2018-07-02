package com.example.bootapitest.jdknew.oneinterface;


import java.util.function.Predicate;

public class DefaultClass implements DefaultA,DefaultB,Predicate {
    @Override
    public void dmath() {
        DefaultB.super.dmath();
    }

    @Override
    public void dmath2() {

    }

    @Override
    public void dmathtt() {

    }

    public String getString(){
        return "sss";
    }


    public Integer ttt(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return (ttt(n-1)+ttt(n-2));
        }
    }


    public void change(StringBuffer stra,StringBuffer strb){
        strb = stra;
        stra = new StringBuffer("new world");
        strb.append("new world");
    }




    @Override
    public boolean test(Object o) {
        return false;
    }

    @Override
    public Predicate and(Predicate other) {
        return null;
    }

    @Override
    public Predicate negate() {
        return null;
    }

    @Override
    public Predicate or(Predicate other) {
        return null;
    }
}
