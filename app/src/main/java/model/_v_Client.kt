package model

data class _v_Client(
    var _v_nomPrenoms: String,
    var _v_telephone: String,

    var _v_epaule: String? = null,
    var _v_poitrine: String? = null,
    var _v_longueurTaille: String? = null,
    var _v_tourVentrale: String? = null,
    var _v_hanche: String? = null,
    var _v_longueurCorsage: String? = null,
    var _v_ceinture: String? = null,
    var _v_longueurJupe: String? = null,
    var _v_longueurRobe: String? = null,
    var _v_longueurManche: String? = null,
    var _v_tailleManche: String? = null,
    var _v_longueurPantalon: String? = null,
    var _v_longueurRobeCourte: String? = null,
    var _v_tourCuisses: String? = null,
    var _v_longueurGenoux: String? = null,
    var _v_tourGenoux: String? = null,
    var _v_bas: String? = null,
    var _v_autresMesures: String? = null,

    var _v_dateCommande: String = "",
    var _v_dateLivraison: String = "",

    var _v_sommeTotale: Double = 0.0,
    var _v_avance: Double = 0.0,
    var _v_reste: Double = 0.0
)
