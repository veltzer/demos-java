package programming.labs.lab0502java_class_definition_sol;

public class Customer {
	private String name;
	private String id;
	private int age;
	private Account account;

	public Customer() {
		this("John", "is-111", 30);
	}

	@SuppressWarnings("this-escape")
	public Customer(String iname, String iid, int iage) {
		setName(iname);
		setId(iid);
		setAge(iage);
		account = new Account(5000);
	}

	@SuppressWarnings("this-escape")
	public Customer(String iname, String iid, int iage, Account iaccount) {
		setName(iname);
		setId(iid);
		setAge(iage);
		setAccount(iaccount);
	}

	public int getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAge(int iage) {
		if (iage > 0 && iage < 120) {
			age = iage;
		}
	}

	public void setId(String iid) {
		id = iid;
	}

	public void setName(String iname) {
		name = iname;
	}

	public void setAccount(Account iaccount) {
		account = iaccount;
	}

}
