import kotlinx.html.*
import org.liksi.api.BeerService
import org.liksi.web.components.beerItemComponent

private val beerService = BeerService()

fun DIV.beerListComponent() {
    div {
        classes = setOf("bg-white shadow-md rounded-lg p-6")
        h2 {
            classes = setOf("text-2xl font-semibold text-gray-800 mb-4")
            +"Liste des bières"
        }

        ul {
            classes = setOf("space-y-2")
            beerService.getAllBeers().forEach { beer ->
                beerItemComponent(beer)
            }
        }
    }
}