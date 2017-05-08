package org.fantoche.modelofantoche;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;

/**
 *
 * @author jaumzera
 */
@Data
public class Imagem implements Serializable {

    private static final Logger LOG
            = Logger.getLogger(Imagem.class.getName());
    
    public static Imagem criar(File arquivo) {
        Imagem imagem = new Imagem();
        imagem.arquivo = arquivo;
        return imagem;
    }

    public Classe classe;

    public File arquivo;

    public byte[] bytes;
    
    public byte[] getByte() {
        if(bytes == null) {
            bytes = reduzirPara32x32(arquivo);
        }
        
        return bytes;
    }
   
    public byte[] reduzirPara32x32(File imagem) {
        byte[] reduzida = new byte[3072];
        try {
            FileReader fr = new FileReader(arquivo);
            // reduz a imagem para 32x32
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return reduzida;
    }
   

}
