package Java01.ex02;

import java.util.Arrays;

public class UsersArrayList implements UsersList{
    public User[] Users;
    private int capacity;
    private int size;

    private void expandArray(){
        capacity = capacity + (capacity / 2);
        User[] newUsers = new User[capacity];
        for (int i = 0; i < size; i++)
            newUsers[i] = Users[i];
        Users = newUsers;
    }
    public UsersArrayList(){
        this.size = 0;
        this.capacity = 10;
        this.Users = new User[capacity];

    }
    @Override
    public void AddUser(User user) {
        if (capacity == size)
            expandArray();
        Users[size++] = user;
    }

    @Override
    public User getUserById(int userID) throws UserNotFoundException {
        for (User usr : Users){
            if (usr.getIdentifier() == userID)
                return usr;
        }
        throw new UserNotFoundException("User with Id " + userID + " not found.");
    }

    @Override
    public User getUserByIndex(int userIndex) throws UserNotFoundException {
        if (userIndex < 0 || userIndex > size)
            throw new UserNotFoundException("User with index " + userIndex + " not available.");
        return Users[userIndex];
    }

    @Override
    public int getNumberOfUsers() {
        return size;
    }
}