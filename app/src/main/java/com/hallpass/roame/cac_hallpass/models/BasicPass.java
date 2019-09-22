package com.hallpass.roame.cac_hallpass.models;

public class BasicPass {

    private String origin;
    private String destination;
    private int mTime;


    public BasicPass(String origin, String destination, int mTime){
        this.origin = origin;
        this.destination = destination;
        this.mTime = mTime;
    }


    public void clearPass(){
        origin = null;
        destination = null;
        mTime = 0;
    }



    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getmTime() {
        return mTime;
    }

    public void setmTime(int mTime) {
        this.mTime = mTime;
    }
}
