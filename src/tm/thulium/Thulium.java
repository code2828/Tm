package tm.thulium;

import java.util.Random;

import org.lwjgl.glfw.GLFWKeyCallback;

public class Thulium {

	public Thulium() {
	}

	// The window handle
	private long window;
	@SuppressWarnings("unused")
	private GLFWKeyCallback keyCallback;
	public static final Random R = new Random();
	private static final String vertexSource = "#version 150 core\n"
			+ "\n"
			+ "in vec3 position;\n"
			+ "in vec3 color;\n"
			+ "\n"
			+ "out vec3 vertexColor;\n"
			+ "\n"
			+ "uniform mat4 model;\n"
			+ "uniform mat4 view;\n"
			+ "uniform mat4 projection;\n"
			+ "\n"
			+ "void main() {\n"
			+ "    vertexColor = color;\n"
			+ "    mat4 mvp = projection * view * model;\n"
			+ "    gl_Position = mvp * vec4(position, 1.0);\n"
			+ "}";
	private static final String fragmentSource = "#version 150 core\n"
			+ "\n"
			+ "in vec3 vertexColor;\n"
			+ "\n"
			+ "out vec4 fragColor;\n"
			+ "\n"
			+ "void main() {\n"
			+ "    fragColor = vec4(vertexColor, 1.0);\n"
			+ "}";

	public static void main(String[] args) {
//		System.out.println("Hello Thulium!");
//		ReadInformationUtil.read(System.in);
//		System.out.println("Added districts:");
//		XzqhUtil.printInTree();
		new Initializer().run();
	}

}
