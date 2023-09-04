package university;

import java.util.List;

public class Fachada {
    private ColecaoAlunos colecaoAlunos;

    public Fachada() {
        colecaoAlunos = new ColecaoAlunos();
    }

    public void adicionarAluno(String nome, String matricula, String email) {
        AlunoUniversidade aluno = new AlunoUniversidade(nome, matricula, email);
        colecaoAlunos.adicionarAluno(aluno);
    }

    public void deletarAluno(String matricula) {
        colecaoAlunos.deletarAluno(matricula);
    }

    public AlunoUniversidade recuperarAlunoPorEmail(String email){
        return colecaoAlunos.buscarPorEmail(email);
    }
    public List<AlunoUniversidade> recuperarAlunosComCreditosPagos(int quantidade) {
        return colecaoAlunos.buscarPorCreditosPagos(quantidade);
    }

    public AlunoUniversidade recuperarAlunoPorMatricula(String matricula) {
        return colecaoAlunos.buscarPorMatricula(matricula);
    }

    public void adicionarCreditos(String matricula, int quantidade) {
        colecaoAlunos.adicionarCreditos(matricula, quantidade);
    }

}
