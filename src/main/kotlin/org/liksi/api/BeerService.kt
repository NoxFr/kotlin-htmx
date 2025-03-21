package org.liksi.api

import org.liksi.api.model.Beer
import org.liksi.web.model.CreateBeer
import kotlin.uuid.Uuid

object BeerService {
    private val beers = mutableListOf(
        Beer(Uuid.random(), "Chouffe", "Blonde belge", 8.0, "Achouffe"),
        Beer(Uuid.random(), "Westmalle Tripel", "Tripel", 9.5, "Abbaye de Westmalle"),
        Beer(Uuid.random(), "Guinness", "Stout", 4.2, "Guinness"),
        Beer(Uuid.random(), "Chimay Bleue", "Strong Dark Ale", 9.0, "Abbaye de Chimay"),
        Beer(Uuid.random(), "Leffe Blonde", "Blonde d'Abbaye", 6.6, "AB InBev")
    )

    fun getAllBeers(): List<Beer> = beers

    fun getBeerById(id: Uuid): Beer? = beers.find { it.id == id }

    fun addBeer(beer: Beer) = beers.add(beer)

    fun sort(ids: List<Uuid>) {
        // Trier les bières selon l'ordre des IDs, puis ajouter celles qui ne sont pas dans la liste
        val orderedList = ids.mapNotNull { id -> 
            beers.find { it.id == id }
        } + beers.filter { beer -> 
            !ids.contains(beer.id)
        }
        
        beers.clear()
        beers.addAll(orderedList)
    }

    fun addBeer(beer: CreateBeer) {
        beers.add(
            0,
            Beer(
                id = Uuid.random(),
                name = beer.beerName,
                style = beer.beerStyle,
                abv = beer.abv,
                brewery = beer.brewery
            )
        )
    }
}