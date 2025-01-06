package Java01.ex02;

public class Program {
    public static void main(String[] args) {
        // Creation dial users
        User user1 = new User("Ahmed", 1000);
        User user2 = new User("Fatima", 500);
        User user3 = new User("Ayoub", 500);
        User user4 = new User("Radwa", 500);
        
        UsersArrayList users = new UsersArrayList();
        users.AddUser(user1);
        users.AddUser(user2);
        users.AddUser(user3);
        users.AddUser(user4);

        System.out.println(users.getUserById(4).getName());
    }
}