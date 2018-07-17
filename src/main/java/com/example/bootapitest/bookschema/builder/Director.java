package com.example.bootapitest.bookschema.builder;

public class Director {
    private IBuild iBuild;
    public void setIBuild (IBuild iBuild){
        this.iBuild = iBuild;
    }
    public Product getiBuild(){
        iBuild.createUnit();
        iBuild.createUnit2();
        iBuild.createUnit3();
        return iBuild.composite();
    }
}
