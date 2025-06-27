package com.example.mikro.routes;

public final class ApiRoutes {

    public static final String BASE = "/api";

    public static final String ALQUILERES = BASE + "/alquileres";
    public static final String ALQUILERES_BICICLETA = BASE + "/alquileres-bicicleta";
    public static final String ARCHIVOS = BASE + "/archivos";
    public static final String BEACONS = BASE + "/beacons";
    public static final String BICICLETA_INVENTARIO = BASE + "/inventario";
    public static final String CLIENTES = BASE + "/clientes";
    public static final String ESTACIONES = BASE + "/estaciones";
    public static final String MANTENIMIENTOS = BASE + "/mantenimientos";
    public static final String PARTICIPANTES = BASE + "/participantes";
    public static final String PERSONAL = BASE + "/personal";
    public static final String USUARIOS = BASE + "/usuarios";
    public static final String USER = BASE + "/user";
    public static final String LOGIN = BASE + "/login";

    private ApiRoutes() {
        // Previene instanciación
    }
}
