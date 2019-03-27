package com.ldtteam.jvoxelizer.client.renderer.opengl;

import com.ldtteam.jvoxelizer.client.renderer.opengl.util.*;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import org.lwjgl.util.vector.Quaternion;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * Holder for the IOpenGl provider.
 */
final class IOpenGlProviderHolder extends AbstractHolder<IOpenGlProvider> implements IOpenGlProvider
{
    private static IOpenGlProviderHolder ourInstance = new IOpenGlProviderHolder();

    public static IOpenGlProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IOpenGlProviderHolder()
    {
        super(IOpenGl.class.getName());
    }

    @Override
    public void disableAlpha()
    {
        getProvider().disableAlpha();
    }

    @Override
    public void enableAlpha()
    {
        getProvider().enableAlpha();
    }

    @Override
    public void alphaFunc(final int func, final float ref)
    {
        getProvider().alphaFunc(func, ref);
    }

    @Override
    public void enableLighting()
    {
        getProvider().enableLighting();
    }

    @Override
    public void disableLighting()
    {
        getProvider().disableLighting();
    }

    @Override
    public void enableLight(final int light)
    {
        getProvider().enableLight(light);
    }

    @Override
    public void disableLight(final int light)
    {
        getProvider().disableLight(light);
    }

    @Override
    public void enableColorMaterial()
    {
        getProvider().enableColorMaterial();
    }

    @Override
    public void disableColorMaterial()
    {
        getProvider().disableColorMaterial();
    }

    @Override
    public void colorMaterial(final int face, final int mode)
    {
        getProvider().colorMaterial(face, mode);
    }

    @Override
    public void glLight(final int light, final int pname, final FloatBuffer params)
    {
        getProvider().glLight(light, pname, params);
    }

    @Override
    public void glLightModel(final int pname, final FloatBuffer params)
    {
        getProvider().glLightModel(pname, params);
    }

    @Override
    public void glNormal3f(final float nx, final float ny, final float nz)
    {
        getProvider().glNormal3f(nx, ny, nz);
    }

    @Override
    public void disableDepth()
    {
        getProvider().disableDepth();
    }

    @Override
    public void enableDepth()
    {
        getProvider().enableDepth();
    }

    @Override
    public void depthFunc(final int depthFunc)
    {
        getProvider().depthFunc(depthFunc);
    }

    @Override
    public void depthMask(final boolean flagIn)
    {
        getProvider().depthMask(flagIn);
    }

    @Override
    public void disableBlend()
    {
        getProvider().disableBlend();
    }

    @Override
    public void enableBlend()
    {
        getProvider().enableBlend();
    }

    @Override
    public void blendFunc(final SourceFactor srcFactor, final DestinationFactor dstFactor)
    {
        getProvider().blendFunc(srcFactor, dstFactor);
    }

    @Override
    public void blendFunc(final int srcFactor, final int dstFactor)
    {
        getProvider().blendFunc(srcFactor, dstFactor);
    }

    @Override
    public void tryBlendFuncSeparate(
      final SourceFactor srcFactor, final DestinationFactor dstFactor, final SourceFactor srcFactorAlpha, final DestinationFactor dstFactorAlpha)
    {
        getProvider().tryBlendFuncSeparate(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }

    @Override
    public void tryBlendFuncSeparate(final int srcFactor, final int dstFactor, final int srcFactorAlpha, final int dstFactorAlpha)
    {
        getProvider().tryBlendFuncSeparate(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }

    @Override
    public void glBlendEquation(final int blendEquation)
    {
        getProvider().glBlendEquation(blendEquation);
    }

    @Override
    public void enableOutlineMode(final int color)
    {
        getProvider().enableOutlineMode(color);
    }

    @Override
    public void disableOutlineMode()
    {
        getProvider().disableOutlineMode();
    }

    @Override
    public void enableFog()
    {
        getProvider().enableFog();
    }

    @Override
    public void disableFog()
    {
        getProvider().disableFog();
    }

    @Override
    public void setFog(final FogMode fogMode)
    {
        getProvider().setFog(fogMode);
    }

    @Override
    public void setFogDensity(final float param)
    {
        getProvider().setFogDensity(param);
    }

    @Override
    public void setFogStart(final float param)
    {
        getProvider().setFogStart(param);
    }

    @Override
    public void setFogEnd(final float param)
    {
        getProvider().setFogEnd(param);
    }

    @Override
    public void glFog(final int pname, final FloatBuffer param)
    {
        getProvider().glFog(pname, param);
    }

    @Override
    public void glFogi(final int pname, final int param)
    {
        getProvider().glFogi(pname, param);
    }

    @Override
    public void enableCull()
    {
        getProvider().enableCull();
    }

    @Override
    public void disableCull()
    {
        getProvider().disableCull();
    }

    @Override
    public void cullFace(final CullFace cullFace)
    {
        getProvider().cullFace(cullFace);
    }

    @Override
    public void glPolygonMode(final int face, final int mode)
    {
        getProvider().glPolygonMode(face, mode);
    }

    @Override
    public void enablePolygonOffset()
    {
        getProvider().enablePolygonOffset();
    }

    @Override
    public void disablePolygonOffset()
    {
        getProvider().disablePolygonOffset();
    }

    @Override
    public void doPolygonOffset(final float factor, final float units)
    {
        getProvider().doPolygonOffset(factor, units);
    }

    @Override
    public void enableColorLogic()
    {
        getProvider().enableColorLogic();
    }

    @Override
    public void disableColorLogic()
    {
        getProvider().disableColorLogic();
    }

    @Override
    public void colorLogicOp(final LogicOp logicOperation)
    {
        getProvider().colorLogicOp(logicOperation);
    }

    @Override
    public void colorLogicOp(final int opcode)
    {
        getProvider().colorLogicOp(opcode);
    }

    @Override
    public void enableTexGenCoord(final TexGen texGen)
    {
        getProvider().enableTexGenCoord(texGen);
    }

    @Override
    public void disableTexGenCoord(final TexGen texGen)
    {
        getProvider().disableTexGenCoord(texGen);
    }

    @Override
    public void texGen(final TexGen texGen, final int param)
    {
        getProvider().texGen(texGen, param);
    }

    @Override
    public void texGen(final TexGen texGen, final int pname, final FloatBuffer params)
    {
        getProvider().texGen(texGen, pname, params);
    }

    @Override
    public void setActiveTexture(final int texture)
    {
        getProvider().setActiveTexture(texture);
    }

    @Override
    public void enableTexture2D()
    {
        getProvider().enableTexture2D();
    }

    @Override
    public void disableTexture2D()
    {
        getProvider().disableTexture2D();
    }

    @Override
    public void glTexEnv(final int target, final int parameterName, final FloatBuffer parameters)
    {
        getProvider().glTexEnv(target, parameterName, parameters);
    }

    @Override
    public void glTexEnvi(final int target, final int parameterName, final int parameter)
    {
        getProvider().glTexEnvi(target, parameterName, parameter);
    }

    @Override
    public void glTexEnvf(final int target, final int parameterName, final float parameter)
    {
        getProvider().glTexEnvf(target, parameterName, parameter);
    }

    @Override
    public void glTexParameterf(final int target, final int parameterName, final float parameter)
    {
        getProvider().glTexParameterf(target, parameterName, parameter);
    }

    @Override
    public void glTexParameteri(final int target, final int parameterName, final int parameter)
    {
        getProvider().glTexParameteri(target, parameterName, parameter);
    }

    @Override
    public int glGetTexLevelParameteri(final int target, final int level, final int parameterName)
    {
        return getProvider().glGetTexLevelParameteri(target, level, parameterName);
    }

    @Override
    public int generateTexture()
    {
        return getProvider().generateTexture();
    }

    @Override
    public void deleteTexture(final int texture)
    {
        getProvider().deleteTexture(texture);
    }

    @Override
    public void bindTexture(final int texture)
    {
        getProvider().bindTexture(texture);
    }

    @Override
    public void glTexImage2D(
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
        getProvider().glTexImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
    }

    @Override
    public void glTexSubImage2D(
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
        getProvider().glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }

    @Override
    public void glCopyTexSubImage2D(final int target, final int level, final int xOffset, final int yOffset, final int x, final int y, final int width, final int height)
    {
        getProvider().glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
    }

    @Override
    public void glGetTexImage(final int target, final int level, final int format, final int type, final IntBuffer pixels)
    {
        getProvider().glGetTexImage(target, level, format, type, pixels);
    }

    @Override
    public void enableNormalize()
    {
        getProvider().enableNormalize();
    }

    @Override
    public void disableNormalize()
    {
        getProvider().disableNormalize();
    }

    @Override
    public void shadeModel(final int mode)
    {
        getProvider().shadeModel(mode);
    }

    @Override
    public void enableRescaleNormal()
    {
        getProvider().enableRescaleNormal();
    }

    @Override
    public void disableRescaleNormal()
    {
        getProvider().disableRescaleNormal();
    }

    @Override
    public void viewport(final int x, final int y, final int width, final int height)
    {
        getProvider().viewport(x, y, width, height);
    }

    @Override
    public void colorMask(final boolean red, final boolean green, final boolean blue, final boolean alpha)
    {
        getProvider().colorMask(red, green, blue, alpha);
    }

    @Override
    public void clearDepth(final double depth)
    {
        getProvider().clearDepth(depth);
    }

    @Override
    public void clearColor(final float red, final float green, final float blue, final float alpha)
    {
        getProvider().clearColor(red, green, blue, alpha);
    }

    @Override
    public void clear(final int mask)
    {
        getProvider().clear(mask);
    }

    @Override
    public void matrixMode(final int mode)
    {
        getProvider().matrixMode(mode);
    }

    @Override
    public void loadIdentity()
    {
        getProvider().loadIdentity();
    }

    @Override
    public void pushMatrix()
    {
        getProvider().pushMatrix();
    }

    @Override
    public void popMatrix()
    {
        getProvider().popMatrix();
    }

    @Override
    public void getFloat(final int pname, final FloatBuffer params)
    {
        getProvider().getFloat(pname, params);
    }

    @Override
    public void ortho(final double left, final double right, final double bottom, final double top, final double zNear, final double zFar)
    {
        getProvider().ortho(left, right, bottom, top, zNear, zFar);
    }

    @Override
    public void rotate(final float angle, final float x, final float y, final float z)
    {
        getProvider().rotate(angle, x, y, z);
    }

    @Override
    public void scale(final float x, final float y, final float z)
    {
        getProvider().scale(x, y, z);
    }

    @Override
    public void scale(final double x, final double y, final double z)
    {
        getProvider().scale(x, y, z);
    }

    @Override
    public void translate(final float x, final float y, final float z)
    {
        getProvider().translate(x, y, z);
    }

    @Override
    public void translate(final double x, final double y, final double z)
    {
        getProvider().translate(x, y, z);
    }

    @Override
    public void multMatrix(final FloatBuffer matrix)
    {
        getProvider().multMatrix(matrix);
    }

    @Override
    public void rotate(final Quaternion quaternionIn)
    {
        getProvider().rotate(quaternionIn);
    }

    @Override
    public FloatBuffer quatToGlMatrix(final FloatBuffer buffer, final Quaternion quaternionIn)
    {
        return getProvider().quatToGlMatrix(buffer, quaternionIn);
    }

    @Override
    public void color(final float colorRed, final float colorGreen, final float colorBlue, final float colorAlpha)
    {
        getProvider().color(colorRed, colorGreen, colorBlue, colorAlpha);
    }

    @Override
    public void color(final float colorRed, final float colorGreen, final float colorBlue)
    {
        getProvider().color(colorRed, colorGreen, colorBlue);
    }

    @Override
    public void glTexCoord2f(final float sCoord, final float tCoord)
    {
        getProvider().glTexCoord2f(sCoord, tCoord);
    }

    @Override
    public void glVertex3f(final float x, final float y, final float z)
    {
        getProvider().glVertex3f(x, y, z);
    }

    @Override
    public void resetColor()
    {
        getProvider().resetColor();
    }

    @Override
    public void glNormalPointer(final int type, final int stride, final ByteBuffer buffer)
    {
        getProvider().glNormalPointer(type, stride, buffer);
    }

    @Override
    public void glTexCoordPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        getProvider().glTexCoordPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glTexCoordPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        getProvider().glTexCoordPointer(size, type, stride, buffer);
    }

    @Override
    public void glVertexPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        getProvider().glVertexPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glVertexPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        getProvider().glVertexPointer(size, type, stride, buffer);
    }

    @Override
    public void glColorPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        getProvider().glColorPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glColorPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        getProvider().glColorPointer(size, type, stride, buffer);
    }

    @Override
    public void glDisableClientState(final int cap)
    {
        getProvider().glDisableClientState(cap);
    }

    @Override
    public void glEnableClientState(final int cap)
    {
        getProvider().glEnableClientState(cap);
    }

    @Override
    public void glBegin(final int mode)
    {
        getProvider().glBegin(mode);
    }

    @Override
    public void glEnd()
    {
        getProvider().glEnd();
    }

    @Override
    public void glDrawArrays(final int mode, final int first, final int count)
    {
        getProvider().glDrawArrays(mode, first, count);
    }

    @Override
    public void glLineWidth(final float width)
    {
        getProvider().glLineWidth(width);
    }

    @Override
    public void callList(final int list)
    {
        getProvider().callList(list);
    }

    @Override
    public void glDeleteLists(final int list, final int range)
    {
        getProvider().glDeleteLists(list, range);
    }

    @Override
    public void glNewList(final int list, final int mode)
    {
        getProvider().glNewList(list, mode);
    }

    @Override
    public void glEndList()
    {
        getProvider().glEndList();
    }

    @Override
    public int glGenLists(final int range)
    {
        return getProvider().glGenLists(range);
    }

    @Override
    public void glPixelStorei(final int parameterName, final int param)
    {
        getProvider().glPixelStorei(parameterName, param);
    }

    @Override
    public void glReadPixels(final int x, final int y, final int width, final int height, final int format, final int type, final IntBuffer pixels)
    {
        getProvider().glReadPixels(x, y, width, height, format, type, pixels);
    }

    @Override
    public int glGetError()
    {
        return getProvider().glGetError();
    }

    @Override
    public String glGetString(final int name)
    {
        return getProvider().glGetString(name);
    }

    @Override
    public void glGetInteger(final int parameterName, final IntBuffer parameters)
    {
        getProvider().glGetInteger(parameterName, parameters);
    }

    @Override
    public int glGetInteger(final int parameterName)
    {
        return getProvider().glGetInteger(parameterName);
    }

    @Override
    public void disableStandardItemLighting()
    {
        getProvider().disableStandardItemLighting();
    }

    @Override
    public void enableStandardItemLighting()
    {
        getProvider().enableStandardItemLighting();
    }

    @Override
    public int getOpenGlQuadsRenderMode()
    {
        return getProvider().getOpenGlQuadsRenderMode();
    }

    @Override
    public int getOpenGlLineRenderMode()
    {
        return getProvider().getOpenGlLineRenderMode();
    }

    @Override
    public void disableScissor()
    {
        getProvider().disableScissor();
    }

    @Override
    public void enableScissor(final int x, final int y, final int w, final int h)
    {
        getProvider().enableScissor(x, y, w, h);
    }
}
