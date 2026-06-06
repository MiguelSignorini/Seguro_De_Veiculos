package seguro.de.veiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Apolice {

    private final String cpfSegurado;
    private final LocalDate vigenciaInicio;
    private final LocalDate vigenciaFim;
    private final String nomeSegurado;
    private final double valorCobertura;

    private Apolice(Builder builder) {
        this.cpfSegurado    = builder.cpfSegurado;
        this.vigenciaInicio = builder.vigenciaInicio;
        this.vigenciaFim    = builder.vigenciaFim;
        this.nomeSegurado   = builder.nomeSegurado;
        this.valorCobertura = builder.valorCobertura;
    }

    public String getCpfSegurado()       { return cpfSegurado; }
    public LocalDate getVigenciaInicio() { return vigenciaInicio; }
    public LocalDate getVigenciaFim()    { return vigenciaFim; }
    public String getNomeSegurado()      { return nomeSegurado; }
    public double getValorCobertura()    { return valorCobertura; }

    public static class Builder {

        private static final Pattern CPF_PATTERN =
                Pattern.compile("^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$");

        private String    cpfSegurado;
        private LocalDate vigenciaInicio;
        private LocalDate vigenciaFim;
        private String    nomeSegurado;
        private double    valorCobertura;

        public Builder cpfSegurado(String cpf)        { this.cpfSegurado = cpf; return this; }
        public Builder vigenciaInicio(LocalDate data) { this.vigenciaInicio = data; return this; }
        public Builder vigenciaFim(LocalDate data)    { this.vigenciaFim = data; return this; }
        public Builder nomeSegurado(String nome)      { this.nomeSegurado = nome; return this; }
        public Builder valorCobertura(double valor)   { this.valorCobertura = valor; return this; }

        public Apolice build() throws ApoliceInvalidaException {
            List<String> erros = new ArrayList<>();

            if (cpfSegurado == null || cpfSegurado.isBlank()) {
                erros.add("CPF não pode ser vazio.");
            } else if (!CPF_PATTERN.matcher(cpfSegurado).matches()) {
                erros.add("CPF em formato inválido: '" + cpfSegurado + "'.");
            }

            if (vigenciaInicio == null) {
                erros.add("Data de início não pode ser nula.");
            } else if (vigenciaInicio.isBefore(LocalDate.now())) {
                erros.add("Vigência retroativa: " + vigenciaInicio + " é anterior a hoje.");
            }

            if (nomeSegurado == null || nomeSegurado.isBlank()) {
                erros.add("Nome do segurado não pode ser vazio.");
            }

            if (valorCobertura <= 0) {
                erros.add("Valor de cobertura deve ser positivo.");
            }

            if (!erros.isEmpty()) {
                throw new ApoliceInvalidaException("Dados inválidos na apólice.", erros);
            }

            return new Apolice(this);
        }
    }
}