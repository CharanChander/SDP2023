package DTO;

import domein.Edele;
import domein.Edelsteenfiche;
import domein.Ontwikkelingskaart;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public record SpelerDTO(String gebruikersnaam, int totaalPrestigepunten, boolean isAanDeBeurt, Object startSpeler, Stack<Ontwikkelingskaart> ontwikkelingskaarten, Map<Edelsteenfiche, Integer> edelsteenfiches, List<Edele> edelen){

}
