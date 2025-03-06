package juego;

public abstract class PinkGuards {
	private String name;

	public PinkGuards(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract int getRank();
	
	@Override
	public String toString() {
		return "PinkGuard {name='"+name+"', rank="+getRank()+"}";
	}

	protected abstract boolean contains(PinkGuards members);

	protected abstract void add(PinkGuards members);

}
