import kotlinx.html.*
import org.liksi.api.BeerService
import org.liksi.web.components.beerItemComponent

fun DIV.beerListComponent() {
    div {
        id = "beer-list"
        classes = setOf("bg-yellow-50 shadow-lg rounded-lg p-8 mt-10 border-t-4 border-yellow-500")


        h2 {
            classes = setOf("text-3xl font-bold text-yellow-800 mb-6")
            +"Our Beer Selection"
        }
        p {
            classes = setOf("text-sm text-yellow-700 mb-4 flex items-center bg-yellow-100 p-2 rounded-md border border-yellow-300")
            span {
                classes = setOf("mr-2 text-yellow-800")
                +"💡"
            }
            +"Drag beers to reorder them. New order will be saved automatically."
        }
        form {
            attributes["hx-get"] = "/beers"
            attributes["hx-trigger"] = "end"
            attributes["hx-target"] = "#beer-list"
            attributes["hx-swap"] = "outerHTML"
            ul {
                classes = setOf("space-y-2 sortable")
                li {
                    classes = setOf("text-3xl text-center htmx-indicator")
                    +"Loading beers..."
                }
                BeerService.getAllBeers().forEach { beer ->
                    beerItemComponent(beer)
                }
            }
        }
    }
}