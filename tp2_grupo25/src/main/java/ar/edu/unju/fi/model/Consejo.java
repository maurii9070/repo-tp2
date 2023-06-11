package ar.edu.unju.fi.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component
public class Consejo {

    @NotEmpty(message = "El campo titulo es obligatorio")
    private String titulo;

    private String imgUrl;

    @Length(min = 20, message = "El consejo debe tener almenos 20 caracteres")
    private String consejo;

    public Consejo() {
    }
    public Consejo(String titulo, String imgUrl, String consejo) {
        this.titulo = titulo;
        this.imgUrl = imgUrl;
        this.consejo = consejo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getConsejo() {
        return consejo;
    }
    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    
}
