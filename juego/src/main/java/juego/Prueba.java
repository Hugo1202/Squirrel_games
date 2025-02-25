package juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public TipoPrueba getTipo() {
		return tipo;
	}

	public List<Participantes> getInscritos() {
		inscritos.sort(Comparator.comparingInt(Participantes::getId));
		return inscritos;
	}

	public void setInscritos(List<Participantes> inscritos) {
		this.inscritos = inscritos;
	}

	public List<Participantes> getEliminados() {
		eliminados.sort(Comparator.comparingInt(Participantes::getId));
		return eliminados;
	}

	public List<Participantes> getVencedores() {
		vencedores.sort(Comparator.comparingInt(Participantes::getId));
		return vencedores;
	}

	public void simularPrueba(List<Participantes> participantes) {
		setInscritos(participantes);
        double porcentajeEliminados = (Math.random() * (tipo.getMaxEliminados() - tipo.getMinEliminados()) + tipo.getMinEliminados()) / 100.0;
        int eliminadosObjetivo = (int) (inscritos.size() * porcentajeEliminados);
        Collections.shuffle(inscritos);
        for (int i = 0; i < eliminadosObjetivo; i++) {
//            if (!inscritos.get(i).isEliminado()) {
                inscritos.get(i).eliminar();
                eliminados.add(inscritos.get(i));
//            }
        }
        vencedores.addAll(inscritos);
        vencedores.removeAll(eliminados);
    }
}
