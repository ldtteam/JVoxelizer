package com.ldtteam.jvoxelizer.core.exceptions;

public class FeatureNotImplementedException extends RuntimeException
{

    public FeatureNotImplementedException(final String feutureName)
    {
        super("The '" + feutureName + "' feature. Is not available in this Runtime.");
    }
}
