package models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private Integer idComentario;

    @NotNull(message = "Debes comentar algo")
    private String descripcionComentario;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-YYYY")
    private LocalDate fechaComentario;


    @NotNull(message = "El comentario debe tener especificado quien lo hizo")
    private String nombreUsuarioComentario;
    // private Usuario usuarioComentario;//PUEDE GENERAR ERROR

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="idPublicacion",referencedColumnName = "idPublicacion")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Publicacion publicacionComentario;




    @PrePersist
    public void addDate(){
        if (isNull(this.fechaComentario)){
            this.fechaComentario= LocalDate.now();
        }
    }
}
