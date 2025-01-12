package Java01.ex05;

public interface UsersList {
   void AddUser(User user);
   User getUserById(int userID) throws UserNotFoundException;
   User getUserByIndex(int userIndex) throws UserNotFoundException;
   int  getNumberOfUsers();
}