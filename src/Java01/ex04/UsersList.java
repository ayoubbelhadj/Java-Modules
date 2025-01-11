package Java01.ex04;

public interface UsersList {
   void AddUser(User user);
   User getUserById(int userID) throws UserNotFoundException;
   User getUserByIndex(int userIndex) throws UserNotFoundException;
   int  getNumberOfUsers();
}