import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User Melvin = new User("Melvin", 30001, "");
        User Sam = new User("Sam", 30002,"");

        OnlineExamSystem o1 = new OnlineExamSystem();
//        new OnlineExamSystem();
        userList.add(Melvin);
        userList.add(Sam);

        Melvin.selectOption();
        System.out.println("*******************************************************************************");
        System.out.println("Welcome to your Online Examination System: " + Melvin);

        User.startExam();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Exam auto-submitted.");
                timer.cancel();
            }
        };
        timer.schedule(task, 600); // 10 mins

//        Timer timer = null;
        if (timer != null) {
            timer.cancel();
        }

        OnlineExamSystem.logout();



    }
}
