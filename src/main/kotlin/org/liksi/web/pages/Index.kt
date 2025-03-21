package org.liksi.web.pages

import beerListComponent
import kotlinx.html.*
import org.liksi.web.components.beerCreationForm
import org.liksi.web.components.footerComponent
import org.liksi.web.components.headerComponent

fun HTML.index() {
    head {
        title { +"Kotlin with HTMX" }
        script(src = "/webjars/htmx.org/2.0.4/dist/htmx.min.js") {}
        script(src = "/webjars/htmx-ext-json-enc/2.0.2/dist/json-enc.min.js") {}
        script(src = "/webjars/sortablejs/1.15.6/Sortable.js") {}
        script(src = "https://cdn.tailwindcss.com") {}
        script(type = ScriptType.textJavaScript) {
            unsafe {
                raw(
                    """
                    htmx.onLoad(function(content) {
                        var sortables = content.querySelectorAll(".sortable");
                        for (var i = 0; i < sortables.length; i++) {
                          var sortable = sortables[i];
                          var sortableInstance = new Sortable(sortable, {
                              animation: 150,
                              ghostClass: 'bg-yellow-200',
                              dragClass: 'shadow-lg',
                              delay: 150,
                              delayOnTouchOnly: true,
                              touchStartThreshold: 5,

                              // Make the `.htmx-indicator` unsortable
                              filter: ".htmx-indicator",
                              onMove: function (evt) {
                                return evt.related.className.indexOf('htmx-indicator') === -1;
                              },

                              // Disable sorting on the `end` event
                              onEnd: function (evt) {
                                this.option("disabled", true);
                                
                                // Affiche un indicateur visuel de réussite
                                if (evt.oldIndex !== evt.newIndex) {
                                  var movedElement = evt.item;
                                  movedElement.classList.add('bg-green-100');
                                  setTimeout(function() {
                                    movedElement.classList.remove('bg-green-100');
                                  }, 1000);
                                }
                              }
                          });

                          // Re-enable sorting on the `htmx:afterSwap` event
                          sortable.addEventListener("htmx:afterSwap", function() {
                            sortableInstance.option("disabled", false);
                          });
                        }
                    })

                     // Pour fermer le dialogue lorsqu'on clique en dehors
                    document.addEventListener('click', function(event) {
                      var dialog = document.getElementById('beer-detail');
                      if (dialog && dialog.hasAttribute('open')) {
                        var dialogContent = dialog.querySelector('div:nth-child(2)');
                        if (dialogContent && !dialogContent.contains(event.target)) {
                          dialog.removeAttribute('open');
                        }
                      }
                    });
                    
                """.trimIndent()
                )
            }
        }
    }
    body {
        classes = setOf("bg-gray-100 flex items-center justify-center min-h-screen")
        div {
            classes = setOf("container mx-auto p-4")
            headerComponent()
            div {
                id = "beer-detail"
            }
            beerCreationForm()
            beerListComponent()
            footerComponent()
        }
    }
}