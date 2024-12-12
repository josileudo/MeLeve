package com.example.meleve.data.model.mock

import com.example.meleve.data.model.MeLeveOptions
import com.example.meleve.data.model.MeLeveReview

val mockOptions: List<MeLeveOptions> = arrayListOf(
    MeLeveOptions(
        id = 1,
        name ="Gustavo santiago",
        description = "Olá! Sou o Homer, seu motorista camarada! Relaxe e aproveite o passeio, com direito a rosquinhas e boas risadas (e talvez alguns desvios).",
        vehicle = "Cruze de cor branca",
        review = MeLeveReview(
            rating = 3,
            comment = "Gustavo sempre é bem solicito"
        ),
        value = 20.0
    ),

    MeLeveOptions(
        id = 2,
        name ="José de assis",
        description = "Olá! Sou o Barney, seu motorista gente fina!  Aproveite o passeio",
        vehicle = "Pálio bem novinho",
        review = MeLeveReview(
            rating = 4,
            comment = "José gente boa"
        ),
        value = 35.5
    ),

    MeLeveOptions(
        id = 3,
        name ="Moisés Castro",
        description = "Olá! Sou o Moisés, vamos comer rosquinhas e dar boas risadas (e talvez alguns desvios).",
        vehicle = "Siena de cor verde",
        review = MeLeveReview(
            rating = 4,
            comment = "Gustavo sempre é bem solicito"
        ),
        value = 45.5
    ),
)