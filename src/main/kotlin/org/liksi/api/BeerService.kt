package org.liksi.api

import org.liksi.api.model.Beer

object BeerService {
    private val beers = mutableListOf(
        Beer(1, "Chouffe", "Blonde belge", 8.0, "Achouffe"),
        Beer(2, "Westmalle Tripel", "Tripel", 9.5, "Abbaye de Westmalle"),
        Beer(3, "Guinness", "Stout", 4.2, "Guinness"),
        Beer(4, "Chimay Bleue", "Strong Dark Ale", 9.0, "Abbaye de Chimay"),
        Beer(5, "Leffe Blonde", "Blonde d'Abbaye", 6.6, "AB InBev")
    )

    fun getAllBeers(): List<Beer> = beers

    fun getBeerById(id: Int): Beer? = beers.find { it.id == id }

    fun addBeer(beer: Beer) {
        val newId = (beers.maxOfOrNull { it.id } ?: 0) + 1
        beers.add(0, beer.copy(id = newId))
    }
}