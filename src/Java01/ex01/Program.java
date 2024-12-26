package Java01.ex01;

public class Program {
    public static void main(String[] args) {
        // Creation dial users
        User user1 = new User("Ahmed", 1000);
        User user2 = new User("Fatima", 500);
        User user3 = new User("Ayoub", 500);
        User user4 = new User("Radwa", 500);
        
        System.out.println(user1.getName() + " ID: " + user1.getIdentifier());
        System.out.println(user2.getName() + " ID: " + user2.getIdentifier());
        System.out.println(user3.getName() + " ID: " + user3.getIdentifier());
        System.out.println(user4.getName() + " ID: " + user4.getIdentifier());
    }
}