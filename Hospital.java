import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Medico> medicos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Consulta> consultas = new ArrayList<>();

        int escolha;
        do {
            System.out.println("### Sistema de Gerenciamento Hospitalar ###");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Cadastrar Paciente");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Sair");
            System.out.print("Escolha a opção: ");
            
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarMedico(scanner, medicos);
                    break;
                case 2:
                    cadastrarPaciente(scanner, pacientes);
                    break;
                case 3:
                    agendarConsulta(scanner, medicos, pacientes, consultas);
                    break;
                case 4:
                    System.out.println("Encerrando o programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);

        scanner.close();
    }

    private static void cadastrarMedico(Scanner scanner, List<Medico> medicos) {
        System.out.print("Nome do Médico: ");
        String nome = scanner.nextLine();
        scanner.nextLine();
        System.out.print("CPF do Médico: ");
        String cpf = scanner.nextLine();
        System.out.print("Especialidade do Médico: ");
        String especialidade = scanner.nextLine();

        Medico novoMedico = new Medico(nome, cpf, especialidade);
        medicos.add(novoMedico);

        System.out.println("Médico cadastrado com sucesso!");
    }

    private static void cadastrarPaciente(Scanner scanner, List<Paciente> pacientes) {
        System.out.print("Nome do Paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Paciente: ");
        String cpf = scanner.nextLine();

        Paciente novoPaciente = new Paciente(nome, cpf);
        pacientes.add(novoPaciente);

        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void agendarConsulta(Scanner scanner, List<Medico> medicos, List<Paciente> pacientes, List<Consulta> consultas) {
        System.out.println("### Agendamento de Consulta ###");

        System.out.println("Médicos Disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome() + " - " + medicos.get(i).getEspecialidade());
        }

        System.out.print("Escolha o médico (número): ");
        int escolhaMedico = scanner.nextInt();
        Medico medicoEscolhido = medicos.get(escolhaMedico - 1);

        System.out.println("Pacientes Disponíveis:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }

        System.out.print("Escolha o paciente (número): ");
        int escolhaPaciente = scanner.nextInt();
        Paciente pacienteEscolhido = pacientes.get(escolhaPaciente - 1);

        Consulta novaConsulta = new Consulta(new Date(), medicoEscolhido, pacienteEscolhido);
        consultas.add(novaConsulta);

        System.out.println("Consulta agendada com sucesso!");
    }
}

