package modelo;
//import java.time.LocalDateTime; 	// importação do API de data e hora que usarei futuramente

public class Task {

    // ID imutável (não pode ser alterado depois de criado)
    private final int id;

    private String title;
    private String description;
    private boolean completed;

    public Task(int id, String title, String description) {
        this.id = id;
        setTitle(title);
        this.description = description;
        this.completed = false; // toda tarefa começa pendente
    }

    // Método de comportamento da entidade
    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        // Representação textual da tarefa (usada na listagem)
        return "ID[" + getId() + "] | Título: " + getTitle() +
               " | Descrição: " + getDescription() +
               " | Status: (Completa: " + isCompleted() + ")";
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

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }
    public boolean isCompleted() { return this.completed; }
}
