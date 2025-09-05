import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        FilaDePrioridade<Paciente> filaAtendimento = new FilaDePrioridade<>();
        System.out.println("Cenário 1: Atendimento de Pacientes (Lista Ordenada)");
        filaAtendimento.enfileirar(new Paciente("Carlos", 3));
        filaAtendimento.enfileirar(new Paciente("Maria", 5));
        filaAtendimento.enfileirar(new Paciente("Ana", 8));
        filaAtendimento.enfileirar(new Paciente("Sofia", 10));
        System.out.println("Próximo paciente: " + filaAtendimento.espiar());
        while (!filaAtendimento.estaVazia()) {
            System.out.println("Atendendo: " + filaAtendimento.desenfileirar());
        }

        Comparator<Tarefa> tarefaComparator = (t1, t2) ->
                Integer.compare(t1.prioridade, t2.prioridade);

        FilaDePrioridade<Tarefa> filaTarefas = new FilaDePrioridade<>(tarefaComparator);
        System.out.println("\nCenário 2: Gerenciamento de Tarefas (Lista Ordenada)");
        filaTarefas.enfileirar(new Tarefa("Estudar", 2));
        filaTarefas.enfileirar(new Tarefa("Trabalhar", 5));
        filaTarefas.enfileirar(new Tarefa("Academia", 3));
        System.out.println("Próxima tarefa: " + filaTarefas.espiar());
        while (!filaTarefas.estaVazia()) {
            System.out.println("Executando: " + filaTarefas.desenfileirar());
        }
    }
}
