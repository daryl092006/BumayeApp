package model

data class Client(
    var nomPrenoms: String,
    var telephone: String,

    var epaule: String? = null,
    var poitrine: String? = null,
    var longueurTaille: String? = null,
    var tourVentrale: String? = null,
    var hanche: String? = null,
    var longueurCorsage: String? = null,
    var ceinture: String? = null,
    var longueurJupe: String? = null,
    var longueurRobe: String? = null,
    var longueurManche: String? = null,
    var tailleManche: String? = null,
    var longueurPantalon: String? = null,
    var longueurRobeCourte: String? = null,
    var tourCuisses: String? = null,
    var longueurGenoux: String? = null,
    var tourGenoux: String? = null,
    var bas: String? = null,
    var autresMesures: String? = null,

    var dateCommande: String = "",
    var dateLivraison: String = "",

    var sommeTotale: Double = 0.0,
    var avance: Double = 0.0,
    var reste: Double = 0.0
)
