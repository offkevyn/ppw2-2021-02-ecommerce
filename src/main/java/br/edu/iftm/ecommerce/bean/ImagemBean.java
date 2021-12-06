package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.ImagemLogic;
import br.edu.iftm.ecommerce.model.Imagem;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Named
@SessionScoped
public class ImagemBean extends CrudBean<Imagem, ImagemLogic> {

    @Inject
    private ImagemLogic logic;
    private List<Imagem> imagens;
    private UploadedFile file;

    public ImagemBean() {
        super(Imagem.class);
    }

    @Override
    public ImagemLogic getLogic() {
        return this.logic;
    }

    public List<Imagem> listaImagems() {
        try {
            return logic.buscar(null);
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        System.out.println(event.getFile().getContent().length);;
        getEntidade().setFile(event.getFile());
    }

}
