package src.juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prueba {
	private TipoPrueba tipo;
    private List<Participantes> inscritos;
    private List<Participantes> eliminados;
    private List<Participantes> vencedores;
    //private Pink_guards responsable;
    
    public Prueba(TipoPrueba tipo) {
        this.tipo = tipo;
        this.inscritos = new ArrayList<>();
        this.eliminados = new ArrayList<>();
        this.vencedores = new ArrayList<>();
    }
    
//    public void asignarResponsable(Pink_guards manager) {
//        this.responsable = manager;
//    }
    
    public TipoPrueba getTipo() {
		return tipo;
	}

	public List<Participantes> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<Participantes> inscritos) {
		this.inscritos = inscritos;
	}

	public void simularPrueba(List<Participantes> Participantes) {
		setInscritos(Participantes);
    	double porcentajeEliminados = (Math.random()*tipo.getMaxEliminados() + tipo.getMinEliminados()) / 100;
//        if (responsable == null) {
//            throw new IllegalStateException("No se puede ejecutar la prueba sin un Manager responsable.");
//        }
        int eliminadosObjetivo = (int) (inscritos.size() * porcentajeEliminados);
        Collections.shuffle(inscritos);
        for (int i = 0; i < eliminadosObjetivo; i++) {
            if (!inscritos.get(i).isInfiltrado()) {
            	inscritos.get(i).eliminar();
                eliminados.add(inscritos.get(i));
            }
        }
        vencedores.addAll(inscritos);
        vencedores.removeAll(eliminados);
    }
    
    public double calcularPorcentajeExito() {
        return (double) vencedores.size() / inscritos.size() * 100;
    }
}
