package ua.cn.stu.savingscalculator;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {

   private Handler handler = new Handler(Looper.getMainLooper());
    private Set<TaskListener> listeners = new HashSet<>();
    public void addListener(TaskListener listener)
    {
    this.listeners.add(listener);
    }

    public void removeListener(TaskListener listener)
    {
        this.listeners.remove(listener);
    }

    public void publishCompleted()
    {
        handler.post(()->{
            for (TaskListener listener:listeners)
            {
                listener.onCompleted();
            }
        });

    }

    public void publishProgress(int percents)
    {

        handler.post(()->{
            for (TaskListener listener:listeners)
            {
                listener.onProgressChanged(percents);
            }
        });

    }
}
