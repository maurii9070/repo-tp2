package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Consejo;

@Component
public class ConsejoLista {
    private List<Consejo> consejos;
    private List<Consejo> consejosEncotrados;

    public List<Consejo> getConsejosEncotrados() {
        return consejosEncotrados;
    }

    public void setConsejosEncotrados(List<Consejo> consejosEncotrados) {
        this.consejosEncotrados = consejosEncotrados;
    }

    public List<Consejo> getConsejos(){
        return consejos;
    }

    public void setConsejos(List<Consejo> consejos){
        this.consejos = consejos;
    }

    public ConsejoLista(){
        consejos = new ArrayList<Consejo>();
        
        consejos.add(new Consejo("No duescuide su limpieza", "/images/aseo.jpg", "Debera realizarle un aseo periodico para asi poder detectar y tomar medidas necesarias en caso de tener parasitos externos (como pulgas, garrapatas, etc...) y enfermedades de la piel."));

        consejos.add(new Consejo("Desparasite con frecuencia a su mascota", "/images/perro_desparasitado.jpeg", "La desparasitacion de las mascotas debe llevarse a cabo antes de iniciar el suministro de las vacuna, porque ademas de eliminar los parasitos, el antiparasitario estimula las defensas y ayuda a que la vacuna produzca un mejor efecto inmune en los animales"));

        consejos.add(new Consejo("Evita los cambios bruscos de temperatura", "/images/perrito_con_calor.jpeg", "Evita las altas temperaturas en verano, dale agua fresca y limpia frecuentemente, evita los ejercicios intensos durante las horas de más calor, no olvides a tu mascota dentro del coche y evita las situaciones de estrés. Recuerda que con el calor los animales puede que no tengan tanto apetito. En invierno, al haber bajas temperaturas los animales necesitan ingerir más cantidad de energía por lo que puede aumentar su apetito, así que reparte las comidas para evitar sobrecargar su sistema digestivo."));

        consejos.add(new Consejo("Visitar regularmente el veterinario", "/images/veterinario.webp", "En la primer visita de nuestra mascota al veterinario, este se encargara de revisar su estadode salud y descartar cualquier patologia, ademas de establecer el plan de vacunacion y escoger las vacunas adecuadas para cada animal, segun el riesgo de exposicion a ciertas enfermedades y la zona de residencia. Debido a esto, no existe un calendario de vacunacion unico."));

        consejosEncotrados = new ArrayList<Consejo>();
    }
}
