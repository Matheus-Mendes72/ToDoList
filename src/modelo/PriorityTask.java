package modelo;

public class PriorityTask extends Task  {

    private Priority priority;
    private String senha;

    public PriorityTask(int id, String title, String description, Priority priority, String senha) {
        // Chama o construtor da classe pai (herança)
        super(id, title, description);
        setPriority(priority);
        this.senha = senha;
    }

    public Priority getPriority() {
        return this.priority;
    }
    
    public boolean podeSerRemovida() {
    	return priority == Priority.BAIXA;
    }
    
    public boolean requiresPassword() {
    	return true;
    }
    
    public void complete(String senha) {
    	if (!validarSenha(senha)) {
    		throw new ArgumentoInvalidoException("Senha inválida");
    	}
    	markAsCompleted();
    }

    public void setPriority(Priority priority) {
        if (priority != Priority.BAIXA && priority != Priority.MEDIA && priority != Priority.ALTA) {
            throw new ArgumentoInvalidoException(
                "Prioridade Inválida"
            );
        }
        this.priority = priority;
    }
    
    public void setSenha(String senha) {
    	if (senha == null || senha == "") {
    		throw new ArgumentoInvalidoException("Senha inválida");
    	}
    	this.senha = senha;
    }
    
    public boolean validarSenha(String senhaInformada) {
    	return this.senha.equals(senhaInformada);
    }

    @Override
    public String toString() {
        // Polimorfismo: reaproveita o toString da classe pai
        return super.toString() + " | Prioridade: " + getPriority();
    }
}
