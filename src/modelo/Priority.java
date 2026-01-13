package modelo;

public enum Priority {
	BAIXA(1) {
		@Override 
		public boolean podeSerRemovida() {
			return true;
		}
	},
	MEDIA(2) {
		@Override 
		public boolean podeSerRemovida() {
			return false;
		}
	},
	ALTA(3) {
		@Override 
		public boolean podeSerRemovida() {
			return false;
		}
	};
	
	private int priority;
	
	public abstract boolean podeSerRemovida();
	
	private Priority(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return this.priority;
	}
}
