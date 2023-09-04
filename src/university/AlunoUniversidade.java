package university;

    public class AlunoUniversidade {
        private String nome;
        private String matricula;
        private String email;
        private int creditosPagos;

        public AlunoUniversidade(String nome, String matricula, String email) {
            this.nome = nome;
            this.matricula = matricula;
            this.email = email;
            this.creditosPagos = 0;
        }

        public String getNome() {
            return nome;
        }

        public String getMatricula() {
            return matricula;
        }

        public String getEmail() {
            return email;
        }

        public int getCreditosPagos() {
            return creditosPagos;
        }

        public void pagarCreditos(int quantidade) {
            if (quantidade == 2 || quantidade == 4 || quantidade == 6) {
                creditosPagos += quantidade;
            }
        }


        @Override
        public String toString() {
            return "Nome: " + nome +
                    "\nMatrícula: " + matricula +
                    "\nE-mail: " + email +
                    "\nCréditos Pagos: " + creditosPagos;
        }

    }

