package professor_classes;

public class Data15 implements Comparable<Data15> {
    protected final int dia;
    protected final int mes;
    protected final int ano;
    protected static int quantidadeDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Construtores
    public Data15(int dia, int mes, int ano) {
        verificaData(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data15() {
        this(1, 1, 1900);  // Define uma data padrão: 01/01/1900
    }

    // Verificação da data
    private void verificaData(int dia, int mes, int ano) {
        if (ano < 1) {
            throw new RuntimeException("Ano inválido");
        }
        if (mes < 1 || mes > 12) {
            throw new RuntimeException("Mês inválido");
        }
        if (anoBissexto()) {
            quantidadeDiasMes[1] = 29;  // Ajuste para ano bissexto
        }
        if (dia < 1 || dia > quantidadeDiasMes[mes - 1]) {
            throw new RuntimeException("Dia inválido");
        }
    }

    // Verifica se o ano é bissexto
    private boolean anoBissexto() {
        if ((ano % 4 == 0) && (ano % 100 != 0)) {
            if (ano % 400 == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Data15 other = (Data15) obj;
        return ano == other.ano && dia == other.dia && mes == other.mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    // Método que soma um dia à data
    public Data15 somarUmDia() {
        int dia = this.dia;
        int mes = this.mes;
        int ano = this.ano;

        if (dia + 1 > quantidadeDiasMes[mes - 1]) {
            dia = 1;
            if (mes + 1 > 12) {
                mes = 1;
                ano += 1;
            } else {
                mes = mes + 1;
            }
        } else {
            dia += 1;
        }
        return new Data15(dia, mes, ano);
    }

    // Método compareTo implementado corretamente (com base na interface Comparable)
    @Override
    public int compareTo(Data15 outraData) {
        // Comparar pelo ano
        if (this.ano != outraData.getAno()) {
            return Integer.compare(this.ano, outraData.getAno());
        }

        // Comparar pelo mês, se os anos forem iguais
        if (this.mes != outraData.getMes()) {
            return Integer.compare(this.mes, outraData.getMes());
        }

        // Comparar pelo dia, se os anos e meses forem iguais
        return Integer.compare(this.dia, outraData.getDia());
    }
}
