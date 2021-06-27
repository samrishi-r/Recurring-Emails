package com.example.recurringemails;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class sendingMails extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent details = new Intent(Intent.ACTION_SEND);
        details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
        details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
        details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
        details.setType("message/rfc822");
        startActivity(Intent.createChooser(details,"Choose an email client"));
        switch(MainActivity.mode){
            case("recurring"):
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(20000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent details = new Intent(Intent.ACTION_SEND);
                        details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
                        details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
                        details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
                        details.setType("message/rfc822");
                        startActivity(Intent.createChooser(details,"Choose an email client"));
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                break;
            case("weekly"):
                Runnable runnable2 = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(604800000);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent details = new Intent(Intent.ACTION_SEND);
                        details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
                        details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
                        details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent,"Choose an email client"));
                    }
                };
                Thread thread2 = new Thread(runnable2);
                thread2.start();
                break;
            case("monthly"):
                Runnable runnable3 = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            for(int i=0;i<10;i++) {
                                Thread.sleep(262800288);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent details = new Intent(Intent.ACTION_SEND);
                        details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
                        details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
                        details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent,"Choose an email client"));
                    }
                };
                Thread thread3 = new Thread(runnable3);
                thread3.start();
                break;
            case("yearly"):
                Runnable runnable4 = new Runnable() {
                    @Override
                    public void run() {
                        try{
                            for(int i=0;i<100;i++) {
                                Thread.sleep(315360000);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        Intent details = new Intent(Intent.ACTION_SEND);
                        details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
                        details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
                        details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent,"Choose an email client"));
                    }
                };
                Thread thread4 = new Thread(runnable4);
                thread4.start();
                break;
        }
        return START_STICKY;
    }
}
