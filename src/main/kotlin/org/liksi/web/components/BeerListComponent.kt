import kotlinx.html.*
import org.liksi.api.BeerService
import org.liksi.web.components.beerItemComponent

fun DIV.beerListComponent() {
    div {
        id = "beer-list"
        classes = setOf("bg-yellow-50 shadow-lg rounded-lg p-8 border-t-4 border-yellow-500")
        h2 {
            classes = setOf("text-3xl font-bold text-yellow-800 mb-6")
            +"Our Beer Selection"
        }

        ul {
            classes = setOf("space-y-4")
            BeerService.getAllBeers().forEach { beer ->
                beerItemComponent(beer)
            }
        }
    }
}