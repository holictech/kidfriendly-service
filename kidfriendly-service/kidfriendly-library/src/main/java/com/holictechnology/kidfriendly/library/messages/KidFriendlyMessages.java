package com.holictechnology.kidfriendly.library.messages;


public final class KidFriendlyMessages {

    private KidFriendlyMessages() {}

    /*
     * DEFAULT
     */
    public static final String ERROR_ILLEGALARGUMENT = "O argumento informdo n\u00e3o \u00e9 valido.";

    /*
     * CATEGORY
     */
    public static final String ERROR_LIST_CATEGORY = "N\u00e3o foi poss\u00edvel listar as categorias.";

    /*
     * COMPANY
     */
    public static final String ERROR_LIST_COMPANY = "N\u00e3o foi poss\u00edvel listar os estabelecimentos.";
    public static final String ERROR_COMPANY_BY_PRIMARY_KEY = "N\u00e3o foi poss\u00edvel obter o estabelecimento.";
    public static final String ERROR_COMPANY_SAVE = "N\u00e3o foi poss\u00edvel cadastrar o estabelecimento.";

    /*
     * CHARACTERISTIC
     */
    public static final String ERROR_LIST_CHARACTERISTIC = "N\u00e3o foi poss\u00edvel listar as caracter\u00edsticas.";

    /*
     * RATING
     */
    public static final String ERROR_LIST_RATING = "N\u00e3o foi poss\u00edvel listar as avalia\u00e7\u00f5es.";
    public static final String ERROR_ACTIVATE_RATING = "N\u00e3o foi poss\u00edvel ativar a avalia\u00e7\u00e3o.";
    public static final String ERROR_NOT_FOUND_RATING = "Avalia\u00e7\u00e3o n\u00e3o encontrada.";
    public static final String ERROR_DELETE_RATING = "N\u00e3o foi poss\u00edvel deletar a avalia\u00e7\u00e3o.";
    public static final String ERROR_INCLUDE_RATING = "N\u00e3o foi poss\u00edvel registrar sua avalia\u00e7\u00e3o.";
    public static final String ERROR_HAS_PERMISSION_RATING = "N\u00e3o foi poss\u00edvel obter a permiss\u00e3o para realizar sua avalia\u00e7\u00e3o.";

    /*
     * LOCALITY
     */
    public static final String ERROR_LIST_COUNTRY = "N\u00e3o foi poss\u00edvel listar os pa\u00edses.";
    public static final String ERROR_LIST_STATE = "N\u00e3o foi poss\u00edvel listar os estados.";
    public static final String ERROR_LIST_CITY = "N\u00e3o foi poss\u00edvel lista as cidades.";

    /*
     * IMAGE
     */
    public static final String ERROR_LIST_IMAGE = "N\u00e3o foi poss\u00edvel listar as imagens.";

    /*
     * LOGIN
     */
    public static final String ERROR_AUTHENTICATE_LOGIN_NOT_FOUND = "Email n\u00e3o encontrado.";
    public static final String ERROR_AUTHENTICATE_CREATE_TOKEN = "N\u00e3o foi poss\u00edvel gerar o token de autentica\u00e7\u00e3o.";
    public static final String ERROR_AUTHENTICATE_LOGIN = "N\u00e3o foi poss\u00edvel efetuar o login.";
    public static final String ERROR_INCLUDE_LOGIN = "O email informado j\u00e1 existente.";

    /*
     * USER
     */
    public static final String ERROR_INCLUDE_USER = "N\u00e3o foi poss\u00edvel efetuar o cadastro.";
}
