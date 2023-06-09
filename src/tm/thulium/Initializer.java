package tm.thulium;

import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;

import tm.thulium.Renderer.Mesh;

public class Initializer {
	private long window;

	public void run() {
		init();
		loop();

		Callbacks.glfwFreeCallbacks(window);
		GLFW.glfwDestroyWindow(window);

		GLFW.glfwTerminate();
		GLFW.glfwSetErrorCallback(null).free();
	}

	public void init() {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!GLFW.glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		GLFW.glfwDefaultWindowHints();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);

		window = GLFW.glfwCreateWindow(640, 480, "LWJGL Bootcamp", NULL, NULL);
		if (window == NULL) {
			throw new IllegalStateException("Unable to create GLFW Window");
		}

		GLFW.glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
		});

		try (MemoryStack stack = stackPush()) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			GLFW.glfwGetWindowSize(window, pWidth, pHeight);

			GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

			GLFW.glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2,
					(vidmode.height() - pHeight.get(0)) / 2);

			GLFW.glfwMakeContextCurrent(window);
			GL.createCapabilities();
			GLFW.glfwSwapInterval(1);
			GLFW.glfwShowWindow(window);
		}
	}

	public void loop() {
		GLFW.glfwMakeContextCurrent(window);
		GL.createCapabilities();
		float[] vertices = { -0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0f, 0.5f, 0f };
		int[] indices = { 0, 1, 2 };
		Mesh meshmeyek = Renderer.createMesh(vertices, indices);
		while (!GLFW.glfwWindowShouldClose(window)) {
			GL30.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);
			GL30.glBindVertexArray(meshmeyek.getVaoID());
			GL30.glEnableVertexAttribArray(0);
			GL30.glDrawElements(GL30.GL_TRIANGLES, meshmeyek.getVertexCount(), GL30.GL_UNSIGNED_INT, 0);
			GL30.glDisableVertexAttribArray(0);
			GL30.glBindVertexArray(0);
			GLFW.glfwSwapBuffers(window);
			GLFW.glfwPollEvents();
		}

	}

	public Initializer() {
	}
}
