package ua.cn.stu.savingscalculator;

public interface TaskListener {

    void onCompleted();
    void onProgressChanged(int percents);
}
