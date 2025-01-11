package Java01.ex04;

public class TransactionsService {
	private UsersList usersList;

	public TransactionsService(){
		this.usersList = new UsersArrayList();
	}

	public void addUser(String userName, Integer balance){
		User newUser = new User(userName, balance);
		this.usersList.AddUser(newUser);
	}

	public Integer getBalance(int id){
		User user = this.usersList.getUserById(id);
		return user.getBalance();
	}

	public void executeTransaction(int sender, int recipient, Integer amount){

	}

}