package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.renderer.opengl;

import com.ldtteam.jvoxelizer.client.renderer.opengl.IOpenGlProvider;
import com.ldtteam.jvoxelizer.client.renderer.opengl.util.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Quaternion;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class OpenGlProvider implements IOpenGlProvider
{
    private static final FloatBuffer BUF_FLOAT_16 = BufferUtils.createFloatBuffer(16);

    private static OpenGlProvider ourInstance = new OpenGlProvider();

    public static OpenGlProvider getInstance()
    {
        return ourInstance;
    }

    private OpenGlProvider()
    {
    }

    @Override
    public void disableAlpha()
    {
        GlStateManager.disableAlphaTest();
    }

    @Override
    public void enableAlpha()
    {
        GlStateManager.enableAlphaTest();
    }

    @Override
    public void alphaFunc(final int func, final float ref)
    {
        GlStateManager.alphaFunc(func, ref);
    }

    @Override
    public void enableLighting()
    {
        GlStateManager.enableLighting();
    }

    @Override
    public void disableLighting()
    {
        GlStateManager.disableLighting();
    }

    @Override
    public void enableLight(final int light)
    {
        GlStateManager.enableLight(light);
    }

    @Override
    public void disableLight(final int light)
    {
        GlStateManager.disableLight(light);
    }

    @Override
    public void enableColorMaterial()
    {
        GlStateManager.enableColorMaterial();
    }

    @Override
    public void disableColorMaterial()
    {
        GlStateManager.disableColorMaterial();
    }

    @Override
    public void colorMaterial(final int face, final int mode)
    {
        GlStateManager.colorMaterial(face, mode);
    }

    @Override
    public void glLight(final int light, final int pname, final FloatBuffer params)
    {
        GlStateManager.lightfv(light, pname, params);
    }

    @Override
    public void glLightModel(final int pname, final FloatBuffer params)
    {
        GlStateManager.lightModelfv(pname, params);
    }

    @Override
    public void glNormal3f(final float nx, final float ny, final float nz)
    {
        GlStateManager.normal3f(nx, ny, nz);
    }

    @Override
    public void disableDepth()
    {
        GlStateManager.disableDepthTest();
    }

    @Override
    public void enableDepth()
    {
        GlStateManager.enableDepthTest();
    }

    @Override
    public void depthFunc(final int depthFunc)
    {
        GlStateManager.depthFunc(depthFunc);
    }

    @Override
    public void depthMask(final boolean flagIn)
    {
        GlStateManager.depthMask(flagIn);
    }

    @Override
    public void disableBlend()
    {
        GlStateManager.disableBlend();
    }

    @Override
    public void enableBlend()
    {
        GlStateManager.enableBlend();
    }

    @Override
    public void blendFunc(final SourceFactor srcFactor, final DestinationFactor dstFactor)
    {
        GlStateManager.blendFunc(srcFactor.getFactor(), dstFactor.getFactor());
    }

    @Override
    public void blendFunc(final int srcFactor, final int dstFactor)
    {
        GlStateManager.blendFunc(srcFactor, dstFactor);
    }

    @Override
    public void tryBlendFuncSeparate(
      final SourceFactor srcFactor, final DestinationFactor dstFactor, final SourceFactor srcFactorAlpha, final DestinationFactor dstFactorAlpha)
    {
        GlStateManager.blendFuncSeparate(srcFactor.getFactor(), dstFactor.getFactor(), srcFactorAlpha.getFactor(), dstFactorAlpha.getFactor());
    }

    @Override
    public void tryBlendFuncSeparate(final int srcFactor, final int dstFactor, final int srcFactorAlpha, final int dstFactorAlpha)
    {
        GlStateManager.blendFuncSeparate(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }

    @Override
    public void glBlendEquation(final int blendEquation)
    {
        GlStateManager.blendEquation(blendEquation);
    }

    @Override
    public void enableOutlineMode(final int color)
    {
        GlStateManager.enableOutlineMode(color);
    }

    @Override
    public void disableOutlineMode()
    {
        GlStateManager.disableOutlineMode();
    }

    @Override
    public void enableFog()
    {
        GlStateManager.enableFog();
    }

    @Override
    public void disableFog()
    {
        GlStateManager.disableFog();
    }

    @Override
    public void setFog(final FogMode fogMode)
    {
        GlStateManager.fogMode(fogMode.getCapabilityId());
    }

    @Override
    public void setFogDensity(final float param)
    {
        GlStateManager.fogDensity(param);
    }

    @Override
    public void setFogStart(final float param)
    {
        GlStateManager.fogStart(param);
    }

    @Override
    public void setFogEnd(final float param)
    {
        GlStateManager.fogEnd(param);
    }

    @Override
    public void glFog(final int pname, final FloatBuffer param)
    {
        GlStateManager.fogfv(pname, param);
    }

    @Override
    public void glFogi(final int pname, final int param)
    {
        GlStateManager.fogi(pname, param);
    }

    @Override
    public void enableCull()
    {
        GlStateManager.enableCull();
    }

    @Override
    public void disableCull()
    {
        GlStateManager.disableCull();
    }

    @Override
    public void cullFace(final CullFace cullFace)
    {
        GlStateManager.cullFace(cullFace.getMode());
    }

    @Override
    public void glPolygonMode(final int face, final int mode)
    {
        GlStateManager.polygonMode(face, mode);
    }

    @Override
    public void enablePolygonOffset()
    {
        GlStateManager.enablePolygonOffset();
    }

    @Override
    public void disablePolygonOffset()
    {
        GlStateManager.disablePolygonOffset();
    }

    @Override
    public void doPolygonOffset(final float factor, final float units)
    {
        GlStateManager.polygonOffset(factor, units);
    }

    @Override
    public void enableColorLogic()
    {
        GlStateManager.enableColorLogic();
    }

    @Override
    public void disableColorLogic()
    {
        GlStateManager.disableColorLogic();
    }

    @Override
    public void colorLogicOp(final LogicOp logicOperation)
    {
        GlStateManager.logicOp(logicOperation.getOpcode());
    }

    @Override
    public void colorLogicOp(final int opcode)
    {
        GlStateManager.logicOp(opcode);
    }

    @Override
    public void enableTexGenCoord(final TexGen texGen)
    {
        switch (texGen)
        {
            case S:
                GlStateManager.enableTexGen(GlStateManager.TexGen.S);
                break;
            case T:
                GlStateManager.enableTexGen(GlStateManager.TexGen.T);
                break;
            case R:
                GlStateManager.enableTexGen(GlStateManager.TexGen.R);
                break;
            case Q:
                GlStateManager.enableTexGen(GlStateManager.TexGen.Q);
                break;
        }
    }

    @Override
    public void disableTexGenCoord(final TexGen texGen)
    {
        switch (texGen)
        {
            case S:
                GlStateManager.disableTexGen(GlStateManager.TexGen.S);
                break;
            case T:
                GlStateManager.disableTexGen(GlStateManager.TexGen.T);
                break;
            case R:
                GlStateManager.disableTexGen(GlStateManager.TexGen.R);
                break;
            case Q:
                GlStateManager.disableTexGen(GlStateManager.TexGen.Q);
                break;
        }
    }

    @Override
    public void texGen(final TexGen texGen, final int param)
    {
        switch (texGen)
        {
            case S:
                GlStateManager.texGenMode(GlStateManager.TexGen.S, param);
                break;
            case T:
                GlStateManager.texGenMode(GlStateManager.TexGen.T, param);
                break;
            case R:
                GlStateManager.texGenMode(GlStateManager.TexGen.R, param);
                break;
            case Q:
                GlStateManager.texGenMode(GlStateManager.TexGen.Q, param);
                break;
        }
    }

    @Override
    public void texGen(final TexGen texGen, final int pname, final FloatBuffer params)
    {
        switch (texGen)
        {
            case S:
                GlStateManager.texGenParam(GlStateManager.TexGen.S, pname, params);
                break;
            case T:
                GlStateManager.texGenParam(GlStateManager.TexGen.T, pname, params);
                break;
            case R:
                GlStateManager.texGenParam(GlStateManager.TexGen.R, pname, params);
                break;
            case Q:
                GlStateManager.texGenParam(GlStateManager.TexGen.Q, pname, params);
                break;
        }
    }

    @Override
    public void setActiveTexture(final int texture)
    {
        GlStateManager.activeTexture(texture);
    }

    @Override
    public void enableTexture2D()
    {
        GlStateManager.enableTexture2D();
    }

    @Override
    public void disableTexture2D()
    {
        GlStateManager.disableTexture2D();
    }

    @Override
    public void glTexEnv(final int target, final int parameterName, final FloatBuffer parameters)
    {
        GlStateManager.texEnvfv(target, parameterName, parameters);
    }

    @Override
    public void glTexEnvi(final int target, final int parameterName, final int parameter)
    {
        GlStateManager.texEnvi(target, parameterName, parameter);
    }

    @Override
    public void glTexEnvf(final int target, final int parameterName, final float parameter)
    {
        GlStateManager.texEnvf(target, parameterName, parameter);
    }

    @Override
    public void glTexParameterf(final int target, final int parameterName, final float parameter)
    {
        GlStateManager.texParameterf(target, parameterName, parameter);
    }

    @Override
    public void glTexParameteri(final int target, final int parameterName, final int parameter)
    {
        GlStateManager.texParameteri(target, parameterName, parameter);
    }

    @Override
    public int glGetTexLevelParameteri(final int target, final int level, final int parameterName)
    {
        return GlStateManager.glGetTexLevelParameteri(target, level, parameterName);
    }

    @Override
    public int generateTexture()
    {
        return GlStateManager.generateTexture();
    }

    @Override
    public void deleteTexture(final int texture)
    {
        GlStateManager.deleteTexture(texture);
    }

    @Override
    public void bindTexture(final int texture)
    {
        GlStateManager.bindTexture(texture);
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
        GlStateManager.texImage2D(target, level, internalFormat, width, height, border, format, type, pixels);
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
        GL11.glTexImage2D(target, level, xOffset, yOffset, width, height, format, type, pixels);
    }

    @Override
    public void glCopyTexSubImage2D(final int target, final int level, final int xOffset, final int yOffset, final int x, final int y, final int width, final int height)
    {
        GL11.glCopyTexSubImage2D(target, level, xOffset, yOffset, x, y, width, height);
    }

    @Override
    public void glGetTexImage(final int target, final int level, final int format, final int type, final IntBuffer pixels)
    {
        GL11.glGetTexImage(target, level, format, type, pixels);
    }

    @Override
    public void enableNormalize()
    {
        GlStateManager.enableNormalize();
    }

    @Override
    public void disableNormalize()
    {
        GlStateManager.disableNormalize();
    }

    @Override
    public void shadeModel(final int mode)
    {
        GlStateManager.shadeModel(mode);
    }

    @Override
    public void enableRescaleNormal()
    {
        GlStateManager.enableRescaleNormal();
    }

    @Override
    public void disableRescaleNormal()
    {
        GlStateManager.disableRescaleNormal();
    }

    @Override
    public void viewport(final int x, final int y, final int width, final int height)
    {
        GlStateManager.viewport(x, y, width, height);
    }

    @Override
    public void colorMask(final boolean red, final boolean green, final boolean blue, final boolean alpha)
    {
        GlStateManager.colorMask(red, green, blue, alpha);
    }

    @Override
    public void clearDepth(final double depth)
    {
        GlStateManager.clearDepth(depth);
    }

    @Override
    public void clearColor(final float red, final float green, final float blue, final float alpha)
    {
        GlStateManager.clearColor(red, green, blue, alpha);
    }

    @Override
    public void clear(final int mask)
    {
        GlStateManager.clear(mask);
    }

    @Override
    public void matrixMode(final int mode)
    {
        GlStateManager.matrixMode(mode);
    }

    @Override
    public void loadIdentity()
    {
        GlStateManager.loadIdentity();
    }

    @Override
    public void pushMatrix()
    {
        GlStateManager.pushMatrix();
    }

    @Override
    public void popMatrix()
    {
        GlStateManager.popMatrix();
    }

    @Override
    public void getFloat(final int pname, final FloatBuffer params)
    {
        GlStateManager.getFloatv(pname, params);
    }

    @Override
    public void ortho(final double left, final double right, final double bottom, final double top, final double zNear, final double zFar)
    {
        GlStateManager.ortho(left, right, bottom, top, zNear, zFar);
    }

    @Override
    public void rotate(final float angle, final float x, final float y, final float z)
    {
        GlStateManager.rotatef(angle, x, y, z);
    }

    @Override
    public void scale(final float x, final float y, final float z)
    {
        GlStateManager.scalef(x, y, z);
    }

    @Override
    public void scale(final double x, final double y, final double z)
    {
        GlStateManager.scaled(x, y, z);
    }

    @Override
    public void translate(final float x, final float y, final float z)
    {
        GlStateManager.translatef(x, y, z);
    }

    @Override
    public void translate(final double x, final double y, final double z)
    {
        GlStateManager.translated(x, y, z);
    }

    @Override
    public void multMatrix(final FloatBuffer matrix)
    {
        GlStateManager.multMatrixf(matrix);
    }

    @Override
    public void rotate(final Quaternion quaternionIn)
    {
        multMatrix(quatToGlMatrix(BUF_FLOAT_16, quaternionIn));
    }

    @Override
    public FloatBuffer quatToGlMatrix(final FloatBuffer buffer, final Quaternion quaternionIn)
    {
        buffer.clear();
        float f = quaternionIn.x * quaternionIn.x;
        float f1 = quaternionIn.x * quaternionIn.y;
        float f2 = quaternionIn.x * quaternionIn.z;
        float f3 = quaternionIn.x * quaternionIn.w;
        float f4 = quaternionIn.y * quaternionIn.y;
        float f5 = quaternionIn.y * quaternionIn.z;
        float f6 = quaternionIn.y * quaternionIn.w;
        float f7 = quaternionIn.z * quaternionIn.z;
        float f8 = quaternionIn.z * quaternionIn.w;
        buffer.put(1.0F - 2.0F * (f4 + f7));
        buffer.put(2.0F * (f1 + f8));
        buffer.put(2.0F * (f2 - f6));
        buffer.put(0.0F);
        buffer.put(2.0F * (f1 - f8));
        buffer.put(1.0F - 2.0F * (f + f7));
        buffer.put(2.0F * (f5 + f3));
        buffer.put(0.0F);
        buffer.put(2.0F * (f2 + f6));
        buffer.put(2.0F * (f5 - f3));
        buffer.put(1.0F - 2.0F * (f + f4));
        buffer.put(0.0F);
        buffer.put(0.0F);
        buffer.put(0.0F);
        buffer.put(0.0F);
        buffer.put(1.0F);
        buffer.rewind();
        return buffer;
    }

    @Override
    public void color(final float colorRed, final float colorGreen, final float colorBlue, final float colorAlpha)
    {
        GlStateManager.color4f(colorRed, colorGreen, colorBlue, colorAlpha);
    }

    @Override
    public void color(final float colorRed, final float colorGreen, final float colorBlue)
    {
        GlStateManager.color3f(colorRed, colorGreen, colorBlue);
    }

    @Override
    public void glTexCoord2f(final float sCoord, final float tCoord)
    {
        GL11.glTexCoord2f(sCoord, tCoord);
    }

    @Override
    public void glVertex3f(final float x, final float y, final float z)
    {
        GL11.glVertex3f(x, y, z);
    }

    @Override
    public void resetColor()
    {
        GlStateManager.resetColor();
    }

    @Override
    public void glNormalPointer(final int type, final int stride, final ByteBuffer buffer)
    {
        GlStateManager.normalPointer(type, stride, buffer);
    }

    @Override
    public void glTexCoordPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        GlStateManager.texCoordPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glTexCoordPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        GlStateManager.texCoordPointer(size, type, stride, buffer);
    }

    @Override
    public void glVertexPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        GlStateManager.vertexPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glVertexPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        GlStateManager.vertexPointer(size, type, stride, buffer);
    }

    @Override
    public void glColorPointer(final int size, final int type, final int stride, final int buffer_offset)
    {
        GlStateManager.colorPointer(size, type, stride, buffer_offset);
    }

    @Override
    public void glColorPointer(final int size, final int type, final int stride, final ByteBuffer buffer)
    {
        GlStateManager.colorPointer(size, type, stride, buffer);
    }

    @Override
    public void glDisableClientState(final int cap)
    {
        GlStateManager.disableClientState(cap);
    }

    @Override
    public void glEnableClientState(final int cap)
    {
        GlStateManager.enableClientState(cap);
    }

    @Override
    public void glBegin(final int mode)
    {
        GL11.glBegin(mode);
    }

    @Override
    public void glEnd()
    {
        GL11.glEnd();
    }

    @Override
    public void glDrawArrays(final int mode, final int first, final int count)
    {
        GlStateManager.drawArrays(mode, first, count);
    }

    @Override
    public void glLineWidth(final float width)
    {
        GlStateManager.lineWidth(width);
    }

    @Override
    public void callList(final int list)
    {
        GlStateManager.callList(list);
    }

    @Override
    public void glDeleteLists(final int list, final int range)
    {
        GlStateManager.deleteLists(list, range);
    }

    @Override
    public void glNewList(final int list, final int mode)
    {
        GlStateManager.newList(list, mode);
    }

    @Override
    public void glEndList()
    {
        GlStateManager.endList();
    }

    @Override
    public int glGenLists(final int range)
    {
        return GlStateManager.genLists(range);
    }

    @Override
    public void glPixelStorei(final int parameterName, final int param)
    {
        GlStateManager.pixelStorei(parameterName, param);
    }

    @Override
    public void glReadPixels(final int x, final int y, final int width, final int height, final int format, final int type, final IntBuffer pixels)
    {
        GL11.glReadPixels(x, y, width, height, format, type, pixels);
    }

    @Override
    public int glGetError()
    {
        return GlStateManager.getError();
    }

    @Override
    public String glGetString(final int name)
    {
        return GlStateManager.getString(name);
    }

    @Override
    public void glGetInteger(final int parameterName, final IntBuffer parameters)
    {
        GL11.glGetInteger(parameterName, parameters);
    }

    @Override
    public int glGetInteger(final int parameterName)
    {
        return GL11.glGetInteger(parameterName);
    }

    @Override
    public void disableStandardItemLighting()
    {
        RenderHelper.disableStandardItemLighting();
    }

    @Override
    public void enableStandardItemLighting()
    {
        RenderHelper.enableStandardItemLighting();
    }

    @Override
    public int getOpenGlQuadsRenderMode()
    {
        return GL11.GL_QUADS;
    }

    @Override
    public int getOpenGlLineRenderMode()
    {
        return GL11.GL_LINE;
    }

    @Override
    public void disableScissor()
    {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
        GL11.glPopAttrib();
    }

    @Override
    public void enableScissor(final int x, final int y, final int w, final int h)
    {
        GL11.glPushAttrib(GL11.GL_SCISSOR_BIT);
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor(x, y, w, h);
    }
}
