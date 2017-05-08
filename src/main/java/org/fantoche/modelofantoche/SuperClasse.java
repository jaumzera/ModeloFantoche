package org.fantoche.modelofantoche;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jaumzera
 */
@Data
public class SuperClasse implements Serializable {  
    
    public static SuperClasse criar(File caminho) {
        SuperClasse sc = new SuperClasse();
        sc.caminho = caminho;
        String[] parts = caminho.getAbsolutePath().split(
                String.valueOf(File.separatorChar)); 
        
        sc.nome = parts[parts.length - 1].toLowerCase().replaceAll(
                "[\\s,]+", "_");
        
        return sc;
    }
    
    private String nome;
    
    private File caminho;
    
    private List<Classe> classes;
    
    public void addClasse(Classe classe) {
        if(classes == null) {
            classes = new ArrayList<>();
        }  
        
        classe.setSuperClasse(this);
        classes.add(classe);
    }
    
    public List<Classe> getClasses() {
        if(classes == null) {
            for(File file : caminho.listFiles()) {
                if(file.isDirectory() 
                        && !file.getName().startsWith(".")) {
                    
                    Classe classe = Classe.criar(file);
                    addClasse(classe);
                }
            }
        }
        
        return classes;
    }
}
