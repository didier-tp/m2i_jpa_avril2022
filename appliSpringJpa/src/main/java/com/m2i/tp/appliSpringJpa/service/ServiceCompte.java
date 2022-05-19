package com.m2i.tp.appliSpringJpa.service;

public interface ServiceCompte {
    void virement(double montant, Integer numCptDeb , Integer numCptCred) throws RuntimeException;
    //+ autres méthodes potentielles
}
