package uz.vocabkun.app;

import android.Manifest;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.*;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import org.json.*;
import java.io.*;
import java.util.*;

public class MainActivity extends Activity {
    WebView web;
    @Override public void onCreate(Bundle b){ super.onCreate(b); createChannel(); if(Build.VERSION.SDK_INT>=33 && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)!=PackageManager.PERMISSION_GRANTED) requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS},42);
        web=new WebView(this); web.getSettings().setJavaScriptEnabled(true); web.getSettings().setDomStorageEnabled(true); web.addJavascriptInterface(new Bridge(this),"VocabKunAndroid"); web.setWebViewClient(new WebViewClient()); setContentView(web); web.loadUrl("file:///android_asset/index.html"); }
    static void createChannel(){ }
    public static void ensureChannel(Context c){if(Build.VERSION.SDK_INT>=26){NotificationChannel ch=new NotificationChannel("vocabkun_words","VocabKun eslatmalari",NotificationManager.IMPORTANCE_DEFAULT);ch.setDescription("Inglizcha so‘z yodlash eslatmalari");((NotificationManager)c.getSystemService(NOTIFICATION_SERVICE)).createNotificationChannel(ch);}}
    @Override public void onBackPressed(){if(web!=null&&web.canGoBack())web.goBack();else super.onBackPressed();}
    public static class Bridge {
        Context c; Bridge(Context c){this.c=c;}
        @JavascriptInterface public void startReminders(int minutes){ if(Build.VERSION.SDK_INT>=33 && c.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)!=PackageManager.PERMISSION_GRANTED){ if(c instanceof Activity)((Activity)c).runOnUiThread(()->Toast.makeText(c,"Bildirishnomaga ruxsat bering va yana bosing",Toast.LENGTH_LONG).show()); return;} minutes=(minutes==5?5:10); c.getSharedPreferences("vk",0).edit().putInt("interval",minutes).putBoolean("enabled",true).apply(); ReminderReceiver.schedule(c,minutes); }
        @JavascriptInterface public void stopReminders(){c.getSharedPreferences("vk",0).edit().putBoolean("enabled",false).apply();((AlarmManager)c.getSystemService(ALARM_SERVICE)).cancel(ReminderReceiver.pending(c));}
    }
}
