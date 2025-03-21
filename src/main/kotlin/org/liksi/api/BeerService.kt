package org.liksi.api

import org.liksi.api.model.Beer
import org.liksi.web.model.CreateBeer

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

    fun addBeer(beer: Beer) = beers.add(beer)

    fun sort(ids: List<String>) {
        // Trier les bières selon l'ordre des IDs, puis ajouter celles qui ne sont pas dans la liste
        val orderedList = ids.mapNotNull { id -> 
            beers.find { it.id.toString() == id } 
        } + beers.filter { beer -> 
            !ids.contains(beer.id.toString()) 
        }
        
        beers.clear()
        beers.addAll(orderedList)
    }

    fun addBeer(beer: CreateBeer) {
        beers.add(
            0,
            Beer(
                id = beers.size,
                name = beer.beerName,
                style = beer.beerStyle,
                abv = beer.abv,
                brewery = beer.brewery
            )
        )
    }
}