package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Imagem;
import br.edu.iftm.ecommerce.repository.ImagemRepository;
import br.edu.iftm.ecommerce.util.Assert;
import br.edu.iftm.ecommerce.util.Constants;
import br.edu.iftm.ecommerce.util.MimeTypes;
import br.edu.iftm.ecommerce.util.Sha1Hex;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.file.UploadedFile;

public class ImagemLogic implements CrudLogic<Imagem>{

    @Inject
    private ImagemRepository repository;

    @Override
    public Imagem salvar(Imagem entidade) throws ErroSistemaException, ErroNegocioException{
        if("".equals(entidade.getNome())) {
            throw new ErroNegocioException("Por favor informe o nome.");
        }
        if(Assert.isNull(entidade.getDataCriacao())) {
            entidade.setDataCriacao(new Date());
        }
        
        UploadedFile file = entidade.getFile();
        System.out.println("################## salvar arquivo");
        System.out.println(file.getFileName());
        System.out.println(file.getContent().length);
        String nomeArquivo = gerarNomeArquivo(file);
        entidade.setCodigo(nomeArquivo);
        entidade = this.repository.save(entidade);
        salvarEmDisco(file, nomeArquivo);
        return entidade;
    }

    @Override
    public void remover(Imagem entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Imagem buscarPorId(Imagem entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }

    @Override
    public List<Imagem> buscar(Imagem entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }

    public String gerarNomeArquivo(UploadedFile file) throws ErroSistemaException{
        String extesao = MimeTypes.getDefaultExt(file.getContentType());

        String nomeArquivo = Sha1Hex.getHexWithRandomSalt(file.getContent()) + "." + extesao;
        return nomeArquivo;
    }
    
    private void salvarEmDisco(UploadedFile file, String nomeArquivo) throws ErroSistemaException{
        try {
            OutputStream out = new FileOutputStream(Constants.FOLDER_IMAGES + nomeArquivo);
            out.write(file.getContent());
            out.close();
        } catch (IOException ex) {
            throw new ErroSistemaException("Erro ao salvar a imagem em disco.", ex);
        }
    }
}
