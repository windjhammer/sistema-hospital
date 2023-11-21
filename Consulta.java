import java.util.Date;

public class Consulta {
    private Date data;
    private Medico medico;
    private Paciente paciente;

    public Consulta(Date data, Medico medico, Paciente paciente) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}

