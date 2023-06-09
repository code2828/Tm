package tm.thulium;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL30;

public class Renderer {
	public class Mesh {

		private int vao;
		private int vertices;

		public Mesh(int vao, int vertex) {
			this.vao = vao;
			this.vertices = vertex;
		}

		public int getVaoID() {
			return vao;
		}

		public int getVertexCount() {
			return vertices;
		}
	}

	private static List<Integer> vaos = new ArrayList<Integer>();
	private static List<Integer> vbos = new ArrayList<Integer>();

	private static FloatBuffer createFloatBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}

	private static IntBuffer createIntBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}

	private static void storeData(int attribute, int dimensions, float[] data) {
		int vbo = GL30.glGenBuffers(); // Creates a VBO ID
		vbos.add(vbo);
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, vbo); // Loads the current VBO to store the data
		FloatBuffer buffer = createFloatBuffer(data);
		GL30.glBufferData(GL30.GL_ARRAY_BUFFER, buffer, GL30.GL_STATIC_DRAW);
		GL30.glVertexAttribPointer(attribute, dimensions, GL30.GL_FLOAT, false, 0, 0);
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, 0); // Unloads the current VBO when done.
	}

	private static void bindIndices(int[] data) {
		int vbo = GL30.glGenBuffers();
		vbos.add(vbo);
		GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, vbo);
		IntBuffer buffer = createIntBuffer(data);
		GL30.glBufferData(GL30.GL_ELEMENT_ARRAY_BUFFER, buffer, GL30.GL_STATIC_DRAW);
	}

	public static Mesh createMesh(float[] positions, int[] indices) {
		int vao = genVAO();
		storeData(0, 3, positions);
		bindIndices(indices);
		GL30.glBindVertexArray(0);
		return new Renderer().new Mesh(vao, indices.length);
	}

	private static int genVAO() {
		int vao = GL30.glGenVertexArrays();
		vaos.add(vao);
		GL30.glBindVertexArray(vao);
		return vao;
	}

//	public static Mesh createMesh(float[] positions, int[] indices) {
//		int vao = genVAO();
//		storeData(0, 3, positions);
//		bindIndices(indices);
//		GL30.glBindVertexArray(0);
//		return new Mesh(vao, indices.length);
//	}
//
//	private static int genVAO() {
//		int vao = GL30.glGenVertexArrays();
//		vaos.add(vao);
//		GL30.glBindVertexArray(vao);
//		return vao;
//	}

}
