package university;

import java.util.ArrayList;
import java.util.List;

public class ColecaoAlunos {
    private List<AlunoUniversidade> alunos;

    public ColecaoAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(AlunoUniversidade aluno) {
        alunos.add(aluno);
    }

    public void deletarAluno(String email) {
        AlunoUniversidade alunoRemover = null;
        for (AlunoUniversidade aluno : alunos) {
            if (aluno.getEmail().equals(email)) {
                alunoRemover = aluno;
                break;
            }
        }
        if (alunoRemover != null) {
            alunos.remove(alunoRemover);
        }
    }

    public AlunoUniversidade buscarPorEmail(String email) {
        for (AlunoUniversidade aluno : alunos) {
            if (aluno.getEmail().equals(email)) {
                return aluno;
            }
        }
        return null;
    }

    public List<AlunoUniversidade> buscarPorCreditosPagos(int quantidade) {
        List<AlunoUniversidade> alunosComCreditos = new ArrayList<>();
        for (AlunoUniversidade aluno : alunos) {
            if (aluno.getCreditosPagos() >= quantidade) {
                alunosComCreditos.add(aluno);
            }
        }
        return alunosComCreditos;
    }

    public AlunoUniversidade buscarPorMatricula(String matricula) {
        for (AlunoUniversidade aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public void adicionarCreditos(String matricula, int quantidade) {
        AlunoUniversidade aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            aluno.pagarCreditos(quantidade);
        }
    }
}

