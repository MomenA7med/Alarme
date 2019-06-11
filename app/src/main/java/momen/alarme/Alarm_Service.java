package momen.alarme;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by AL-Motahida on 01/02/2018.
 */
public class Alarm_Service extends Service{
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this,R.raw.rig);
        mediaPlayer.start();
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(Alarm_Service.this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("HI");
        builder.setContentText("that is a try ..");
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.tmark);
        Notification noti = builder.build();
        notificationManager.notify(0,noti);
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
