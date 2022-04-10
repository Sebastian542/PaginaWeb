package co.edu.unbosque.servletjsptutorial.services;

public class CrearObra {
    private String username;
    private String titulo;
    private float precio;
    private String urlobra;


    

    public CrearObra(String username, String titulo, float precio, String urlobra) {
		
		this.username = username;
		this.titulo = titulo;
		this.precio = precio;
		this.urlobra = urlobra;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getUrlobra() {
		return urlobra;
	}



	public void setUrlobra(String urlobra) {
		this.urlobra = urlobra;
	}





}
