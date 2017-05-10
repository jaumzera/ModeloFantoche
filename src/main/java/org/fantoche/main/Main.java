package org.fantoche.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.fantoche.modelofantoche.Classe;
import org.fantoche.modelofantoche.Imagem;
import org.fantoche.modelofantoche.SuperClasse;

/**
 *
 * @author jaumzera
 */
public class Main {
    
    public static void main(String[] args) {
        
        List<SuperClasse> especies = new ArrayList<>();
        File raiz = new File("/home/jaumzera/Documents/mestrado_fantoche/teste");
        for(File dir : raiz.listFiles()) {
            if(dir.isDirectory() && !dir.getName().startsWith(".")) {
                especies.add(SuperClasse.criar(dir));
            }
        }
        
        
        for(SuperClasse especie : especies) {
            System.out.println("Espécie: " + especie.getNome());
            for(Classe classe : especie.getClasses()) {
                System.out.println("\tClasses: " + classe.getNome());
                for(Imagem imagem : classe.getImagens()) {
                    System.out.println("\t\tImagem: " + imagem.getArquivo().getName());
                }
            }
        }
        
    }
}
