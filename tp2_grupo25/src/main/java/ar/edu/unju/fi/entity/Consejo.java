package ar.edu.unju.fi.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Component
@Entity
@Table(name = "Consejos")
public class Consejo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cjo_id")
    private Long id;

    @Column(name = "cjo_titulo", length = 30, nullable = false)
    @NotEmpty(message = "El campo titulo es obligatorio")
    private String titulo;

    @Column(name = "cjo_imgUrl")
    private String imgUrl;

    @Column(name = "cjo_consejo", nullable = false)
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
