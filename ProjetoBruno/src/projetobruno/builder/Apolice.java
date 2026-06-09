package projetobruno.builder;

import java.time.LocalDate;

/**
 * Representa uma apólice de seguro veicular.
 *
 * <p>Objetos desta classe são construídos exclusivamente pelo
 * {@link ApoliceBuilder}, garantindo que apenas apólices válidas sejam criadas.</p>
 *
 * @author Ruan Alves
 * @version 1.0
 */
public class Apolice {

    /** Nome completo do segurado. */
    private final String nomeCliente;

    /** CPF do segurado no formato 000.000.000-00. */
    private final String cpf;

    /** Placa do veículo segurado. */
    private final String placa;

    /** Data de início da vigência (formato yyyy-MM-dd). */
    private final String dataVigencia;

    /** Indica se assistência 24h está incluída. */
    private final boolean assistencia24h;

    /** Indica se carro reserva está incluído. */
    private final boolean carroReserva;

    /** Indica se cobertura de vidros está incluída. */
    private final boolean coberturaVidros;

    /** Construtor privado — somente o Builder instancia esta classe. */
    private Apolice(ApoliceBuilder b) {
        this.nomeCliente     = b.nomeCliente;
        this.cpf             = b.cpf;
        this.placa           = b.placa;
        this.dataVigencia    = b.dataVigencia;
        this.assistencia24h  = b.assistencia24h;
        this.carroReserva    = b.carroReserva;
        this.coberturaVidros = b.coberturaVidros;
    }

    // ── Getters ──────────────────────────────────────────────────
    public String getNomeCliente()     { return nomeCliente; }
    public String getCpf()             { return cpf; }
    public String getPlaca()           { return placa; }
    public String getDataVigencia()    { return dataVigencia; }
    public boolean isAssistencia24h()  { return assistencia24h; }
    public boolean isCarroReserva()    { return carroReserva; }
    public boolean isCoberturaVidros() { return coberturaVidros; }

    @Override
    public String toString() {
        return "Apolice{cliente='" + nomeCliente + "', cpf='" + cpf +
               "', placa='" + placa + "', vigencia='" + dataVigencia +
               "', 24h=" + assistencia24h + ", reserva=" + carroReserva +
               ", vidros=" + coberturaVidros + "}";
    }

    // ════════════════════════════════════════════════════════════
    //  BUILDER INTERNO
    // ════════════════════════════════════════════════════════════

    /**
     * Builder fluente para {@link Apolice}.
     *
     * <p>Exemplo de uso:</p>
     * <pre>
     *   Apolice a = new Apolice.ApoliceBuilder()
     *       .nomeCliente("João Silva")
     *       .cpf("123.456.789-09")
     *       .placa("ABC-1234")
     *       .dataVigencia("2099-12-31")
     *       .assistencia24h(true)
     *       .build();
     * </pre>
     */
    public static class ApoliceBuilder {

        // Obrigatórios
        private String nomeCliente;
        private String cpf;
        private String placa;
        private String dataVigencia;

        // Opcionais (padrão false)
        private boolean assistencia24h  = false;
        private boolean carroReserva    = false;
        private boolean coberturaVidros = false;

        /**
         * Define o nome do cliente.
         * @param nomeCliente nome completo; não pode ser nulo ou vazio
         * @return este builder
         */
        public ApoliceBuilder nomeCliente(String nomeCliente) {
            this.nomeCliente = nomeCliente;
            return this;
        }

        /**
         * Define o CPF do cliente.
         * @param cpf formato 000.000.000-00
         * @return este builder
         */
        public ApoliceBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        /**
         * Define a placa do veículo.
         * @param placa placa no formato antigo ou Mercosul
         * @return este builder
         */
        public ApoliceBuilder placa(String placa) {
            this.placa = placa;
            return this;
        }

        /**
         * Define a data de início da vigência.
         * @param dataVigencia formato yyyy-MM-dd; não pode ser retroativa
         * @return este builder
         */
        public ApoliceBuilder dataVigencia(String dataVigencia) {
            this.dataVigencia = dataVigencia;
            return this;
        }

        /**
         * Habilita ou desabilita assistência 24h.
         * @param ativo true para incluir
         * @return este builder
         */
        public ApoliceBuilder assistencia24h(boolean ativo) {
            this.assistencia24h = ativo;
            return this;
        }

        /**
         * Habilita ou desabilita carro reserva.
         * @param ativo true para incluir
         * @return este builder
         */
        public ApoliceBuilder carroReserva(boolean ativo) {
            this.carroReserva = ativo;
            return this;
        }

        /**
         * Habilita ou desabilita cobertura de vidros.
         * @param ativo true para incluir
         * @return este builder
         */
        public ApoliceBuilder coberturaVidros(boolean ativo) {
            this.coberturaVidros = ativo;
            return this;
        }

        /**
         * Valida os dados e constrói o objeto {@link Apolice}.
         *
         * @return nova instância de Apolice
         * @throws IllegalArgumentException se algum campo obrigatório for inválido
         */
        public Apolice build() {
            validar();
            return new Apolice(this);
        }

        /**
         * Executa as regras de validação dos campos obrigatórios.
         *
         * @throws IllegalArgumentException se alguma regra for violada
         */
        private void validar() {
            if (nomeCliente == null || nomeCliente.isBlank())
                throw new IllegalArgumentException("Nome do cliente é obrigatório.");

            if (!cpfValido(cpf))
                throw new IllegalArgumentException("CPF inválido: " + cpf);

            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa é obrigatória.");

            if (!dataValida(dataVigencia))
                throw new IllegalArgumentException(
                    "Data de vigência inválida ou retroativa: " + dataVigencia);
        }

        /**
         * Verifica formato básico do CPF (000.000.000-00).
         * @param cpf string a validar
         * @return true se o formato estiver correto
         */
        private boolean cpfValido(String cpf) {
            return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        }

        /**
         * Verifica se a data está no formato yyyy-MM-dd e não é retroativa.
         * @param data string a validar
         * @return true se válida e futura/presente
         */
        private boolean dataValida(String data) {
            if (data == null || !data.matches("\\d{4}-\\d{2}-\\d{2}")) return false;
            return data.compareTo(LocalDate.now().toString()) >= 0;
        }
    }
}