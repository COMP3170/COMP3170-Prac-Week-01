package comp3170.week1;

import static org.lwjgl.opengl.GL15.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL15.glClear;
import static org.lwjgl.opengl.GL15.glClearColor;
import static org.lwjgl.opengl.GL15.glViewport;

import java.io.File;
import java.io.IOException;

import comp3170.IWindowListener;
import comp3170.OpenGLException;
import comp3170.ShaderLibrary;
import comp3170.Window;

public class Week1 implements IWindowListener { 

	final private File DIRECTORY = new File("src/shaders");
	
	// The actual window. This class has been provided to you in the 3170 library.
	private Window window;

	private int screenWidth = 800;
	private int screenHeight = 800;
	
	private Scene scene;
	
	public Week1() throws OpenGLException {
		window = new Window("Hello Triangle!", screenWidth, screenHeight, this);
		window.setResizable(false);
		window.run();
	}
	
	public void init() { // Run when the window is launched
		new ShaderLibrary(DIRECTORY); // Create a singleton instance of the shader library, pointing to the directory.
		scene = new Scene(screenWidth, screenHeight); // Instantiate the scene.
		
		glClearColor(0.13f, 0.21f, 0.33f, 1.0f); // Unity blue
	}		
	
	public void draw() { // draw is called every frame.		
		glClear(GL_COLOR_BUFFER_BIT);
		
		scene.draw();
	}
	@Override
	public void resize(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		
		glViewport(0,0, width, height);
	}

	@Override
	public void close() {
		
	}
	
	public static void main(String[] args) throws IOException, OpenGLException {
		new Week1();
	}

}