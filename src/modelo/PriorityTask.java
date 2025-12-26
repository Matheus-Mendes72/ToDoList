package modelo;

public class PriorityTask extends Task {

    private Priority priority;

    public PriorityTask(int id, String title, String description, Priority priority) {
        // Chama o construtor da classe pai (herança)
        super(id, title, description);
        setPriority(priority);
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        if (priority != Priority.BAIXA && priority != Priority.MEDIA && priority != Priority.ALTA) {
            throw new ArgumentoInvalidoException(
                "Prioridade Inválida"
            );
        }
        this.priority = priority;
    }

    @Override
    public String toString() {
        // Polimorfismo: reaproveita o toString da classe pai
        return super.toString() + " | Prioridade: " + getPriority();
    }
}
