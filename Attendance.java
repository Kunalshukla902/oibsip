import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("total classes held :");
        double class_held = sc.nextInt();
        System.out.println("class attended :");
        double class_attended = sc.nextInt();
        double Per_class = (class_attended/class_held)*100;
        System.out.println("class percentage :"+ Per_class);
        if (Per_class >= 75){
            System.out.println("allowed");
        }else {
            System.out.println("not allowed");
        }
    }
}
