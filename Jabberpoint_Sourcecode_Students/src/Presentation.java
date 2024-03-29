import java.util.ArrayList;
import java.util.HashSet;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
	private String showTitle; //The title of the presentation
	private ArrayList<Slide> slides = null; //An ArrayList with slides
	private int currentSlideNumber = 0; //The number of the current slide
	private SlideViewerComponent slideViewComponent = null; //The view component of the slides

	public Presentation() {
		slideViewComponent = null;
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
		clear();
	}


	public int getSize() {
		return slides.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	//Returns the number of the current slide
	public int getSlideNumber() {
		return currentSlideNumber;
	}

	//Change the current slide number and report it the window
	public void setSlideNumber(int number) {
		if(number > 0 && !(number > slides.size() - 1) ){
			currentSlideNumber = number;
		} else if (number > slides.size() - 1) {
				currentSlideNumber = (slides.size() - 1);
		}else if(number < -1){
			currentSlideNumber = 1;
		} else {
				currentSlideNumber = number;
		}
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	//Navigate to the previous slide unless we are at the first slide
	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
	    }
	}

	//Navigate to the next slide unless we are at the last slide
	public void nextSlide() {
		if (currentSlideNumber < (slides.size()-1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	//Remove the presentation
	void clear() {
		slides = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	//Add a slide to the presentation
	public void append(Slide slide) {
		slides.add(slide);
	}

	//Return a slide with a specific number
	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
		}
		return (Slide)slides.get(number);
	}

	//Return the current slide
	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}

	public ArrayList<Slide> getSlides(){
		return this.slides;
	}
}
