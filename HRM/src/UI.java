import java.util.Scanner;

public class UI {
	
	static Scanner sc;
	
	
	public void startMenu() {
		System.out.println("*****************************************************************************");
		System.out.println("* MAIN MENU OF THE HRM:");
		System.out.println("* Enter '1' - See employees list");
		System.out.println("* Enter '2' - Add employee");
		System.out.println("* Enter '3' - Edit information about employee");
		System.out.println("* Enter '4' - Remove employee");
		System.out.println("* Enter '0' - Log out");
		System.out.println("*****************************************************************************");
	}
	
	public int getChoice() {
		sc = new Scanner(System.in);
		if (!sc.hasNextInt())
			return -1;						
		return sc.nextInt();
	}

	public void sayGoodBye() {
		System.out.println("Closing HRM System");
		if (sc != null)
			sc.close();
	}
	
	public void sayChoiceNotCorrect() {
		System.out.println("Choice not correct. Please choose from available");
	}
	
	public String askName() {
		System.out.println("Enter employee's name");
		return getLine();
	}
	
	public String askLastName() {
		System.out.println("Enter employee's last name");
		return getLine();
	}

	public String askPosition() {
		System.out.println("Enter employee's position");
		return getLine();
	}
	
	public String askDepartment() {
		System.out.println("Enter employee's department");
		return getLine();
	}

	public double askSalary() {
		System.out.println("Enter employee's monthly salary");
		String eilute = getLine();
		double price;
		try {
			price = Double.parseDouble(eilute);
		} catch (Exception e) {
			eilute = getLine();
			return Double.parseDouble(eilute);
		}
		return price;
	}
	
	public String askPersonalID() {
		System.out.println("Enter employee's personal code");
		return getLine();
		
	}
	
	public String askEditableField() {
		System.out.println("Enter editable field from the following: employeeId, personalCode, name, lastName, position, departament, salary");
		return getLine();
	}
	
	public String askEditingInput() {
		System.out.println("Enter data you want to insert as changed");
		return getLine();
	}
	
	public int askId() {
		System.out.println("Enter employee's ID");
		String eilute = getLine();
		return Integer.parseInt(eilute);
	}
	
	
	
	private String getLine() {
		sc = new Scanner(System.in);
		String eilute = sc.nextLine();
		if (eilute == null || eilute.length() <= 0) {
			return "unknown";
		}
		return eilute.replace (',', ' ');
	}
	
	public void confirmAction() {
		System.out.println("Action completed succesfully");
	}
	
	public void denyAction() {
		System.out.println("Action uncompleted");
	}
	
	
	
}
