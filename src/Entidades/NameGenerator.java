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
        "Manoel", "Sebastião", "Raimundo", "Aparecida",
        "Adalberto", "Adalgisa", "Afrânio", "Alcebíades", "Almerinda", "Altamiro",
        "Anacleto", "Anastácio", "Antenor", "Apolinário", "Argemiro", "Ariclenes",
        "Armando", "Arnaldo", "Artur", "Ascanio", "Audálio", "Balduíno", "Bartolomeu",
        "Belarmino", "Belchior", "Benigno", "Bernadete", "Blandina", "Bonifácio",
        "Bráulio", "Cacilda", "Calisto", "Cândida", "Casimiro", "Cassiano",
        "Catarina", "Celestino", "Cibele", "Cid", "Clarindo", "Clemilda", "Consuelo",
        "Constantino", "Cosme", "Crispim", "Custódio", "Dalmira", "Deise", "Delfino",
        "Deolinda", "Desidério", "Dinarte", "Dionísio", "Divino", "Domiciano",
        "Donatelo", "Dorival", "Edelmira", "Edgar", "Edite", "Edmundo", "Edivaldo",
        "Efigênio", "Egídio", "Eleonora", "Eleutério", "Elpídio", "Emanuel", "Emerenciana",
        "Epaminondas", "Epifânio", "Epitácio", "Ermelinda", "Eronildes", "Esmeralda",
        "Estanislau", "Eulália", "Eurípedes", "Eusébio", "Eustáquio", "Evaristo",
        "Fabrício", "Fagundes", "Fausto", "Felícia", "Feliciano", "Felisberto", "Ferdinando",
        "Firmino", "Flaviano", "Floriano", "Fortunato", "Frederico", "Fúlvio",
        "Galdino", "Galileu", "Gaspar", "Gastão", "Genésio", "Geraldo", "Gervásio",
        "Getúlio", "Gilmar", "Godofredo", "Graciliano", "Gregório", "Guaraci",
        "Gumercindo", "Haroldo", "Heitor", "Heliodoro", "Herculano", "Hermenegildo",
        "Hildebrando", "Hipólito", "Horácio", "Hortência", "Ifigênia", "Inácio",
        "Iolanda", "Irineu", "Isidoro", "Ismael", "Itamar", "Jacinto", "Januário",
        "Jasmim", "Jeremias", "Jeronimo", "Joaquina", "Jocasta", "Jonas", "Jovelina",
        "Juarez", "Juvêncio", "Juvenal", "Lais", "Laudelina", "Laurindo", "Leocádia",
        "Leôncio", "Leônidas", "Leopoldo", "Lídia", "Lívio", "Lourenço", "Lurdes",
        "Luzia", "Macário", "Malaquias", "Manfredo", "Marcolino", "Margarida",
        "Marieta", "Marilda", "Marinalva", "Mirtes", "Moacir", "Modesto", "Nair",
        "Napoleão", "Narciso", "Nataniel", "Nelita", "Nereu", "Nicanor", "Nivaldo",
        "Noêmia", "Norberto", "Oceano", "Odorico", "Olavo", "Olegário", "Olímpio",
        "Onofre", "Orestes", "Orlandino", "Orquídea", "Osvaldo", "Otacílio", "Oto",
        "Ovídio", "Pacífico", "Palmira", "Pascoal", "Patrício", "Petrônio",
        "Piedade", "Plácido", "Plínio", "Policarpo", "Porfírio", "Prudêncio",
        "Quincas", "Quintino", "Quirino", "Radamés", "Ramiro", "Ranulfo", "Raquel",
        "Remo", "Renato", "Romualdo", "Romeu", "Rômulo", "Rosália", "Rosalina",
        "Rosendo", "Rubens", "Rufino", "Sabino", "Salomão", "Salvador", "Sandalio",
        "Saturnino", "Saulo", "Serafim", "Severino", "Silvério", "Simplício",
"Sócrates", "Tadeu", "Tarcísio", "Telmo", "Teobaldo", "Teodoro", "Tibúrcio",
        "Ticiano", "Timóteo", "Tito", "Tobias", "Trajano", "Tristão", "Ubaldo",
        "Ulisses", "Valdemar", "Valéria", "Valfrido", "Venâncio", "Veridiana",
        "Veríssimo", "Vicente", "Virgílio", "Viriato", "Vital", "Vitório",
        "Zacarias", "Zélia", "Zulmira"
    );

    private static final List<String> LAST_NAMES = Arrays.asList(
        "da Silva", "dos Santos", "Pereira", "Ramirez", "Oliveira", "Souza",
        "da Conceição", "de Jesus", "Maranhão", "Rocha", "Ferreira", "Almeida",
        "Barbosa", "Ramos", "Martins", "Araújo", "Cardoso", "Gonçalves",
        "Rodrigues", "Gomes", "Nascimento", "Ribeiro", "Carvalho", "Costa",
        "Lima", "Alves", "Monteiro", "Mendes", "Barros", "Freitas", "Teixeira",
        "Moreira", "Correia", "Batista", "Pires", "Moraes", "Cavalcanti",
        "Dias", "Castro", "Campos", "Andrade", "Duarte",
        "Abreu", "Aguiar", "Amaral", "Arruda", "Assis", "Assunção", "Azevedo",
        "Bandeira", "Bastos", "Bezerra", "Borges", "Braga", "Brandão", "Brito",
        "Calixto", "Camargo", "Câmara", "Cordeiro", "Correa", "Coutinho", "Cunha",
        "Dantas", "Dorneles", "Esteves", "Faria", "Farias", "Fernandes", "Figueiredo",
        "Fonseca", "Fontes", "Fraga", "Furtado", "Galvão", "Garcia", "Guedes",
        "Guerra", "Guimarães", "Gusmão", "Henriques", "Lacerda", "Leal", "Leão",
        "Leite", "Leme", "Lopes", "Macedo", "Machado", "Maciel", "Magalhães",
        "Maia", "Malafaia", "Marques", "Melo", "Menezes", "Mesquita", "Miranda",
        "Moura", "Muniz", "Neves", "Nobre", "Nogueira", "Noronha", "Nunes",
        "Pacheco", "Padilha", "Paes", "Paiva", "Peixoto", "Penteado", "Pestana",
        "Pinheiro", "Pinto", "Porto", "Prado", "Queiroz", "Reis", "Resende",
        "Sá", "Salles", "Sampaio", "Santana", "Santiago", "Saraiva", "Seabra",
        "Siqueira", "Soares", "Tavares", "Teles", "Torres", "Trindade", "Vargas",
        "Vasconcelos", "Viana", "Vieira", "Vilela", "Xavier", "Zimmermann"
    );

    private static final List<String> PLACES = Arrays.asList(
        "na Esquina", "no Viaduto", "atrás da Rodoviária", "na Praça Central",
        "no Beco", "em Frente à Loja", "perto da Obra", "no Ponto de Ônibus",
        "num Terreno Baldio", "na Boca do Bueiro", "no Orelhão", "na Fila do INSS",
        "embaixo da Ponte", "na Porta do Estádio", "no Ponto de Táxi", "na Feira Livre",
        "lavando Carro na Rua", "no Corredor do Hospital", "na Agência de Empregos",
        "catando Papelão", "na Sombra da Árvore", "na Porta da Fábrica", "distribuindo Panfleto",
        "no Bar do Zé", "na Lan House", "sentado no Meio-Fio", "na Calçada da Fama (local)",
        "olhando a Vitrine", "no Balcão da Padaria", "na Fila do Banco", "esperando o Metrô",
        "no Parque da Cidade", "na Cantina da Escola", "no Posto de Saúde",
        "atrás do Mercado", "no Pátio da Igreja", "na Barbearia do Adão",
        "na Oficina Mecânica", "no estacionamento do Shopping", "na porta da Lotérica",
        "no Fliperama", "vendendo paçoca no trem", "no Largo da Matriz", "na escadaria",
        "no Campinho de Terra", "na Banca de Jornal", "dentro da Agência dos Correios",
        "na escada rolante", "no caixa eletrônico", "fazendo um lanche no quiosque",
        "na porta do cinema", "no terminal de integração", "observando o trânsito",
        "na loja de 1,99", "no camelódromo", "na fila da pipoca", "no bebedouro público",
        "apoiado no poste", "na janela do apartamento", "no corredor do prédio"
    );

    private static final List<String> UNEMPLOYED_PROFESSIONS = Arrays.asList(
        "Vendedor de Poema", "Disputador de Pão com Pombo", "Coach Quântico de Calçada",
        "Fiscal de Obra Voluntário", "Malabarista de Semáforo", "Domador de Gato de Rua",
        "Testador de Lanche Grátis", "Consultor de Vida de Transeunte", "Catador de Bituca",
        "Organizador de Fila", "Poeta do Ônibus", "Flanelinha de Monociclo",
        "Mímico Conceitual", "Estátua Viva (só às terças)", "Leitor de Sorte em Borra de Café",
        "Caçador de Sinal de Wi-Fi Aberto", "Contador de Azulejo em Banheiro Público",
        "Especialista em Manobras de Carrinho de Supermercado", "Degustador de Amostra Grátis",
        "Filósofo de Fim de Festa", "Arquiteto de Castelo de Areia", "Sommelier de Água da Bica",
        "Engenheiro de Gambiarra", "Narrador de Jogo de Dominó", "Personal Trainer de Cão Guia",
        "Coreógrafo de Valsa de Formatura (sem convite)", "Crítico de Música de Elevador",
        "Guia Turístico de Bairro Desconhecido", "Harmonizador de Ambiente com Incenso de Vareta",
        "Testador de Conforto de Banco de Praça", "Comentarista de Novela na Padaria",
        "Influenciador Digital de Rede Social Inexistente", "Caçador de Ofertas Vencidas",
        "Tradutor de Miado de Gato para Latim", "Reciclador de Sonhos Descartados",
        "Analista de Previsão do Tempo (só erra)", "Figurante de Fila Aleatória",
        "Colecionador de Tampinha de Garrafa Rara", "Psicólogo de Planta Carnívora",
        "Detetive de Objeto Perdido (que ele mesmo perdeu)", "Mestre de Cerimônias de Rinha de Galo (imaginária)",
        "Inventor de Problemas para Vender a Solução", "Guardião de Segredo que Ninguém Ligou",
        "DJ de Rádio Pirata de Baixíssimo Alcance", "Especialista em Teorias da Conspiração de Botequim"
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