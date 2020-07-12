package com.ahoerr1.witherwasp.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class PathUtil {

    private static Method blockStatesInjector;

    static
    {
        PathUtil.blockStatesInjector = ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "func_221052_a", PointOfInterestType.class);
    }

    public static Set<BlockState> getAllStates(Block block)
    {
        return ImmutableSet.copyOf(block.getStateContainer().getValidStates());
    }

    public static void fixPOITypeBlockStates(PointOfInterestType poiType)
    {
        try
        {
            PathUtil.blockStatesInjector.invoke(null, poiType);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    public static PointOfInterestType pointOfInterestType(String p1, Set<BlockState> p2, int p3, int p4)
    {
        try
        {
            //          Constructor<PointOfInterestType> c = (Constructor<PointOfInterestType>)PointOfInterestType.class.getDeclaredConstructors()[1];
            Constructor<PointOfInterestType> c = PointOfInterestType.class.getDeclaredConstructor(String.class, Set.class, Integer.TYPE, Integer.TYPE);
            c.setAccessible(true);
            return c.newInstance(p1, p2, p3, p4);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
