package com.example.f5onz.applicationprojet.tool

class Animaux {

    var id : Int = 0
    var nom : String = ""
    var prenom : String = ""
    var race : String = ""
    var numero : Int = 0
    var sexe : String = ""

    constructor(nom: String, prenom: String, race: String, sexe: String){
        this.nom = nom
        this.prenom = prenom
        this.race = race
        this.numero = numero
        this.sexe = sexe
    }

    constructor(){
    }
}