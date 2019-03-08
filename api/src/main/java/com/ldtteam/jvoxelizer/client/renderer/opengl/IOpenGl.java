package com.ldtteam.jvoxelizer.client.renderer.opengl;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.*;
import org.lwjgl.util.vector.Quaternion;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * The OpenGL rendering engine of the game.
 * No comment on the methods.
 *
 * All methods are pretty much self explanatory.
 *
 * Each method is static, since the actual OpenGL methods are static as well.
 */
public interface IOpenGl
{
    static int getOpenGlQuadsRenderMode()
    {
        return IOpenGlProviderHolder.getInstance().getOpenGlQuadsRenderMode();
    }

    static int getOpenGlLineRenderMode()
    {
        return IOpenGlProviderHolder.getInstance().getOpenGlLineRenderMode();
    }

    static void disableAlpha()
    {
        IOpenGlProviderHolder.getInstance().disableAlpha();
    }

    static void enableAlpha()
    {
        IOpenGlProviderHolder.getInstance().enableAlpha();
    }

    static void alphaFunc(final int func, final float ref)
    {
        IOpenGlProviderHolder.getInstance().alphaFunc(func, ref);
    }

    static void enableLighting()
    {
        IOpenGlProviderHolder.getInstance().enableLighting();
    }

    static void disableLighting()
    {
        IOpenGlProviderHolder.getInstance().disableLighting();
    }

    static void enableLight(final int light)
    {
        IOpenGlProviderHolder.getInstance().enableLight(light);
    }

    static void disableLight(final int light)
    {
        IOpenGlProviderHolder.getInstance().disableLight(light);
    }

    static void enableColorMaterial()
    {
        IOpenGlProviderHolder.getInstance().enableColorMaterial();
    }

    static void disableColorMaterial()
    {
        IOpenGlProviderHolder.getInstance().disableColorMaterial();
    }

    static void colorMaterial(final int face, final int mode)
    {
        IOpenGlProviderHolder.getInstance().colorMaterial(face, mode);
    }

    static void glLight(final int light, final int pname, final FloatBuffer params)
    {
        IOpenGlProviderHolder.getInstance().glLight(light, pname, params);
    }

    static void glLightModel(final int pname, final FloatBuffer params)
    {
        IOpenGlProviderHolder.getInstance().glLightModel(pname, params);
    }

    static void glNormal3f(final float nx, final float ny, final float nz)
    {
        IOpenGlProviderHolder.getInstance().glNormal3f(nx, ny, nz);
    }

    static void disableDepth()
    {
        IOpenGlProviderHolder.getInstance().disableDepth();
    }

    static void enableDepth()
    {
        IOpenGlProviderHolder.getInstance().enableDepth();
    }

    static void depthFunc(final int depthFunc)
    {
        IOpenGlProviderHolder.getInstance().depthFunc(depthFunc);
    }

    static void depthMask(final boolean flagIn)
    {
        IOpenGlProviderHolder.getInstance().depthMask(flagIn);
    }

    static void disableBlend()
    {
        IOpenGlProviderHolder.getInstance().disableBlend();
    }

    static void enableBlend()
    {
        IOpenGlProviderHolder.getInstance().enableBlend();
    }

    static void blendFunc(final SourceFactor srcFactor, final DestinationFactor dstFactor)
    {
        IOpenGlProviderHolder.getInstance().blendFunc(srcFactor, dstFactor);
    }

    static void blendFunc(final int srcFactor, final int dstFactor)
    {
        IOpenGlProviderHolder.getInstance().blendFunc(srcFactor, dstFactor);
    }

    static void tryBlendFuncSeparate(
      final SourceFactor srcFactor, final DestinationFactor dstFactor, final SourceFactor srcFactorAlpha, final DestinationFactor dstFactorAlpha)
    {
        IOpenGlProviderHolder.getInstance().tryBlendFuncSeparate(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }

    static void tryBlendFuncSeparate(final int srcFactor, final int dstFactor, final int srcFactorAlpha, final int dstFactorAlpha)
    {
        IOpenGlProviderHolder.getInstance().tryBlendFuncSeparate(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }

    static void glBlendEquation(final int blendEquation)
    {
        IOpenGlProviderHolder.getInstance().glBlendEquation(blendEquation);
    }

    static void enableOutlineMode(final int color)
    {
        IOpenGlProviderHolder.getInstance().enableOutlineMode(color);
    }

    static void disableOutlineMode()
    {
        IOpenGlProviderHolder.getInstance().disableOutlineMode();
    }

    static void enableFog()
    {
        IOpenGlProviderHolder.getInstance().enableFog();
    }

    static void disableFog()
    {
        IOpenGlProviderHolder.getInstance().disableFog();
    }

    static void setFog(final FogMode fogMode)
    {
        IOpenGlProviderHolder.getInstance().setFog(fogMode);
    }

    static void setFogDensity(final float param)
    {
        IOpenGlProviderHolder.getInstance().setFogDensity(param);
    }

    static void setFogStart(final float param)
    {
        IOpenGlProviderHolder.getInstance().setFogStart(param);
    }

    static void setFogEnd(final float param)
    {
        IOpenGlProviderHolder.getInstance().setFogEnd(param);
    }

    static void glFog(final int pname, final FloatBuffer param)
    {
        IOpenGlProviderHolder.getInstance().glFog(pname, param);
    }

    static void glFogi(final int pname, final int param)
    {
        IOpenGlProviderHolder.getInstance().glFogi(pname, param);
    }

    static void enableCull()
    {
        IOpenGlProviderHolder.getInstance().enableCull();
    }

    static void disableCull()
    {
        IOpenGlProviderHolder.getInstance().disableCull();
    }

    static void cullFace(final CullFace cullFace)
    {
        IOpenGlProviderHolder.getInstance().cullFace(cullFace);
    }

    static void glPolygonMode(final int face, final int mode)
    {
        IOpenGlProviderHolder.getInstance().glPolygonMode(face, mode);
    }

    static void enablePolygonOffset()
    {
        IOpenGlProviderHolder.getInstance().enablePolygonOffset();
    }

    static void disablePolygonOffset()
    {
        IOpenGlProviderHolder.getInstance().disablePolygonOffset();
    }

    static void doPolygonOffset(final float factor, final float units)
    {
        IOpenGlProviderHolder.getInstance().doPolygonOffset(factor, units);
    }

    static void enableColorLogic()
    {
        IOpenGlProviderHolder.getInstance().enableColorLogic();
    }

    static void disableColorLogic()
    {
        IOpenGlProviderHolder.getInstance().disableColorLogic();
    }

    static void colorLogicOp(final LogicOp logicOperation)
    {
        IOpenGlProviderHolder.getInstance().colorLogicOp(logicOperation);
    }

    static void colorLogicOp(final int opcode)
    {
        IOpenGlProviderHolder.getInstance().colorLogicOp(opcode);
    }

    static void enableTexGenCoord(final TexGen texGen)
    {
        IOpenGlProviderHolder.getInstance().enableTexGenCoord(texGen);
    }

    static void disableTexGenCoord(final TexGen texGen)
    {
        IOpenGlProviderHolder.getInstance().disableTexGenCoord(texGen);
    }

    static void texGen(final TexGen texGen, final int param)
    {
        IOpenGlProviderHolder.getInstance().texGen(texGen, param);
    }

    static void texGen(final TexGen texGen, final int pname, final FloatBuffer params)
    {
        IOpenGlProviderHolder.getInstance().texGen(texGen, pname, params);
    }

    static void setActiveTexture(final int texture)
    {
        IOpenGlProviderHolder.getInstance().setActiveTexture(texture);
    }

    static void enableTexture2D()
    {
        IOpenGlProviderHolder.getInstance().enableTexture2D();
    }

    static void disableTexture2D()
    {
        IOpenGlProviderHolder.getInstance().disableTexture2D();
    }

    static void glTexEnv(final int target, final int parameterName, final FloatBuffer parameters)
    {
        IOpenGlProviderHolder.getInstance().glTexEnv(target, parameterName, parameters);
    }

    static void glTexEnvi(final int target, final int parameterName, final int parameter)
    {
        IOpenGlProviderHolder.getInstance().glTexEnvi(target, parameterName, parameter);
    }

    static void glTexEnvf(final int target, final int parameterName, final float parameter)
    {
        IOpenGlProviderHolder.getInstance().glTexEnvf(target, parameterName, parameter);
    }

    static void glTexParameterf(final int target, final int parameterName, final float parameter)
    {
        IOpenGlProviderHolder.getInstance().glTexParameterf(target, parameterName, parameter);
    }

    static void glTexParameteri(final int target, final int parameterName, final int parameter)
    {
        IOpenGlProviderHolder.getInstance().glTexParameteri(target, parameterName, parameter);
    }

    static int glGetTexLevelParameteri(final int target, final int level, final int parameterName)
    {
        return IOpenGlProviderHolder.getInstance().glGetTexLevelParameteri(target, level, parameterName);
    }

    static int generateTexture()
    {
        return IOpenGlProviderHolder.getInstance().generateTexture();
    }

    static void deleteTexture(final int texture)
    {
        IOpenGlProviderHolder.getInstance().deleteTexture(texture);
    }

    static void bindTexture(final int texture)
    {
        IOpenGlProviderHolder.getInstance().bindTexture(texture);
    }

    static void glTexImage2D(
      final int target,
      final int level,
      final int internalFormat,
      final int width,
      final int height,
      final int border,
      final int format,
      final int type,
      final IntBuffer pixels)
    {
        IOpenGlProviderHolder.getInstance().glTexImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
    }

    static void glTexSubImage2D(
      final int target,
      final int level,
      final int xOffset,
      final int yOffset,
      final int width,
      final int height,
      final int format,
      final int type,
      final IntBuffer pixels)
    {
        IOpenGlProviderHolder.getInstance().glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }

    static void glCopyTexSubImage2D(final int target, final int level, final int xOffset, final int yOffset, final int x, final int y, final int width, final int height)
    {
        IOpenGlProviderHolder.getInstance().glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
    }

    static void glGetTexImage(final int target, final int level, final int format, final int type, final IntBuffer pixels)
    {
        IOpenGlProviderHolder.getInstance().glGetTexImage(target, level, format, type, pixels);
    }

    static void enableNormalize()
    {
        IOpenGlProviderHolder.getInstance().enableNormalize();
    }

    static void disableNormalize()
    {
        IOpenGlProviderHolder.getInstance().disableNormalize();
    }

    static void shadeModel(final int mode)
    {
        IOpenGlProviderHolder.getInstance().shadeModel(mode);
    }

    static void enableRescaleNormal()
    {
        IOpenGlProviderHolder.getInstance().enableRescaleNormal();
    }

    static void disableRescaleNormal()
    {
        IOpenGlProviderHolder.getInstance().disableRescaleNormal();
    }

    static void viewport(final int x, final int y, final int width, final int height)
    {
        IOpenGlProviderHolder.getInstance().viewport(x, y, width, height);
    }

    static void colorMask(final boolean red, final boolean green, final boolean blue, final boolean alpha)
    {
        IOpenGlProviderHolder.getInstance().colorMask(red, green, blue, alpha);
    }

    static void clearDepth(final double depth)
    {
        IOpenGlProviderHolder.getInstance().clearDepth(depth);
    }

    static void clearColor(final float red, final float green, final float blue, final float alpha)
    {
        IOpenGlProviderHolder.getInstance().clearColor(red, green, blue, alpha);
    }

    static void clear(final int mask)
    {
        IOpenGlProviderHolder.getInstance().clear(mask);
    }

    static void matrixMode(final int mode)
    {
        IOpenGlProviderHolder.getInstance().matrixMode(mode);
    }

    static void loadIdentity()
    {
        IOpenGlProviderHolder.getInstance().loadIdentity();
    }

    static void pushMatrix()
    {
        IOpenGlProviderHolder.getInstance().pushMatrix();
    }

    static void popMatrix()
    {
        IOpenGlProviderHolder.getInstance().popMatrix();
    }

    static void getFloat(final int pname, final FloatBuffer params)
    {
        IOpenGlProviderHolder.getInstance().getFloat(pname, params);
    }

    static void ortho(final double left, final double right, final double bottom, final double top, final double zNear, final double zFar)
    {
        IOpenGlProviderHolder.getInstance().ortho(left, right, bottom, top, zNear, zFar);
    }

    static void rotate(final float angle, final float x, final float y, final float z)
    {
        IOpenGlProviderHolder.getInstance().rotate(angle, x, y, z);
    }

    static void scale(final float x, final float y, final float z)
    {
        IOpenGlProviderHolder.getInstance().scale(x, y, z);
    }

    static void scale(final double x, final double y, final double z)
    {
        IOpenGlProviderHolder.getInstance().scale(x, y, z);
    }

    static void translate(final float x, final float y, final float z)
    {
        IOpenGlProviderHolder.getInstance().translate(x, y, z);
    }

    static void translate(final double x, final double y, final double z)
    {
        IOpenGlProviderHolder.getInstance().translate(x, y, z);
    }

    static void multMatrix(final FloatBuffer matrix)
    {
        IOpenGlProviderHolder.getInstance().multMatrix(matrix);
    }

    static void rotate(final Quaternion quaternionIn)
    {
        IOpenGlProviderHolder.getInstance().rotate(quaternionIn);
    }

    static FloatBuffer quatToGlMatrix(final FloatBuffer buffer, final Quaternion quaternionIn)
    {
        return IOpenGlProviderHolder.getInstance().quatToGlMatrix(buffer, quaternionIn);
    }

    static void color(final float colorRed, final float colorGreen, final float colorBlue, final float colorAlpha)
    {
        IOpenGlProviderHolder.getInstance().color(colorRed, colorGreen, colorBlue, colorAlpha);
    }

    static void color(final float colorRed, final float colorGreen, final float colorBlue)
    {
        IOpenGlProviderHolder.getInstance().color(colorRed, colorGreen, colorBlue);
    }

    static void glTexCoord2f(final float sCoord, final float tCoord)
    {
        IOpenGlProviderHolder.getInstance().glTexCoord2f(sCoord, tCoord);
    }

    static void glVertex3f(final float x, final float y, final float z)
    {
        IOpenGlProviderHolder.getInstance().glVertex3f(x, y, z);
    }

    static void resetColor()
    {
        IOpenGlProviderHolder.getInstance().resetColor();
    }

    static void glNormalPointer(final int type, final int stride, final ByteBuffer buffer)
    {
        IOpenGlProviderHolder.getInstance().glNormalPointer(type, stride, buffer);
    }

    static void glTexCoordPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        IOpenGlProviderHolder.getInstance().glTexCoordPointer(size, type, stride, buffer_offset);
    }

    static void glTexCoordPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        IOpenGlProviderHolder.getInstance().glTexCoordPointer(size, type, stride, buffer);
    }

    static void glVertexPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        IOpenGlProviderHolder.getInstance().glVertexPointer(size, type, stride, buffer_offset);
    }

    static void glVertexPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        IOpenGlProviderHolder.getInstance().glVertexPointer(size, type, stride, buffer);
    }

    static void glColorPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        IOpenGlProviderHolder.getInstance().glColorPointer(size, type, stride, buffer_offset);
    }

    static void glColorPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        IOpenGlProviderHolder.getInstance().glColorPointer(size, type, stride, buffer);
    }

    static void glDisableClientState(final int cap)
    {
        IOpenGlProviderHolder.getInstance().glDisableClientState(cap);
    }

    static void glEnableClientState(final int cap)
    {
        IOpenGlProviderHolder.getInstance().glEnableClientState(cap);
    }

    static void glBegin(final int mode)
    {
        IOpenGlProviderHolder.getInstance().glBegin(mode);
    }

    static void glEnd()
    {
        IOpenGlProviderHolder.getInstance().glEnd();
    }

    static void glDrawArrays(final int mode, final int first, final int count)
    {
        IOpenGlProviderHolder.getInstance().glDrawArrays(mode, first, count);
    }

    static void glLineWidth(final float width)
    {
        IOpenGlProviderHolder.getInstance().glLineWidth(width);
    }

    static void callList(final int list)
    {
        IOpenGlProviderHolder.getInstance().callList(list);
    }

    static void glDeleteLists(final int list, final int range)
    {
        IOpenGlProviderHolder.getInstance().glDeleteLists(list, range);
    }

    static void glNewList(final int list, final int mode)
    {
        IOpenGlProviderHolder.getInstance().glNewList(list, mode);
    }

    static void glEndList()
    {
        IOpenGlProviderHolder.getInstance().glEndList();
    }

    static int glGenLists(final int range)
    {
        return IOpenGlProviderHolder.getInstance().glGenLists(range);
    }

    static void glPixelStorei(final int parameterName, final int param)
    {
        IOpenGlProviderHolder.getInstance().glPixelStorei(parameterName, param);
    }

    static void glReadPixels(final int x, final int y, final int width, final int height, final int format, final int type, final IntBuffer pixels)
    {
        IOpenGlProviderHolder.getInstance().glReadPixels(x, y, width, height, format, type, pixels);
    }

    static int glGetError()
    {
        return IOpenGlProviderHolder.getInstance().glGetError();
    }

    static String glGetString(final int name)
    {
        return IOpenGlProviderHolder.getInstance().glGetString(name);
    }

    static void glGetInteger(final int parameterName, final IntBuffer parameters)
    {
        IOpenGlProviderHolder.getInstance().glGetInteger(parameterName, parameters);
    }

    static int glGetInteger(final int parameterName)
    {
        return IOpenGlProviderHolder.getInstance().glGetInteger(parameterName);
    }

    static void disableStandardItemLighting()
    {
        IOpenGlProviderHolder.getInstance().disableStandardItemLighting();
    }

    static void enableStandardItemLighting()
    {
        IOpenGlProviderHolder.getInstance().enableStandardItemLighting();
    }

    static void disableScissor()
    {
        throw new NotImplementedException();
    }

    static void enableScissor(int x, int y, int w, int h)
    {
        throw new NotImplementedException();
    }
}
