package DTO;

import domein.Edele;
import domein.EdelenRepository;
import domein.Edelsteenfiche;
import domein.Ontwikkelingskaart;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public record SpelDTO(List<Edele> edelen,
                      Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau1,
                      Stack<Ontwikkelingskaart>ontwikkelingskaartenNiveau2,
                      Stack<Ontwikkelingskaart>ontwikkelingskaartenNiveau3,
                      Stack<Edelsteenfiche> ficheWit,
                      Stack<Edelsteenfiche> ficheBlauw,
                      Stack<Edelsteenfiche> ficheGroen,
                      Stack<Edelsteenfiche> ficheRood,
                      Stack<Edelsteenfiche> ficheZwart) {
}
