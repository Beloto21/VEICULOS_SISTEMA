package Automovel;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = Conexao.getConexao()) {
            if (conexao != null) {
            	
                // aqui esta criando instâncias do veículo
                Automovel carro = new Automovel("Maverick", 1974, "Ford", "Vermelho", 20000, 4, "ABS", true);
                Motocicleta moto = new Motocicleta("Diavel", 2020, "Ducati", "Preto", 10000, 1260, 116.0);
                Caminhao caminhao = new Caminhao("Feneme", 1924, "FNM", "Verde", 20000, 5, 18000.0);
                Bicicleta bicicleta = new Bicicleta("Oggi", 2024, "Oggi", "Preto", 100, "Oggi", "Alumínio", 21, true);
                Skate skate = new Skate("Waveboard", 2024, "Skater", "Preto", 100, "Skater", "Duplas");

                // aqui mostra os detalhes dos objetos 
                System.out.println("Detalhes do carro: " + carro);
                System.out.println("Detalhes da motocicleta: " + moto);
                System.out.println("Detalhes do caminhão: " + caminhao);
                System.out.println("Detalhes da bicicleta: " + bicicleta);
                System.out.println("Detalhes do skate: " + skate);

                // aqui vai executar os inserts la no banco de dados 
                conexao.createStatement().executeUpdate(carro.gerarInsert());
                conexao.createStatement().executeUpdate(moto.gerarInsert());
                conexao.createStatement().executeUpdate(caminhao.gerarInsert());
                conexao.createStatement().executeUpdate(bicicleta.gerarInsert());
                conexao.createStatement().executeUpdate(skate.gerarInsert());

                System.out.println("Dados inseridos com sucesso.");

                // aqui é para exebir os valores que foram colocados 
                System.out.println("\nValores inseridos:");
                System.out.println(carro);
                System.out.println(moto);
                System.out.println(caminhao);
                System.out.println(bicicleta);
                System.out.println(skate);
            } else {
                System.out.println("Falha ao se conectar com o banco de dados.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao executar o programa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}