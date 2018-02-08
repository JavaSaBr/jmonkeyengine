/*
 * Copyright (c) 2009-2014 jMonkeyEngine
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.renderer.opengl;

import java.nio.IntBuffer;

/**
 * GL functions only available on vanilla desktop OpenGL 3.0+.
 *
 * @author Kirill Vainer
 */
public interface GL3 extends GL2 {

    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 0x821A;
    public static final int GL_GEOMETRY_SHADER = 0x8DD9;
    public static final int GL_NUM_EXTENSIONS = 0x821D;
    public static final int GL_R8 = 0x8229;
    public static final int GL_R16F = 0x822D;
    public static final int GL_R32F = 0x822E;
    public static final int GL_RG16F = 0x822F;
    public static final int GL_RG32F = 0x8230;
    public static final int GL_RG = 0x8227;
    public static final int GL_RG8 = 0x822B;
    public static final int GL_TEXTURE_SWIZZLE_A = 0x8E45;
    public static final int GL_TEXTURE_SWIZZLE_B = 0x8E44;
    public static final int GL_TEXTURE_SWIZZLE_G = 0x8E43;
    public static final int GL_TEXTURE_SWIZZLE_R = 0x8E42;
    public static final int GL_R8I = 33329;
    public static final int GL_R8UI = 33330;
    public static final int GL_R16I = 33331;
    public static final int GL_R16UI = 33332;
    public static final int GL_R32I = 33333;
    public static final int GL_R32UI = 33334;
    public static final int GL_RG8I = 33335;
    public static final int GL_RG8UI = 33336;
    public static final int GL_RG16I = 33337;
    public static final int GL_RG16UI = 33338;
    public static final int GL_RG32I = 33339;
    public static final int GL_RG32UI = 33340;  
    public static final int GL_RGBA32UI = 36208;
    public static final int GL_RGB32UI = 36209;
    public static final int GL_RGBA16UI = 36214;
    public static final int GL_RGB16UI = 36215;
    public static final int GL_RGBA8UI = 36220;
    public static final int GL_RGB8UI = 36221;
    public static final int GL_RGBA32I = 36226;
    public static final int GL_RGB32I = 36227;
    public static final int GL_RGBA16I = 36232;
    public static final int GL_RGB16I = 36233;
    public static final int GL_RGBA8I = 36238;
    public static final int GL_RGB8I = 36239;
    public static final int GL_RED_INTEGER = 36244;
    public static final int GL_RG_INTEGER = 33320;
    public static final int GL_RGB_INTEGER = 36248;
    public static final int GL_RGBA_INTEGER = 36249;
    public static final int GL_UNIFORM_OFFSET = 0x8A3B;

    /**
     * Accepted by the {@code target} parameters of BindBuffer, BufferData, BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, and GetBufferPointerv.
     */
    public static final int GL_UNIFORM_BUFFER = 0x8A11;

    /**
     * Accepted by the {@code pname} parameter of GetActiveUniformBlockiv.
     */
    public static final int GL_UNIFORM_BLOCK_BINDING = 0x8A3F;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 0x8A40;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 0x8A41;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 0x8A42;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 0x8A43;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 0x8A44;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8A45;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8A46;

    /**
     *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
     *  GetFloatv, and GetDoublev:
     */
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 0x8A2B;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 0x8A2C;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 0x8A2D;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 0x8A2E;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 0x8A2F;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 0x8A30;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 0x8A31;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8A32;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8A33;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 0x8A34;

    /**
     * Accepted by the {@code target} parameters of BindBuffer, BufferData, BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, GetBufferPointerv,
     * BindBufferRange, BindBufferOffset and BindBufferBase.
     */
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8C8E;

    public void glBindFragDataLocation(int param1, int param2, String param3); /// GL3+
    public void glBindVertexArray(int param1); /// GL3+
    public void glDeleteVertexArrays(IntBuffer arrays); /// GL3+
    public void glGenVertexArrays(IntBuffer param1); /// GL3+
    public String glGetString(int param1, int param2); /// GL3+

    /**
     * <p><a target="_blank" href="http://docs.gl/gl4/glGetUniformBlockIndex">Reference Page</a></p>
     *
     * Retrieves the index of a named uniform block.
     *
     * @param program          the name of a program containing the uniform block.
     * @param uniformBlockName an array of characters to containing the name of the uniform block whose index to retrieve.
     * @return the block index.
     */
    public int glGetUniformBlockIndex(int program, String uniformBlockName);

    /**
     * <p><a target="_blank" href="http://docs.gl/gl4/glBindBufferBase">Reference Page</a></p>
     *
     * Binds a buffer object to an indexed buffer target.
     *
     * @param target the target of the bind operation. One of:<br><table><tr><td>{@link #GL_TRANSFORM_FEEDBACK_BUFFER TRANSFORM_FEEDBACK_BUFFER}</td><td>{@link #GL_UNIFORM_BUFFER UNIFORM_BUFFER}</td><td>{@link GL4#GL_ATOMIC_COUNTER_BUFFER ATOMIC_COUNTER_BUFFER}</td><td>{@link GL4#GL_SHADER_STORAGE_BUFFER SHADER_STORAGE_BUFFER}</td></tr></table>
     * @param index  the index of the binding point within the array specified by {@code target}
     * @param buffer a buffer object to bind to the specified binding point
     */
    public void glBindBufferBase(int target, int index, int buffer);
}
