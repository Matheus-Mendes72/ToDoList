package modelo;

public class Task {

    // ID imutável (não pode ser alterado depois de criado)
    private final int id;

    private String title;
    private String description;
    private Status status;

    public Task(int id, String title, String description) {
        this.id = id;
        setTitle(title);
        this.description = description;
        this.status = Status.PENDENTE; // toda tarefa começa pendente
    }
    
    public boolean requiresPassword() {
    	return false;
    }
    
    
    public void complete(String senha) {
    	markAsCompleted();
    }

    // Método de comportamento da entidade
    public void markAsCompleted() {
        this.status = Status.CONCLUIDA;
    }

    @Override
    public String toString() {
        // Representação textual da tarefa (usada na listagem)
        return "ID[" + getId() + "] | Título: " + getTitle() +
               " | Descrição: " + getDescription() +
               " | Status: (Completa: " + getStatus() + ")";
    }

    public void setTitle(String title) {
        if (title == null || title == "") {
            throw new ArgumentoInvalidoException("Título é obrigatório");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean setCompleted() {
        return status == Status.CONCLUIDA;
    }

    public boolean podeSerRemovida() {
    	return true;
    }
    
    public int getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }
    public Status getStatus() { return this.status; }
}
