package de.idrinth.gods_and_heroes.services;

public class Rounding {
    public static long floor(double value) {
        return Math.round(Math.floor(value));
    }
    public static long ceil(double value) {
        return Math.round(Math.ceil(value));
    }
    public static long round(double value) {
        return Math.round(value);
    }
}
