import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

            escolha = sc.nextInt();
            sc.nextLine(); 

            switch (escolha) {
                case 1:
                    cadastrarMedico(sc, medicos);
                    break;
                case 2:
                    cadastrarPaciente(sc, pacientes);
                    break;
                case 3:
                    agendarConsulta(sc, medicos, pacientes, consultas);
                    break;
                case 4:
                    System.out.println("Encerrando o programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);

        sc.close();
    }

    private static void cadastrarMedico(Scanner scanner, List<Medico> medicos) {
        System.out.print("Nome do Médico: ");
        String nome = scanner.nextLine();
        System.out.print("CRM do Médico: ");
        String crm = scanner.nextLine();  
        System.out.print("Especialidade do Médico: ");
        String especialidade = scanner.nextLine();

        Medico novoMedico = new Medico(nome, crm, especialidade);
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

        if (medicos.isEmpty()) {
            System.out.println("Erro: Não há médicos cadastrados. Cadastre pelo menos um médico antes de agendar uma consulta.");
            return;
        }

        System.out.println("Médicos Disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome() + " (CRM: " + medicos.get(i).getCrm() + ")");
        }

        System.out.print("Escolha o médico (número): ");
        int escolhaMedico = scanner.nextInt();

        if (escolhaMedico < 1 || escolhaMedico > medicos.size()) {
            System.out.println("Erro: Escolha de médico inválida. Tente novamente.");
            return;
        }

        Medico medicoEscolhido = medicos.get(escolhaMedico - 1);

        System.out.println("Pacientes Disponíveis:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }

        System.out.print("Escolha o paciente (número): ");
        int escolhaPaciente = scanner.nextInt();

        if (escolhaPaciente < 1 || escolhaPaciente > pacientes.size()) {
            System.out.println("Erro: Escolha de paciente inválida. Tente novamente.");
            return;
        }

        Paciente pacienteEscolhido = pacientes.get(escolhaPaciente - 1);

        Consulta novaConsulta = new Consulta(new Date(), medicoEscolhido, pacienteEscolhido);
        consultas.add(novaConsulta);

        System.out.println("Consulta agendada com sucesso!");
    }
}

