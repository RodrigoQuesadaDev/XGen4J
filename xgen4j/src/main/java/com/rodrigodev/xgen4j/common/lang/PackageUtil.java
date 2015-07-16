package com.rodrigodev.xgen4j.common.lang;

import java.io.File;

/**
 * Created by Rodrigo Quesada on 25/05/15.
 */
public class PackageUtil {

    public static String toFilePath(String packagePath){
        return packagePath.replace('.', File.separatorChar);
    }
}