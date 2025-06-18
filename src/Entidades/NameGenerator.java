package Entidades;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NameGenerator {

    private static final List<String> FIRST_NAMES = Arrays.asList(
        "Jubileu", "Gertrudes", "Astolfo", "Creuza", "Reginaldo", "Marivalda", 
        "Jocimar", "Valdisnei", "Sirleide", "Genivaldo", "Berisvaldo", "Zuleica",
        "Odair", "Ivaldo", "Cleiton", "Vanderlei", "Magnólia", "Claudionor",
        "Josias", "Eliete", "Zenilda", "Dagoberto", "Arquibaldo", "Pantaleão", 
        "Deocleciano", "Gumersindo", "Filomena", "Efigênia", "Clotilde", "Ubiratã", 
        "Waldomiro", "Ednaldo", "Joselito", "Ivonete", "Zenaide", "Cleusa", "Damião", 
        "Maurílio", "Lindomar", "Jurema", "Gelson", "Sidnei", "Osmar", "Elizeu", 
        "Marlene", "Uélinton", "Maicon", "Deivison", "Gislaine", "Claudete", 
        "Manoel", "Sebastião", "Raimundo", "Aparecida"
    );

    private static final List<String> LAST_NAMES = Arrays.asList(
        "da Silva", "dos Santos", "Pereira", "Ramirez", "Oliveira", "Souza",
        "da Conceição", "de Jesus", "Maranhão", "Rocha", "Ferreira", "Almeida",
        "Barbosa", "Ramos", "Martins", "Araújo", "Cardoso", "Gonçalves",
        "Rodrigues", "Gomes", "Nascimento", "Ribeiro", "Carvalho", "Costa", 
        "Lima", "Alves", "Monteiro", "Mendes", "Barros", "Freitas", "Teixeira", 
        "Moreira", "Correia", "Batista", "Pires", "Moraes", "Cavalcanti", 
        "Dias", "Castro", "Campos", "Andrade", "Duarte"
    );

    private static final List<String> PLACES = Arrays.asList(
        "na Esquina", "no Viaduto", "atrás da Rodoviária", "na Praça Central", 
        "no Beco", "em Frente à Loja", "perto da Obra", "no Ponto de Ônibus",
        "num Terreno Baldio", "na Boca do Bueiro", "no Orelhão", "na Fila do INSS", 
        "embaixo da Ponte", "na Porta do Estádio", "no Ponto de Táxi", "na Feira Livre", 
        "lavando Carro na Rua", "no Corredor do Hospital", "na Agência de Empregos", 
        "catando Papelão", "na Sombra da Árvore", "na Porta da Fábrica", "distribuindo Panfleto"
    );

    private static final List<String> UNEMPLOYED_PROFESSIONS = Arrays.asList(
        "Vendedor de Poema", "Disputador de Pão com Pombo", "Coach Quântico de Calçada",
        "Fiscal de Obra Voluntário", "Malabarista de Semáforo", "Domador de Gato de Rua",
        "Testador de Lanche Grátis", "Consultor de Vida de Transeunte", "Catador de Bituca",
        "Organizador de Fila", "Poeta do Ônibus", "Flanelinha de Monociclo",
        "Mímico Conceitual", "Estátua Viva (só às terças)", "Leitor de Sorte em Borra de Café"
    );

    private static final Random random = new Random();

    public static String getRandomName() {
        String firstName = FIRST_NAMES.get(random.nextInt(FIRST_NAMES.size()));
        String lastName = LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
        return firstName + " " + lastName;
    }

    public static String getRandomPlace() {
        return PLACES.get(random.nextInt(PLACES.size()));
    }

    public static String getRandomUnemployedProfession() {
        return UNEMPLOYED_PROFESSIONS.get(random.nextInt(UNEMPLOYED_PROFESSIONS.size()));
    }
}