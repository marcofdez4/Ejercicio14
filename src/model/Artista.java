package model;

public class Artista implements ArtistaI{

	private String nombre;
	private String genero;
	private Integer numeroReproducciones;
	private String paisMasEscucha;

	public Artista(String nombre, String genero, Integer numeroReproducciones, String paisMasEscucha) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.numeroReproducciones = numeroReproducciones;
		this.paisMasEscucha = paisMasEscucha;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getNumeroReproducciones() {
		return numeroReproducciones;
	}
	public void setNumeroReproducciones(Integer numeroReproducciones) {
		this.numeroReproducciones = numeroReproducciones;
	}
	public String getPaisMasEscucha() {
		return paisMasEscucha;
	}
	public void setPaisMasEscucha(String paisMasEscucha) {
		this.paisMasEscucha = paisMasEscucha;
	}

	@Override
	public Double recaudacionMontetaria() {
		
		return this.numeroReproducciones*0.2;
	}

	@Override
	public Double proyeccionAnual() {
		
		return this.recaudacionMontetaria()*12;
	}
	
	
}
