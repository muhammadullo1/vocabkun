package uz.vocabkun.app;
import android.content.*;
public class BootReceiver extends BroadcastReceiver { public void onReceive(Context c,Intent i){android.content.SharedPreferences p=c.getSharedPreferences("vk",0);if(p.getBoolean("enabled",false))ReminderReceiver.schedule(c,p.getInt("interval",10));} }
