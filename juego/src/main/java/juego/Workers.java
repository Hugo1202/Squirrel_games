package squirrelGames;

import java.util.Objects;

public class Workers extends PinkGuards {
	private Department department;
	private PinkGuards supervisor;

	public Workers(String name, Department department, PinkGuards supervisor) throws InvalidSupervisorException {
		super(name);
		this.department = department;
		setSupervisor(supervisor);
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public PinkGuards getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(PinkGuards supervisor) throws InvalidSupervisorException {
		if (supervisor == null) {
			this.supervisor = null;
		} else {
			if (supervisor.getRank() <= this.getRank()) {
				throw new InvalidSupervisorException("Supervisor debe tener mayor rango que Worker.");
			}
			this.supervisor = supervisor;
		}
	}

	@Override
	public int getRank() {
		return 1;
	}

	@Override
	public String toString() {
		return "Worker{" + "name='" + getName() + '\'' + ", department=" + department + ", supervisor="
				+ (supervisor != null ? supervisor.getName() : "None") + ", rank=" + getRank() + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Workers))
			return false;
		Workers workers = (Workers) o;
		return department == workers.department && Objects.equals(getName(), workers.getName())
				&& Objects.equals(supervisor, workers.supervisor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), department, supervisor);
	}

	@Override
	protected boolean contains(PinkGuards members) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void add(PinkGuards members) {
		// TODO Auto-generated method stub
		
	}

}
