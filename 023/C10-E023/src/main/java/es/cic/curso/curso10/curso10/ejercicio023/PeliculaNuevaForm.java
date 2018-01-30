package es.cic.curso.curso10.curso10.ejercicio023;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

import es.cic.curso.curso10.curso10.ejercicio023.dominio.Pelicula;

public class PeliculaNuevaForm extends FormLayout
{
	private static final long serialVersionUID = 7854103764337669112L;

	@PropertyId("titulo")
	protected TextField titulo;
	
	@PropertyId("director")
	protected TextField director;
	
	@PropertyId("duracion")
	protected TextField duracion;
	
	private Button crea;
	
	@SuppressWarnings("unused")
	private Pelicula pelicula;
	
	private MyUI padre;
	
	public PeliculaNuevaForm(MyUI padre)
	{
		this.padre = padre;
		
		titulo = new TextField("Titulo: ");
		director = new TextField("Director: ");
		duracion = new TextField("Duracion (min): ");
		
		crea = new Button("Crea Nueva");
		crea.addClickListener(e -> {
			padre.cargaGrid();
			setPelicula(null);
		});
		
		addComponents(titulo, director, duracion, crea);
		
		setPelicula(null);
	}

	public void setPelicula(Pelicula pelicula)
	{
		this.setVisible(pelicula != null);
		this.pelicula = pelicula;

		if (pelicula != null) {
			padre.nuevaPelicula(pelicula);
			BeanFieldGroup.bindFieldsUnbuffered(pelicula, this);
		} else {
			BeanFieldGroup.bindFieldsUnbuffered(new Pelicula(), this);
		}
	}
}
