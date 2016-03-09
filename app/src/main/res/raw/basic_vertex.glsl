#version 100
// This matrix member variable provides a hook to manipulate
// the coordinates of the objects that use this vertex shader
uniform mat4 u_MVPMatrix; // A constant representing the combined model/view/projection matrix.

attribute vec4 a_Position; // Per-vertex position information we will pass in.

void main() {
    // the matrix must be included as a modifier of gl_Position
    // Note that the uMVPMatrix factor *must be first* in order
    // for the matrix multiplication product to be correct.
    gl_Position = u_MVPMatrix   //gl_Position is a special variable used to store the final position.
        * a_Position;           // Multiply the vertex by the matrix to get the final point in
                                // normalized screen coordinates.gl_Position is a special variable used to store the final position.
}
