package com.ldtteam.jvoxelizer.client.renderer.opengl;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.*;
import org.lwjgl.util.vector.Quaternion;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface IOpenGlProvider
{
    void disableAlpha();

    void enableAlpha();

    void alphaFunc(int func, float ref);

    void enableLighting();

    void disableLighting();

    void enableLight(int light);

    void disableLight(int light);

    void enableColorMaterial();

    void disableColorMaterial();

    void colorMaterial(int face, int mode);

    void glLight(int light, int pname, FloatBuffer params);

    void glLightModel(int pname, FloatBuffer params);

    void glNormal3f(float nx, float ny, float nz);

    void disableDepth();

    void enableDepth();

    void depthFunc(int depthFunc);

    void depthMask(boolean flagIn);

    void disableBlend();

    void enableBlend();

    void blendFunc(SourceFactor srcFactor, DestinationFactor dstFactor);

    void blendFunc(int srcFactor, int dstFactor);

    void tryBlendFuncSeparate(
      SourceFactor srcFactor,
      DestinationFactor dstFactor,
      SourceFactor srcFactorAlpha,
      DestinationFactor dstFactorAlpha);

    void tryBlendFuncSeparate(int srcFactor, int dstFactor, int srcFactorAlpha, int dstFactorAlpha);

    void glBlendEquation(int blendEquation);

    void enableOutlineMode(int color);

    void disableOutlineMode();

    void enableFog();

    void disableFog();

    void setFog(FogMode fogMode);

    void setFogDensity(float param);

    void setFogStart(float param);

    void setFogEnd(float param);

    void glFog(int pname, FloatBuffer param);

    void glFogi(int pname, int param);

    void enableCull();

    void disableCull();

    void cullFace(CullFace cullFace);

    void glPolygonMode(int face, int mode);

    void enablePolygonOffset();

    void disablePolygonOffset();

    void doPolygonOffset(float factor, float units);

    void enableColorLogic();

    void disableColorLogic();

    void colorLogicOp(LogicOp logicOperation);

    void colorLogicOp(int opcode);

    void enableTexGenCoord(TexGen texGen);

    void disableTexGenCoord(TexGen texGen);

    void texGen(TexGen texGen, int param);

    void texGen(TexGen texGen, int pname, FloatBuffer params);

    void setActiveTexture(int texture);

    void enableTexture2D();

    void disableTexture2D();

    void glTexEnv(int target, int parameterName, FloatBuffer parameters);

    void glTexEnvi(int target, int parameterName, int parameter);

    void glTexEnvf(int target, int parameterName, float parameter);

    void glTexParameterf(int target, int parameterName, float parameter);

    void glTexParameteri(int target, int parameterName, int parameter);

    int glGetTexLevelParameteri(int target, int level, int parameterName);

    int generateTexture();

    void deleteTexture(int texture);

    void bindTexture(int texture);

    void glTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, IntBuffer pixels);

    void glTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, IntBuffer pixels);

    void glCopyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height);

    void glGetTexImage(int target, int level, int format, int type, IntBuffer pixels);

    void enableNormalize();

    void disableNormalize();

    void shadeModel(int mode);

    void enableRescaleNormal();

    void disableRescaleNormal();

    void viewport(int x, int y, int width, int height);

    void colorMask(boolean red, boolean green, boolean blue, boolean alpha);

    void clearDepth(double depth);

    void clearColor(float red, float green, float blue, float alpha);

    void clear(int mask);

    void matrixMode(int mode);

    void loadIdentity();

    void pushMatrix();

    void popMatrix();

    void getFloat(int pname, FloatBuffer params);

    void ortho(double left, double right, double bottom, double top, double zNear, double zFar);

    void rotate(float angle, float x, float y, float z);

    void scale(float x, float y, float z);

    void scale(double x, double y, double z);

    void translate(float x, float y, float z);

    void translate(double x, double y, double z);

    void multMatrix(FloatBuffer matrix);

    void rotate(Quaternion quaternionIn);

    FloatBuffer quatToGlMatrix(FloatBuffer buffer, Quaternion quaternionIn);

    void color(float colorRed, float colorGreen, float colorBlue, float colorAlpha);

    void color(float colorRed, float colorGreen, float colorBlue);

    void glTexCoord2f(float sCoord, float tCoord);

    void glVertex3f(float x, float y, float z);

    void resetColor();

    void glNormalPointer(int type, int stride, ByteBuffer buffer);

    void glTexCoordPointer(int size, int type, int stride, int buffer_offset);

    void glTexCoordPointer(int size, int type, int stride, ByteBuffer buffer);

    void glVertexPointer(int size, int type, int stride, int buffer_offset);

    void glVertexPointer(int size, int type, int stride, ByteBuffer buffer);

    void glColorPointer(int size, int type, int stride, int buffer_offset);

    void glColorPointer(int size, int type, int stride, ByteBuffer buffer);

    void glDisableClientState(int cap);

    void glEnableClientState(int cap);

    void glBegin(int mode);

    void glEnd();

    void glDrawArrays(int mode, int first, int count);

    void glLineWidth(float width);

    void callList(int list);

    void glDeleteLists(int list, int range);

    void glNewList(int list, int mode);

    void glEndList();

    int glGenLists(int range);

    void glPixelStorei(int parameterName, int param);

    void glReadPixels(int x, int y, int width, int height, int format, int type, IntBuffer pixels);

    int glGetError();

    String glGetString(int name);

    void glGetInteger(int parameterName, IntBuffer parameters);

    int glGetInteger(int parameterName);

    void disableStandardItemLighting();

    void enableStandardItemLighting();

    int getOpenGlQuadsRenderMode();

    int getOpenGlLineRenderMode();
}
