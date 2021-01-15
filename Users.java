
class Users extends Players
{
	private String Username,Password;
    String getUsername() {
        return Username;
    }
    void setUsername(String username) {
        Username = username;
    }
	String getPassword() {
		return Password;
	}
	void setPassword(String password) {
		Password = password;
	}
	public String toString()
	{
		return "Name :"+Name+"Username :"+Username;
	}
}
