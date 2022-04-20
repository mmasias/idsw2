package Program;

public class Administrator {

	//Atributos que se usan para completar los datos del administrador
	private String name;
	
	private String surname;
	
	private String username;
	
	private char[] password;
	
	private boolean logedIn;
	
	//Constructor de la clase
	public Administrator (String name, String surname, String username, String password, boolean logedIn) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password.toCharArray();
		this.logedIn = logedIn;
	}
	
	//Getters y setteres
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getUsername() {
		return username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password.toCharArray();
	}


	public boolean isLogedIn() {
		return logedIn;
	}


	public void setLogedIn(boolean logedIn) {
		this.logedIn = logedIn;
	}
	
	
}
