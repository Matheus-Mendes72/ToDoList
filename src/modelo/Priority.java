package modelo;

public enum Priority {
	BAIXA(1),
	MEDIA(2),
	ALTA(3);
	
	private int priority;
	
	private Priority(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return this.priority;
	}
}
