import java.util.Scanner;

public class User extends OnlineExamSystem{
//    private String userName;
    static User currentUser;
    private String password;
    private int matricNumber;
    private String userName;


    public User(String userName, int matricNumber, String password) {
        this.matricNumber = matricNumber;
        this.userName = getUserName();
        this.password = password;
    }

    public static void updateProfileAndPassword() {
        if (currentUser == null) {
            System.out.println("Please login first.");
        } else {
            System.out.println("Profile and Password update functionality.");
        }
    }


    void selectOption() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t1. Login\n");
        System.out.println("\t\t\t2. Register account\n");
        System.out.print("\t\t\tChoice: ");
        int choice = sc.nextInt();

        System.out.println("Enter username: ");
        this.userName = sc.next();

        System.out.println("Enter password: ");
        this.password = sc.next();
//        if ("Login".equals(userName) && "password".equals(password)) {
//            currentUser = new User(userName, matricNumber, password);
//            System.out.println("Login successful.");
//        } else {
//            System.out.println("Login failed. Invalid credentials.");
//        }

        System.out.println("---------------- Welcome to your online Examination portal ---------------------------");

        System.out.println("******************************************************************************");
        System.out.println("welcome " + userName + "     Matriculation Number: " + matricNumber);
        System.out.println("-------------------------************************************----------------------------------");

        System.out.println("A. Update Profile and Password"); // remove
        System.out.println("B. Start Exam"); // remove
        System.out.println("C. Logout\n"); // remove

            do{
                System.out.println("-------------------------************************************----------------------------------");
                System.out.println("Select your option: ");
                option = sc.next().charAt(0);

                switch (option){
                    case 'A':
                        updateProfileAndPassword();
                        break;
                    case 'B':
                        if (currentUser == null) {
                            System.out.println("Register new student ");
                        } else {
                            User.startExam();
                        }
                        break;
                    case 'C':
                        User.logout();
                        break;

                    default:
                        System.out.println("Invalid request! Please retry ");
                        break;
                }

            } while (option != 'C');
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
