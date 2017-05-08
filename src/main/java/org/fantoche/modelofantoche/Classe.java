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
public class Classe implements Serializable {

    public static Classe criar(File caminho) {
        Classe classe = new Classe();
        classe.caminho = caminho;

        // TODO extrair utilitário e substituir códigos repetidos
        String[] parts = caminho.getAbsolutePath().split(
                String.valueOf(File.separatorChar));

        classe.nome = parts[parts.length - 1].toLowerCase()
                .replaceAll(
                        "[\\s,]+", "_");

        return classe;
    }

    private String nome;

    private File caminho;

    private SuperClasse superClasse;

    private List<Imagem> imagens;
    
    public void addImagem(Imagem imagem) {
        imagem.setClasse(this);
        if(imagens == null) {
            imagens = new ArrayList<>();
        }
        imagens.add(imagem);
    }
 
    public List<Imagem> getImagens() {
        if (imagens == null) {
            for (File file : caminho.listFiles()) {
                if (file.isFile() && isImagem(file)) {
                    Imagem imagem = Imagem.criar(file);
                    addImagem(imagem);
                }
            }
        }
        
        return imagens;
    }

    private boolean isImagem(File file) {
        return file.getName().endsWith("JPG") || file.getName().endsWith("jpg");
    }
}
