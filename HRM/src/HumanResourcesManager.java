
public class HumanResourcesManager {

	String query = "";
	
	UI ui = new UI();
	Repository rep = new Repository();
	
	
	public void doWork() {	

		while(true) {
			ui.startMenu();
			int choice = ui.getChoice();
			boolean isDone = dealWithChoice(choice);
			if(isDone)
				break;
		}
		ui.sayGoodBye();
	}

	private boolean dealWithChoice(int choice) {
		switch(choice) {
		case 0:			
			return true;
		case 1:
			showEmployeesList();
			return false;
		case 2:
			query = "INSERT INTO employees VALUES ";
			addEmployee(query);
			return false;
		case 3:
			query = "UPDATE Employees SET ";
			editInfoAboutEmployee(query);
			return false;
		case 4:
			query = "DELETE FROM employees WHERE employeeID=";
			removeEmployee(query);
			return false;
		default:
			ui.sayChoiceNotCorrect();
			return false;
		}
	}

	private void showEmployeesList() {
		rep.showEmployeesDB();
		
	}

	private void addEmployee(String query) {
		Employee emp = new Employee ();
		emp.setEmployeeId(getNextId());
		emp.setName(ui.askName());
		emp.setLastName(ui.askLastName());
		emp.setPersonalID(ui.askPersonalID());
		emp.setPosition(ui.askPosition());
		emp.setDepartment(ui.askDepartment());
		emp.setSalary(ui.askSalary());
		query += emp;
		rep.workWithEmployeesDB(query);
		
	}
	
	
	private int getNextId() {
		query ="SELECT COUNT(EmployeeId) FROM Employees";
		return Integer.parseInt(rep.getResultFromDB(query)) + 1;
	}

	private void editInfoAboutEmployee(String query) {
		query += ui.askEditableField() + " = '" + ui.askEditingInput() + "' WHERE EmployeeId = " + ui.askId();
		rep.workWithEmployeesDB(query);
	}

	private void removeEmployee(String query) {
		query += ui.askId();
		rep.workWithEmployeesDB(query);
	}
	
	
	
	
}
