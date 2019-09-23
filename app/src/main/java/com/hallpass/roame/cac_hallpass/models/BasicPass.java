package com.hallpass.roame.cac_hallpass.models;

import java.util.Timer;
import java.util.TimerTask;

public class BasicPass {

    public String origin;
    public String destination;
    public  int mTime, sTime;

    private Timer timer;
    private timerCommunication TC;


    public interface timerCommunication {
        void sendTime(String cTime);
        void timeExpired();
    }

    public void setTimeComms(timerCommunication timeComm){
        TC = timeComm;
    }




    public String getTime(){
        if(sTime < 10){
            return (mTime + ":0" + sTime);
        } else {
            return (mTime + ":" + sTime);
        }
    }

    public void startTimer(){
        timer = new Timer();
        TC.sendTime(getTime());
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateTime();
                TC.sendTime(getTime());
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void stopTimer(){
        timer.cancel();
        timer.purge();
    }


    private void updateTime(){
        if(sTime>0){
            sTime--;
        } else if(mTime > 0) {
            mTime--;
            sTime = 59;
        } else {
            //Timer is finished
            stopTimer();
            TC.timeExpired();
        }
    }









}
